package com.miao.concurrent;

public class Compose {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("洗水壶");
                Thread.sleep(1000);
                System.out.println("烧热水");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("洗茶杯");
                Thread.sleep(1000);
                System.out.println("洗杯子");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("泡茶叶");
    }
}
