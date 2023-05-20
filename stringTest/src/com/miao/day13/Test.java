package com.miao.day13;

public class Test {
    public static void main(String[] args) {
        Person student = new Student();

        if (student instanceof Student){
            Student s = (Student)student;
            System.out.println(s.getClass());
        }

        System.out.println(student.name);
        System.out.println(student.age);
    }
}
