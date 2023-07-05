package com.miao.juc.day4;

import java.io.Serializable;
//饿汉式单例模式
public class SingletonHungerModel implements Serializable {
    private SingletonHungerModel() {
    }
    private static final SingletonHungerModel singleton = new SingletonHungerModel();

    public static SingletonHungerModel getInstance(){
        return singleton;
    }

    public Object readResolve(){
        return singleton;
    }
}
