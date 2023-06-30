package com.miao.juc.day2;

import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
    static final Object ROOM = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (ROOM) {

                System.out.println("有烟没？" + hasCigarette);
                while (!hasCigarette) {
                    System.out.println("没烟，先歇会！");
                    try {
                        //2000ms即2s后，会从waitSet中退出
                        ROOM.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟没？" + hasCigarette);
                if (hasCigarette) {
                    System.out.println("可以开始干活了");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (ROOM) {
                Thread thread = Thread.currentThread();
                System.out.println("外卖送到没？" + hasTakeout);
                while (!hasTakeout) {
                    System.out.println("没外卖，先歇会！");
                    try {
                        ROOM.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("外卖送到没？" + hasTakeout);
                if (hasTakeout) {
                    System.out.println("可以开始干活了");
                } else {
                    System.out.println("没干成活...");
                }
            }
        }, "小女").start();


        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (ROOM) {
                hasTakeout = true;
                System.out.println("外卖到了噢！");
                //通知room中随机一个wait线程
                //room.notify();

                //通知room中所有wait线程
                ROOM.notifyAll();
            }
        }, "送外卖的").start();
    }
}
