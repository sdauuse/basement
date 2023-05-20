package com.miao;

import java.util.Objects;
import java.util.Scanner;

public class StringApi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String s2 = "abc";

        System.out.println(s==s2);
        System.out.println(s.equals(s2));

        System.out.println(s2.length());

        for (int i = 0; i < s2.length(); i++) {
            System.out.println(s2.charAt(i));
        }
    }
}
