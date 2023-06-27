package com.miao.juc.day1;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TimeUnit1 {
    public static void main(String[] args) throws InterruptedException {
        //TimeUnit 与Thread.sleep()可读性比较
        System.out.println(LocalDateTime.now());

        TimeUnit.SECONDS.sleep(1);

        System.out.println(LocalDateTime.now());

        Thread.sleep(1000);
        System.out.println(LocalDateTime.now());
    }
}
