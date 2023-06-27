package com.miao.juc.day1;

import java.util.concurrent.TimeUnit;

public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始运行...");
        Thread t1 = new Thread(() -> {
            System.out.println("守护线程开始运行...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("守护线程运行结束...");
        }, "daemon");
        // 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("运行结束...");
    }
}
