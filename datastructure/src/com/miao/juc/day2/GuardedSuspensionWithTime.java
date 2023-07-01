package com.miao.juc.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 同步模式之保护性暂停 ——带有限时间 类似obj.wait(2000)
 *
 * @author 渺阴
 */
public class GuardedSuspensionWithTime {
    public static void main(String[] args) {
        GuardedObjectWithTime guardedObject = new GuardedObjectWithTime();
        new Thread(() -> {
            // 子线程执行下载
            List<String> response = new ArrayList<>();
            response.add("abc");
            response.add("fsakfnmkfna");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("download complete...");
            guardedObject.completed(response);
        }).start();
        System.out.println("waiting...");
        // 主线程阻塞等待
        Object response = guardedObject.get(2000);
        System.out.println("get response lines:" + ((List<String>) response).size());
    }
}

class GuardedObjectWithTime {
    private Object response;
    private final Object lock = new Object();

    public Object get(long millis) {
        // 1) 记录最初时间
        long begin = System.currentTimeMillis();
        // 2) 已经经历的时间
        long timePassed = 0;
        while (response == null) {
            // 4) 假设 millis 是 1000，结果在 400 时唤醒了，那么还有 600 要等
            long waitTime = millis - timePassed;
            System.out.println("waitTime:" + waitTime);
            if (waitTime <= 0) {
                System.out.println("break...");
                break;
            }
            try {
                lock.wait(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3) 如果提前被唤醒，这时已经经历的时间假设为 400
            timePassed = System.currentTimeMillis() - begin;
        }

        return response;
    }

    public void completed(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            System.out.println("notify...");
            lock.notifyAll();
        }
    }
}