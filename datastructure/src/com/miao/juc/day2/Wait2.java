package com.miao.juc.day2;

import java.util.concurrent.TimeUnit;

public class Wait2 {
    final static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (obj){
                System.out.println("t1 start....");
                try {
                    System.out.println("t1 wait");
                    obj.wait();
                    System.out.println("t1 wake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (obj){
                System.out.println("t2 start...");
                try {
                    System.out.println("t2 wait");
                    obj.wait();
                    System.out.println("t2 wake");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        synchronized (obj){
            obj.notifyAll();
        }
    }
}
