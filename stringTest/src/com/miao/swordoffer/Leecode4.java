package com.miao.swordoffer;

import javax.annotation.processing.Processor;

public class Leecode4 {

    public static void main(String[] args) {
        int[] nums1 = {3, 4,5};
        int[] nums2 = {1, 2};
        double medianSortedArrays = findMedianSortedArrays2(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int left = 0;
        int right = 0;
        int[] nums = new int[totalLength / 2 + 1];

        for (int i = 0; i <= totalLength/2 ; i++) {


            if (left<nums1.length && (right>=nums.length || nums1[left] < nums2[right])) {
                nums[i] = nums1[left];
                left++;
            } else if (nums1[left] >= nums2[right]) {
                nums[i] = nums2[right];
                right++;
            }
        }

        if (totalLength % 2 == 0) {
            return (double) (nums[nums.length - 1] + nums[nums.length - 2]) / 2;
        } else {
            return nums[nums.length - 1];
        }

    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int len = num1Length + num2Length;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;

        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < num1Length && (bStart >= num2Length || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }


        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

}
