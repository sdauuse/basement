package com.miao.juc.day3;

public class ExchangeOutput {

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(1);
        Thread t1 = new Thread(()->{
            try {
                wn.print("a",1,2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                wn.print("b",2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                wn.print("c",3,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }


}

class WaitNotify {
    private int flag;
    int loopNumber = 10;

    public WaitNotify(int flag) {
        this.flag = flag;
    }

    //打印
    public void print(String name, int waitFlag, int nextFlag) throws InterruptedException {

        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (flag != waitFlag) {
                    this.wait();
                }
                System.out.print(name);
                flag = nextFlag;
                this.notifyAll();
            }

        }
    }

}
