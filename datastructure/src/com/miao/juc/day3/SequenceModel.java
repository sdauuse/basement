package com.miao.juc.day3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceModel {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition waitCondition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                waitCondition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("1");
        }, "t1");

        Thread t2 = new Thread(() -> {

            lock.lock();
            try {
                System.out.println("2");
                waitCondition.signal();
            }finally {
                lock.unlock();
            }
        },"t2");


        t1.start();
        t2.start();
    }
}
