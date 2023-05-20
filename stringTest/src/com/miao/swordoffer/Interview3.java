package com.miao.swordoffer;

/**
 * 题目：输入一个非负数n，请计算0到n之间每个数字的二进制形
 * 式中1的个数，并输出一个数组。例如，输入的n为4，由于0、1、
 * 2、3、4的二进制形式中1的个数分别为0、1、1、2、1，因此输出数
 * 组[0，1，1，2，1]。
 *
 * @author miaoyin
 */
public class Interview3 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int[] result = countBinary(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    private static int[] countBinary(int[] array) {
        int[] result = new int[array.length];

        for (int i = 1; i < array.length; i++) {
            result[i] = result[i >> 1] + (array[i] & 1);
        }

        return result;
    }
}
