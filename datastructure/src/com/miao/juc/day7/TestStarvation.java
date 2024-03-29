package com.miao.juc.day7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//两个线程池配合使用
public class TestStarvation {

    static final List<String> MENU = Arrays.asList("地三鲜", "宫保鸡丁", "辣子鸡丁", "烤鸡翅");
    static Random RANDOM = new Random();

    static String cooking() {
        return MENU.get(RANDOM.nextInt(MENU.size()));
    }

    public static void main(String[] args) {
        ExecutorService waiterPool = Executors.newFixedThreadPool(1);
        ExecutorService cookPool = Executors.newFixedThreadPool(1);

        waiterPool.execute(() -> {
            System.out.println("处理点餐");
            Future<String> f = cookPool.submit(() -> {
                System.out.println("做菜");
                return cooking();
            });

            try {
                System.out.println("上菜:  " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });


        waiterPool.execute(() -> {
            System.out.println("处理点餐");
            Future<String> f = cookPool.submit(() -> {
                System.out.println("做菜");
                return cooking();
            });
            try {
                System.out.println("上菜: " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
