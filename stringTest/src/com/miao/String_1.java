package com.miao;


//字符串的内容是不会改变的，它的对象在创建后不能被更改
public class String_1 {
    public static void main(String[] args) {
        String s1 = "lky";
        System.out.println(s1);
        s1 = "miaoyin";


        System.out.println(s1);


        char[] c1 = {'a', 'b', 'c', 'd'};
        String s2 = new String(c1);
        System.out.println(s2);

        byte[] b1 = {97,98,33,44};
        String s3 = new String(b1);
        System.out.println(s3);
    }
}
