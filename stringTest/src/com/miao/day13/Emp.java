package com.miao.day13;

public abstract class Emp {
    public String id;
    public String name;
    public double salary;

    public abstract void work();

    public void haveDinner(){
        System.out.println("吃米饭");
    }
}
