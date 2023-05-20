package com.miao.swordoffer;

import java.util.HashMap;
import java.util.HashSet;

public class Leecode3 {

    public static void main(String[] args) {
        String s = "abccddd";
        int length = lengthOfLongestSubstring2(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int r = 0, l = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            res = Math.max(res, set.size());
        }

        return res;
    }
}
