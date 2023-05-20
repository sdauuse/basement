package com.miao.day13;

public class Student extends Person{
    public Student(){
        this("likongyang",24);
    }

    public Student(String name,int age){
        super("liming",23);
        this.name = name;
        this.age = age;
    }
}
