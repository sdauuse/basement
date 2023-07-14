package com.miao.juc.day5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReference1 {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start......");
        // 获取值 A
        // 这个共享变量被其他线程修改过？
        String prev = ref.getReference();
        int stamp = ref.getStamp();
        other();

        TimeUnit.SECONDS.sleep(1);


        System.out.println("main 版本号 " + stamp);
        //尝试修改为C
        System.out.println("changeA -> C = " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
    }

    public static void other() {
        new Thread(() -> {
            //获取版本号
            int stamp = ref.getStamp();
            System.out.println("t1版本号" + stamp);
            System.out.println("change A->B = " + ref.compareAndSet(ref.getReference(), "B", stamp, stamp + 1));

        }, "t1").start();

        new Thread(() -> {
            //获取版本号
            int stamp = ref.getStamp();
            System.out.println("t2版本号" + stamp);
            System.out.println("change B->A = " + ref.compareAndSet(ref.getReference(), "A", stamp, stamp + 1));

        }, "t2").start();
    }
}
