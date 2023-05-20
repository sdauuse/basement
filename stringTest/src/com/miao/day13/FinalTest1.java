package com.miao.day13;

// final 修饰引用数据类型，记录的地址值不能发生改变，内部的属性值还是可以发生改变的
public class FinalTest1 {
    public static void main(String[] args) {
        final int[] ARR = {1, 2, 3, 4, 50};
        ARR[1] = 4;

        for (int i = 0; i < ARR.length; i++) {
            System.out.println(ARR[i]);
        }
    }
}
