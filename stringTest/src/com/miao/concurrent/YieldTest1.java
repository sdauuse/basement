package com.miao.concurrent;

import java.util.concurrent.TimeUnit;

public class YieldTest1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    System.out.println("---->1  " + count++);
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    System.out.println("            ---->2  " + count++);
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
