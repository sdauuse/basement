package com.miao;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5, 3, 10, 8};
        Map<String,Integer> maxAndMin = getMaxAndMin(arr);

        System.out.println("最大值为" + maxAndMin.get("max"));
        System.out.println("最小值为" + maxAndMin.get("min"));
    }

    public static Map<String, Integer> getMaxAndMin(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        map.put("max", max);
        map.put("min", min);
        return map;
    }


}
