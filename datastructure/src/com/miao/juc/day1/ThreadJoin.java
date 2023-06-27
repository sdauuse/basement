package com.miao.juc.day1;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {

    static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {

        System.out.println("主线程开始执行");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("sub线程开始执行");
                    TimeUnit.SECONDS.sleep(1);
                    r = 10;
                    System.out.println("sub线程结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task,"t1");
        t1.start();
        //调用Thread中的join()方法，该方法在这里会使得主线程等待子线程结束后，再继续执行
        t1.join();
        System.out.println(r);
        System.out.println("主线程结束执行");
    }
}
