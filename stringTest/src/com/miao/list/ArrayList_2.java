package com.miao.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_2 {
    public static void main(String[] args) {
        Student stu1 = new Student("miaoyin",22);
        Student stu2 = new Student("lky",23);

        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);

        System.out.println(list.get(0).getName());
        System.out.println(list);
    }
}
