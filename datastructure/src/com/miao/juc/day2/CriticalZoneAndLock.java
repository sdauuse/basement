package com.miao.juc.day2;

public class CriticalZoneAndLock {
    static int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                //对临界区资源加同一把锁
                synchronized (lock) {
                    //临界区
                    for (int i = 0; i < 5000; i++) {
                        count++;
                    }
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                //对临界区资源加同一把锁
                synchronized (lock) {
                    //临界区
                    for (int i = 0; i < 5000; i++) {
                        count--;
                    }
                }
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);
    }
}
