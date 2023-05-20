package com.miao.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTask_1 {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("this is future task");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread t = new Thread(futureTask);
        t.start();
    }
}
