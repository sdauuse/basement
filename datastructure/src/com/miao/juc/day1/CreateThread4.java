package com.miao.juc.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //FutureTask实现了RunnableFuture接口，RunnableFuture接口中继承了Runnable, Future接口
        //泛型为call方法返回的类型
        FutureTask<Integer> task = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("subTread running");
                //线程睡眠1s
                Thread.sleep(1000);
                return 1000;
            }
        });


        Thread t1 = new Thread(task, "t1");
        t1.start();

        //FutureTask的方式，可以得到call()方法的返回值,通过FutureTask中的get()方法得到
        //主线程会阻塞
        Integer res = task.get();
        System.out.println(res);

        System.out.println("main running");
    }
}
