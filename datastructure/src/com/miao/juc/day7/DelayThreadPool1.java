package com.miao.juc.day7;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 延迟线程池
 * 让每周四 18:00:00 定时执行任务
 */
public class DelayThreadPool1 {

    public static void main(String[] args) {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // 获取周四时间
        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        System.out.println(time);
        if (now.compareTo(time) > 0) {
            time.plusWeeks(1);
        }

        System.out.println(Duration.between(now, time).toMillis());


        // initailDelay 代表当前时间和周四的时间差
        // period 一周的间隔时间
        long initailDelay = Duration.between(now, time).toMillis();
        long period = 1000 * 60 * 60 * 24 * 7;
        //newScheduledThreadPool 创建反复执行任务的线程池
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("running...");
        }, initailDelay, period, TimeUnit.MILLISECONDS);
    }
}
