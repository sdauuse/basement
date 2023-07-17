package com.miao.juc.day7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinTest1 extends RecursiveTask<Integer> {
    int begin;
    int end;

    public ForkAndJoinTest1(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + "," + end + '}';
    }

    @Override
    protected Integer compute() {

        if (begin == end) {
            System.out.println("join() " + begin);
            return begin;
        }

        if (end - begin == 1) {
            System.out.println("join() begin=" + begin + " end=" + end + " end+begin=" + (end + begin));
            return end + begin;
        }

        // 1 5
        // 3
        int mid = (end + begin) / 2;
        // 1,3
        ForkAndJoinTest1 t1 = new ForkAndJoinTest1(begin, mid);
        t1.fork();
        // 4,5
        ForkAndJoinTest1 t2 = new ForkAndJoinTest1(mid + 1, end);
        t2.fork();
        System.out.println("fork() " + t1 + t2 + " t1+t2=?");


        int result = t1.join() + t2.join();
        System.out.println("fork() " + t1 + t2 + " t1+t2=result=" + result);
        return result;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new ForkAndJoinTest1(1, 10)));
    }
}
