package com.miao.juc.day8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(()->{
            try {
                System.out.println("t1 begin ....");
                TimeUnit.SECONDS.sleep(1);
                latch.countDown();
                System.out.println("t1 end.... " + latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                System.out.println("t2 begin ....");
                TimeUnit.SECONDS.sleep(1);
                latch.countDown();
                System.out.println("t2 end.... " + latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(()->{
            try {
                System.out.println("t3 begin ....");
                TimeUnit.SECONDS.sleep(1);
                latch.countDown();
                System.out.println("t3 end.... " + latch.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();

        System.out.println("main waiting...");
        latch.await();
        System.out.println("main wait end...");
    }
}
