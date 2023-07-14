package com.miao.juc.day5;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Unsafe1 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);


        //unsafe操作CAS的方法
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));

        Teacher t = new Teacher();
        unsafe.compareAndSwapInt(t, idOffset, 0, 2);
        unsafe.compareAndSwapObject(t, nameOffset, null, "李四");

        System.out.println(t);
    }
}

class Teacher {
    volatile int id;
    volatile String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}