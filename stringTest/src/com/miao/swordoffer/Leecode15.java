package com.miao.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@SuppressWarnings("all")
public class Leecode15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int left = begin + 1;
        int right = nums.length - 1;
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (; begin < nums.length - 2; begin++) {
            if (nums[begin] > 0) {
                break;
            }

            if (begin > 0 && nums[begin] == nums[begin - 1]) {
                continue; // 去重
            }
            left = begin + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[begin] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> intList = new ArrayList<>();
                    intList.add(nums[begin]);
                    intList.add(nums[left]);
                    intList.add(nums[right]);
                    list.add(intList);
                    left++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }


        return list;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);//排序，nums变成递增数组
        List<List<Integer>> res = new ArrayList<>();
        //k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;//若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if (k > 0 && nums[k] == nums[k - 1]) continue;//nums[k]值重复了，去重
            int i = k + 1, j = nums.length - 1;//定义左右指针
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;//左指针前进并去重
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;//右指针后退并去重
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;//左指针前进并去重
                    while (i < j && nums[j] == nums[--j]) ;//右指针后退并去重
                }
            }
        }
        return res;
    }
}
