package com.miao;

import java.util.StringJoiner;

public class StringBuffer1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("sad");
        sb.append("uuse");

        StringJoiner s = new StringJoiner(",","[","]");

        s.add("aa").add("s");
        System.out.println(s);
        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());
    }
}
