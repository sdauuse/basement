package com.miao.juc.day4;

import java.util.concurrent.TimeUnit;

public class VolatileAndJIT {
    //volatile只能修饰成员变量和静态成员变量,
    //他可以避免线程从自己的工作缓存中查找变量的值，必须到主存中获取它的值，线程操作 volatile 变量都是直接操作主存
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{

            while (flag){

            }
            System.out.println("我退出来了");
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        flag = false;
    }
}
