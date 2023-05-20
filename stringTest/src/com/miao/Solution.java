package com.miao;

@SuppressWarnings("all")
public class Solution {
    public static void main(String[] args) {
        int[] array = {2, 2, 2}; //非空正整数数组
        int[] arr = array.clone(); //复制非空正整数数组
        int S = 2;//目标值
        int count = 0;//有多少种解法

        //用于判断数组元素直接相加是否等于目标值
        if (SumAndMeetS(arr, S)) {
            count++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                arr = transform(arr, j); //将数组中正数依次变为负数，用于穷举
                if (SumAndMeetS(arr, S)) {
                    count++;
                }
            }
            arr = array.clone(); //复制非空正整数数组,用于重新遍历
        }

        System.out.println("一共有" + count + "种组合");
    }


    /**
     * 用于判断数组元素之后是否等于目标值
     *
     * @param arr 数组元素
     * @param S   目标值
     * @return
     */
    public static boolean SumAndMeetS(int[] arr, int S) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum == S) {
            return true;
        }
        return false;
    }

    /**
     * 将正数转为负数
     *
     * @param trans
     * @return
     */
    public static int[] transform(int[] arr, int i) {
        if (arr[i] >= 0) {
            arr[i] = -arr[i];
        }
        return arr;
    }
}
