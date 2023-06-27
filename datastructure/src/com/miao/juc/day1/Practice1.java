package com.miao.juc.day1;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Practice1 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("正在烧水壶 1分钟");
                    TimeUnit.SECONDS.sleep(1);

                    System.out.println("正在烧开水 15分钟");
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("洗茶壶,洗茶杯,拿茶叶 4分钟");
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("消耗的时间(毫秒): " + time);

    }
}
