package com.miao.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_1 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        //增
        arrayList.add("aaaa");
        arrayList.add("bbbb");
        arrayList.add("cccc");
        System.out.println(arrayList);

        //删
        arrayList.remove(0);
        arrayList.remove("bbbb");
        System.out.println(arrayList);
        //改
        arrayList.set(0, "modify");
        System.out.println(arrayList);
        //查
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.size());
    }
}
