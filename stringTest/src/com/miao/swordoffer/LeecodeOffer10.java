package com.miao.swordoffer;

public class LeecodeOffer10 {
    public static void main(String[] args) {
        int fib = fib(45);
        System.out.println(fib);
    }

    public static int fib(int n) {

        if (n < 0) {
            return 0;
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        if (n >= 1) {
            f[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n] % 1000000007;
    }
}
