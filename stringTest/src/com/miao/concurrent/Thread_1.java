package com.miao.concurrent;

public class Thread_1 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("sdadas");
        });

        t.start();

        System.out.println("staasfsafsa");
    }

}
