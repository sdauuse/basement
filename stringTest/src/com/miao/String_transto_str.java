package com.miao;

public class String_transto_str {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        String s = arrToString(arr);
        System.out.println(s);
    }

    public static String arrToString(int[] arr) {
        StringBuilder result = new StringBuilder();
        if (arr.length == 0) {
            return "[]";
        } else if (arr.length > 0) {
            result.append("[");
            for (int i = 0; i < arr.length; i++) {
                result.append(arr[i]);
                if (i != arr.length - 1) {
                    result.append(",");
                }
            }
            result.append("]");

        }

        return result.toString();
    }
}
