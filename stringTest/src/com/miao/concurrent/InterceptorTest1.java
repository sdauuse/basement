package com.miao.concurrent;

public class InterceptorTest1 {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r1);
        System.out.println("start");
        t1.start();

        Thread.sleep(4000);
        System.out.println("interrupt");
        t1.interrupt();

        System.out.println(t1.isInterrupted());
    }
}
