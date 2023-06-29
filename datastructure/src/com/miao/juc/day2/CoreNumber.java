package com.miao.juc.day2;

public class CoreNumber {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }
}
