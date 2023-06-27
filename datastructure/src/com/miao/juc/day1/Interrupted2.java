package com.miao.juc.day1;

import java.util.concurrent.TimeUnit;

public class Interrupted2 {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();

        TimeUnit.SECONDS.sleep(3);
        tpt.stop();

    }
}
//两阶段终止模式
class TwoPhaseTermination {
    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                //初始值为false
                boolean flag = current.isInterrupted();
                if (flag) {
                    System.out.println("料理后事");
                    break;
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    //current.interrupt() 如果被打断线程正在 sleep，wait，join 会导致被打断的线程抛出 InterruptedException，
                    // 并清除 打断标记；如果打断的正在运行的线程，则会设置 打断标记；park 的线程被打断，也会设置 打断标记
                    current.interrupt();
                    System.out.println(current.isInterrupted());
                }
            }
        });

        monitor.start();
    }

    public void stop(){
        //interrupt(); 只是做了打断标记，并不是真的强制终止线程执行（但是会进入InterruptedException异常）
        //修改中断标志位，并将调用该方法时程序所处的线程退出阻塞状态，此时会通知到被标记的线程并且调用阻塞处会接受到InterruptedException异常。
        // 这里的阻塞比如是调用了sleep,wait,join方法，线程在等待同步锁的过程不属于本阻塞范畴。
        monitor.interrupt();

    }
}
