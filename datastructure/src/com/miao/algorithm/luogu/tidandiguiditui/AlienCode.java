package com.miao.algorithm.luogu.tidandiguiditui;

import java.util.Scanner;

public class AlienCode {
    static int index = 0;  //char[] c 的索引

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        sc.close();
        System.out.println(f(s));

    }


    public static String f(char[] c) {

        String s = "", s1;

        while (index < c.length) {
            if (c[index] == '[') {

                //  由题意 '[' 后 ， 是 个位数 或 两位数 (1 ~ 99)
                int D = (int) (c[index + 1] - '0'); //第一位
                int x = (int) (c[index + 2] - '0'); //第二位
                index += 2;
                //如果左括号后第二个字符也是数字
                if (x >= 0 && x <= 9) {
                    D = D * 10 + x;  //两位数
                    index++;  //之前后移了两位，此时后移一位即可
                }

                s1 = f(c); //递归遍历后续内容,获取中括号内的字母序列

                while (D-- > 0) {
                    s += s1;
                }
            } else {
                if (c[index] == ']') {
                    index++;
                    return s; //返回中括号的字母序列
                } else {
                    s += c[index]; //记录的字母序列
                    index++;
                }
            }
        }
        //遍历完了,不要忘了这一句返回
        return s;
    }
}
