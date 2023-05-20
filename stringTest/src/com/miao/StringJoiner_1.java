package com.miao;

import java.util.StringJoiner;

public class StringJoiner_1 {
    public static void main(String[] args) {
        //分隔符是,
        StringJoiner sjo = new StringJoiner(",");
        sjo.add("a").add("b").add("c");


        //分隔符是,   开始是[    结束是]
        StringJoiner sjo2 = new StringJoiner(",","[","]");
        sjo2.add("a").add("b").add("c");


        System.out.println(sjo);
        System.out.println(sjo.length());
        System.out.println(sjo2);
        System.out.println(sjo2.length());


    }
}
