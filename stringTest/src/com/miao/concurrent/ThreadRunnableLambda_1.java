package com.miao.concurrent;

public class ThreadRunnableLambda_1 {
    public static void main(String[] args) {

        Runnable runnable = ()-> System.out.println("this is runnable");

        Thread t1 = new Thread(runnable);

        t1.start();


        System.out.println("this is main thread");
    }
}
