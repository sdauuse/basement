package com.miao.swordoffer;

public class Leecode11 {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea2(heights);
        System.out.println(i);
    }

    // 双指针求解
    public static int maxArea2(int[] height) {

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int len = 0;
        while (left < right) {
            len = right - left;
            sum = Math.min(height[left], height[right]) * len;
            if (sum > max) {
                max = sum;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }


    // 暴力求解
    public static int maxArea(int[] height) {

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int iIndex = i + 1;
            for (int j = i + 1; j < height.length; j++) {
                int jIndex = j + 1;
                int len = jIndex - iIndex;
                int sum = Math.min(height[j], height[i]) * len;
                if (sum > max) {
                    max = sum;
                }
            }
        }


        return max;
    }
}
