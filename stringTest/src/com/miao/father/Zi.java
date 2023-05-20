package com.miao.father;

public class Zi extends  Fu{
    String name = "Zi";
    public void ziShow(){
        String name = "ziShow";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

    //子类重写父类的方法，其权限必须大于等于父类方法的权限
    @Override
    public void method(){
        System.out.println("this is zi method");
    }
}
