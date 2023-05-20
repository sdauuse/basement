package com.miao;

/**
 * StringBuilder应用场景
 * 1.字符串拼接
 * 2.字符串反转
 */
public class StringBuilder_1 {
    public static void main(String[] args) {
//        String str = "abcccc";
        String str = "abccba";

        StringBuilder sb = new StringBuilder(str);
        String reverseString = sb.reverse().toString();

        if (str.equals(reverseString)){
            System.out.println(str + "是回文");
        }else{
            System.out.println(str + "不是回文");
        }

    }
}
