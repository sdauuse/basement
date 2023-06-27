package com.miao.juc.day1;

import java.util.concurrent.TimeUnit;

public class Interrupted1 {
    public static void main(String[] args) throws InterruptedException {

        long before = System.currentTimeMillis();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(task, "t1");
        t1.start();
        Thread.sleep(2000);

        long now = System.currentTimeMillis();
        //如果被打断线程正在 sleep，wait，ioin 会导致被打断的线程抛出 InterruptedException并清除 打断标记；
        // 如果打断的正在运行的线程，则会设置 打断标记；park 的线程被打断，也会设置 打断标记
        System.out.println("开始打断");
        t1.interrupt();

        long time = now - before;
        System.out.println("过了多少毫秒" + time);
        //线程在sleep中被打断，t1.isInterrupted()=false
        System.out.println("isInterrupted    " + t1.isInterrupted());
    }
}
