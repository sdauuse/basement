package com.miao.concurrent;

public class InterruptTwoPhaseModel {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        monitor.start();
        Thread.sleep(1500);
        monitor.stop();
    }
}

class Monitor {

    private Thread monitorThread;

    public void start() {
        monitorThread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();

                //current.isInterrupted()执行完后不会清除打断标志，current.interrupted()执行完后会清除打断标志
                if (current.isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    current.interrupt();
                }
            }
        });

        monitorThread.start();
    }

    public void stop() {
        monitorThread.interrupt();
    }
}
