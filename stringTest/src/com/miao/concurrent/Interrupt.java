package com.miao.concurrent;

//打断 sleep，wait，join 的线程这几个方法都会让线程进入阻塞状态
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           while (true){
               boolean interrupted = Thread.currentThread().isInterrupted();
               if (interrupted){
                   System.out.println("被打断了，退出循环");
                   break;
               }
           }
        });

        t1.start();

        Thread.sleep(1000);
        System.out.println("interrupt");
        t1.interrupt();


    }

}
