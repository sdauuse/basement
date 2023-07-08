package com.miao.juc.day5;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticLockAtomicInteger {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        //++i
        System.out.println(i.incrementAndGet());
        //i++
        System.out.println(i.getAndIncrement());

        System.out.println(i.get());
        System.out.println(i.decrementAndGet());

        System.out.println(i.getAndAdd(5));
        System.out.println(i.addAndGet(5));


    }
}
