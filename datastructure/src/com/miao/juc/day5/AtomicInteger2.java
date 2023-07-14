package com.miao.juc.day5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class AtomicInteger2 {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);

       /* while (true) {
            int prev = i.get();
            int next = prev * 10;
            if (i.compareAndSet(prev, next)) {
                break;
            }
        }*/

        System.out.println(updateAndGet(i, p -> p / 2));
    }

    //调用IntUnaryOperator接口，实现通用操作的方法
    public static int updateAndGet(AtomicInteger i, IntUnaryOperator operator) {

        while (true) {
            int prev = i.get();
            int next = operator.applyAsInt(prev);
            if (i.compareAndSet(prev, next)) {
                return next;
            }
        }

    }
}
