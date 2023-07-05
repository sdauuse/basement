package com.miao.juc.day4;

//懒汉单例模式单锁双检模式
public class SingletonLazyDoubleCheck {

    private SingletonLazyDoubleCheck() {

    }

    private static volatile SingletonLazyDoubleCheck singleton = null;

    public static SingletonLazyDoubleCheck getInstance() {
        if (singleton != null) {
            return singleton;
        }

        synchronized (SingletonLazyDoubleCheck.class) {
            if (singleton != null) {
                return singleton;
            }
            singleton = new SingletonLazyDoubleCheck();
            return singleton;
        }
    }

}
