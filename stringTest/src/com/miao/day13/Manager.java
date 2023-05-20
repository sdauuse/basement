package com.miao.day13;

public class Manager extends Emp{
    public double managerMoney;

    @Override
    public void work() {
        System.out.println("管理其他人");
    }
}
