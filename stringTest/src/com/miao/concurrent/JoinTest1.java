package com.miao.concurrent;

import java.util.concurrent.TimeUnit;

public class JoinTest1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        System.out.println("start join");
        t1.join();

        t2.join();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
