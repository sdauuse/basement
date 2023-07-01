package com.miao.juc.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 同步模式之保护性暂停
 *
 * @author miaoyin
 */
public class GuardedSuspension {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
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
        Object response = guardedObject.get();
        System.out.println("get response lines:" + ((List<String>) response).size());
    }
}

class GuardedObject {
    private Object response;
    private final Object lock = new Object();

    public Object get() {
        synchronized (lock) {
            long timePassed = 0;
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    public void completed(Object response) {
        synchronized (lock) {
            this.response = response;
            lock.notifyAll();
        }
    }
}
