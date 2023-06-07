package com.miao.juc.day1;

public class CreateThread2 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable running");
            }
        };

        Thread t = new Thread(runnable);
        t.start();

        System.out.println("main running");
    }
}
