package com.miao.concurrent2;

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();

        Thread t1 = new Thread(() -> {
            room.decrement();
            room.decrement();
        }, "t1");

        Thread t2 = new Thread(() -> {
            room.increment();
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(Room.count);
    }


}

class Room {
    static int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public void print() {
        System.out.println(count);
    }

}
