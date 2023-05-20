package com.miao;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class Solution3 {
    public static void main(String[] args) {
        //奇数数组
        int[] arr = {1, 3, 5, 2, 6, 9, 10, 20, 30};

        //偶数数组
        //int[] arr = {1, 3, 5, 2, 6, 9, 10, 20};
        Map<String, Integer> map = new HashMap<>();
        int lastIndex = arr.length - 1;
        //判断是奇数还是偶数
        if (arr.length % 2 == 0) {
            map = getMaxAndMin(arr);
            System.out.println("最大值为" + map.get("max"));
            System.out.println("最小值为" + map.get("min"));
        } else {
            map = getMaxAndMin(arr);
            Integer max = map.get("max");
            Integer min = map.get("min");
            if (max < arr[lastIndex]) {
                max = arr[lastIndex];

            } else if (min > arr[lastIndex]) {
                min = arr[lastIndex];
            }

            System.out.println("最大值为" + max);
            System.out.println("最小值为" + min);
        }


    }

    public static Map<String, Integer> getMaxAndMin(int[] arr) {

        Map<String, Integer> map = new HashMap<>();
        int k = arr.length / 2;

        for (int i = 0; i < k; i++) {
            //后半部分的元素比前半部分的元素大，就交换
            if (arr[i] < arr[i + k]) {
                int temp = arr[i];
                arr[i] = arr[i + k];
                arr[i + k] = temp;
            }
        }
        int max = arr[0];
        int min = arr[k];
        for (int i = 1; i < k; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i + k] < min) {
                min = arr[i + k];
            }
        }

        map.put("max", max);
        map.put("min", min);
        return map;
    }

}
