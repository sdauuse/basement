package com.miao.swordoffer;

/**
 * 题目：输入两个表示二进制的字符串，请计算它们的和，并以
 * 二进制字符串的形式输出。例如，输入的二进制字符串分别
 * 是"11"和"10"，则输出"101"。
 *
 * @author miaoyin
 */
public class Interview2 {
    public static void main(String[] args) {
        String number = "110";
        String add = "101";
        String result = binarySum(number, add);

        System.out.println(result);
    }

    private static String binarySum(String number, String add) {
        StringBuilder sb = new StringBuilder();

        int i = number.length() - 1;
        int j = add.length() - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {

            int i1 = number.charAt(i) - '0';
            int i2 = add.charAt(j) - '0';
            int sum = i1 + i2 + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum >= 2 ? 0 : 1;
            sb.append(sum);


            i--;
            j--;
        }

        if (carry > 0) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
