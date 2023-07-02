package com.miao.juc.day3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignal {
    static final ReentrantLock ROOM = new ReentrantLock();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    //创建cigaretteCondition休息室
    static volatile Condition cigaretteCondition = ROOM.newCondition();
    //创建TakeoutCondition休息室
    static volatile Condition TakeoutCondition = ROOM.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ROOM.lock();
            try {
                System.out.println("有烟没？" + hasCigarette);
                while (!hasCigarette) {
                    System.out.println("没烟，先歇会！");
                    try {
                        //进入cigaretteCondition休息室，有限等待
                        cigaretteCondition.await(2,TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟没？" + hasCigarette);
                if (hasCigarette) {
                    System.out.println("可以开始干活了");
                }
            } finally {
                ROOM.unlock();
            }
        }, "小南").start();

        new Thread(() -> {
            ROOM.lock();
            try {
                Thread thread = Thread.currentThread();
                System.out.println("外卖送到没？" + hasTakeout);
                while (!hasTakeout) {
                    System.out.println("没外卖，先歇会！");
                    try {
                        TakeoutCondition.await();
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
            }finally {
                ROOM.unlock();
            }
        }, "小女").start();


        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                ROOM.lock();
                hasTakeout = true;
                System.out.println("外卖到了噢！");
                //通知room中随机一个wait线程
                //room.notify();

                //通知room中所有wait线程
                TakeoutCondition.signal();
            }finally {
                ROOM.unlock();
            }
        }, "送外卖的").start();
    }
}
