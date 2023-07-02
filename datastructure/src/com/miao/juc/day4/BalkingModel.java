package com.miao.juc.day4;

public class BalkingModel {

    public static void main(String[] args) {
        Balking b = new Balking();
        b.start();
        b.start();
    }
}

class Balking {
    private boolean starting = false;
    //监控线程
    private Thread monitorThread;
    //
    private boolean stop = false;

    public void start() {
        System.out.println("尝试启动监控线程");
        synchronized (this) {
            if (starting) {
                return;
            }
            starting = true;
        }


        monitorThread = new Thread(() -> {
            System.out.println("监控线程正在运行");
        }, "monitor");
        monitorThread.start();
    }

    public void stop() {
        stop = true;
        monitorThread.interrupt();
    }
}
