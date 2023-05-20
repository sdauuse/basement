package com.miao;

public class String_phone_substring {
    public static void main(String[] args) {
        String phoneNumber = "13192262454";

        //包左不包右
        String start = phoneNumber.substring(0, 3);
        String end = phoneNumber.substring(7);
        phoneNumber = start + "****" + end;
        System.out.println(phoneNumber);
    }
}
