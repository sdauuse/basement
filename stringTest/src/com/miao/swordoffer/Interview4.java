package com.miao.swordoffer;

/**
 * 题目：输入一个整数数组，数组中只有一个数字出现了一次，
 * 而其他数字都出现了3次。请找出那个只出现一次的数字。例如，如
 * 果输入的数组为[0，1，0，1，0，1，100]，则只出现一次的数字是
 * 100
 */
public class Interview4 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 100};

        int result = countNumber(arr);

        System.out.println("出现一次的数字是" + result);
    }

    private static int countNumber(int[] arr) {

        int[] binSum = new int[32];
        int result = 0;

        for (int number : arr) {
            for (int i = 0; i < binSum.length; i++) {
                binSum[i] += (number >> (31 - i)) & 1;
            }
        }

        for (int i = 0; i < binSum.length; i++) {
            result = (result << 1) + binSum[i] % 3;
        }

        return result;
    }


}
