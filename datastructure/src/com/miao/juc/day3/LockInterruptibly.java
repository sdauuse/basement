package com.miao.juc.day3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            System.out.println("启动...");
            try {
                try {
                    System.out.println("可打断ReentrantLock");
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("等锁的过程中被打断");
                    return;
                }
            } finally {
                lock.unlock();
            }
        }, "t1");


        lock.lock();
        System.out.println("获得了锁");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            t1.interrupt();
            System.out.println("执行打断");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
