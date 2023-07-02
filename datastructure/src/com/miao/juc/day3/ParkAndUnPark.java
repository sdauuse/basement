package com.miao.juc.day3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class ParkAndUnPark {

    public static void main(String[] args) throws InterruptedException {
        testParkAndUnPark();

        testUnParkAndPark();
    }

    //先执行park再执行unpark
    public static void testParkAndUnPark() throws InterruptedException {
        System.out.println("先执行park再执行unpark");
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("start....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("park....");
                //park
                LockSupport.park();
                System.out.println("resume....");
                System.out.println("--------------------------------");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

        t1.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("unpark....");
        //unpark
        LockSupport.unpark(t1);


    }

    //先执行unpark再执行park
    public static void testUnParkAndPark() throws InterruptedException {

        System.out.println("先执行unpark再执行park");

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("start....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("park....");
                //park
                LockSupport.park();
                System.out.println("resume....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

        t1.start();

        System.out.println("unpark....");
        //unpark
        LockSupport.unpark(t1);
    }
}
