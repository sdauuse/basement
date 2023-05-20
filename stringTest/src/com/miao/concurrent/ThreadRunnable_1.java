package com.miao.concurrent;

public class ThreadRunnable_1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };

        Thread thread = new Thread(runnable,"t2");
        thread.start();

        System.out.println("this is main method");
    }
}
