package com.miao.concurrent;

public class DaemonTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
            }
        });

        //将t1设置为守护线程，守护线程是当其他非守护线程结束时，它也会强制结束
        //垃圾回收器就是一种守护线程
        t1.setDaemon(true);
        t1.start();

        Thread.sleep(1000);
    }
}
