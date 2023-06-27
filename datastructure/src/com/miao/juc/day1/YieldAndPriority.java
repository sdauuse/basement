package com.miao.juc.day1;

public class YieldAndPriority {

    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                //Thread.yield();
                while (true) {
                    System.out.println("-------> task1 count=" + count++);
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) {
                    System.out.println("                            --------------------------------------> task2 count=" + count++);
                }
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        //设置优先级1-10 越大优先级越高
        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
