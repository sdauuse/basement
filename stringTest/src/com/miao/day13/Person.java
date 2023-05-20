package com.miao.day13;

public class Person {
    public String name;
    public int age;
    public Person(){
        System.out.println("this is person constructor");
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
