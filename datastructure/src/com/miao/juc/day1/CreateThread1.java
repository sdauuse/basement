package com.miao.juc.day1;

public class CreateThread1 {
    public static void main(String[] args) {
        Thread t = new Thread("subThread0"){
            @Override
            public void run(){
                System.out.println("subThread0 running");
            }
        };

        t.start();
        System.out.println("main running");
    }
}
