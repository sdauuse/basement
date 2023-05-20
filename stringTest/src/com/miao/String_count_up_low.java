package com.miao;

import java.util.Scanner;

/**
 * 统计字符串中大写、小写、数字个数
 */
public class String_count_up_low {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int upper = 0;
        int lower = 0;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lower = lower + 1;
            } else if (c >= 'A' && c <= 'Z') {
                upper = upper + 1;
            } else if (c >= '0' && c <= '9') {
                number = number + 1;
            }
        }

        System.out.println("upper" + upper);
        System.out.println("lower" + lower);
        System.out.println("number" + number);
    }
}
