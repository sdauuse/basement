package com.miao.juc.day1;

public class CreateThread3 {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("subThread running");
        };

        Thread t = new Thread(runnable);
        t.start();


        System.out.println("主线程在运行");
    }
}
