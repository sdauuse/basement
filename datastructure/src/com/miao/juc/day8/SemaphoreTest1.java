package com.miao.juc.day8;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
public class SemaphoreTest1 {
    public static void main(String[] args) {
        //1 创建semaphore对象
        // 参数3表示3个许可,可以对访问共享资源的个数进行限制
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("running");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("end....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
