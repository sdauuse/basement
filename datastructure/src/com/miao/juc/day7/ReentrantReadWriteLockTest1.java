package com.miao.juc.day7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReentrantReadWriteLockTest1 {

    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read(){
        System.out.println("获取读锁");
        r.lock();
        try {
            System.out.println("读取");
            return data;
        }finally {
            System.out.println("释放读锁");
            r.unlock();
        }
    }

    public void write(){
        System.out.println("获取写锁");
        w.lock();
        try{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("写入");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放读锁");
            w.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantReadWriteLockTest1 readWriteLockTest = new ReentrantReadWriteLockTest1();

        readWriteLockTest.read();

        readWriteLockTest.write();

        readWriteLockTest.read();
        readWriteLockTest.read();
    }
}
