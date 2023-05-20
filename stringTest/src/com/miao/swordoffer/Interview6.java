package com.miao.swordoffer;

/**
 * 题目：输入一个递增排序的数组和一个值k，请问如何在数组中
 * 找出两个和为k的数字并返回它们的下标？假设数组中存在且只存在
 * 一对符合条件的数字，同时一个数字不能使用两次。例如，输入数
 * 组[1，2，4，6，10]，k的值为8，数组中的数字2与6的和为8，它们
 * 的下标分别为1与3。
 */
public class Interview6 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 10, 23, 33, 45, 66, 100};

        countSum(arr);
    }

    private static void countSum(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int target = 30;
        int sum = 0;
        boolean finded = false;
        while (start < end) {
            sum = arr[start] + arr[end];

            if (target == sum) {
                finded = true;
                break;
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }
        }


        if (finded) {
            System.out.println(arr[start] + "+" + arr[end] + "=" + target);
            return;
        }

        System.out.println("没有找到");
    }

}
