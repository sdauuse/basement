package com.miao.concurrent;

import java.util.concurrent.TimeUnit;

public class SleepTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        System.out.println(t.getState());

        //建议用TimeUnit，因为可以选择休眠的时间单位
        TimeUnit.SECONDS.sleep(1);
        //Thread.sleep(500);

        System.out.println(t.getState());
    }
}
