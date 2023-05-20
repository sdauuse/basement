package com.miao;

import java.util.Scanner;

public class String_trans_money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额");
        int money = sc.nextInt();
        while (true) {
            if (money >= 0 && money <= 9999999) {
                break;
            } else {
                System.out.println("您输入的金额无效，请重新输入");
                money = sc.nextInt();
            }
        }
        StringBuilder trans = new StringBuilder();
        while (money != 0) {
            int number = money % 10;
            String temp = getNumber(number);
            trans.append(temp);
            money = money/10;
        }

        System.out.println(trans.reverse());
    }

    public static String getNumber(int number) {
        String[] trans = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        return trans[number];
    }
}
