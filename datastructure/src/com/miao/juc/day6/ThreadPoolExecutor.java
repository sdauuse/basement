package com.miao.juc.day6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutor {
    public static void main(String[] args) {
        //创建固定大小线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(()->{
            System.out.println("111111");
        });


        pool.execute(()->{
            System.out.println("222222");
        });

        pool.execute(()->{
            System.out.println("3333333");
        });
    }
}
