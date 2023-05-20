package com.miao.swordoffer;

/**
 * 面试题88：爬楼梯的最少成本
 * 题目：一个数组cost的所有数字都是正数，它的第i个数字表示
 * 在一个楼梯的第i级台阶往上爬的成本，在支付了成本cost[i]之后
 * 可以从第i级台阶往上爬1级或2级。假设台阶至少有2级，既可以从
 * 第0级台阶出发，也可以从第1级台阶出发，请计算爬上该楼梯的最
 * 少成本。例如，输入数组[1，100，1，1，100，1]，则爬上该楼梯
 * 的最少成本是4，分别经过下标为0、2、3、5的这4级台阶
 */
public class Interview88 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 100, 1};
        int len = cost.length - 1;
        int count = minCostRec(cost, len);
        System.out.println("最少成本为:" + count);

        count = DPMinCost(cost);
        System.out.println("动态规划解出的最小成本为:" + count);
    }

    private static int minCostRec(int[] cost, int i) {

        if (i == 0) {
            return cost[0];
        } else if (i == 1) {
            return cost[1];
        } else if (i >= 2) {
            return Math.min(minCostRec(cost, i - 1), minCostRec(cost, i - 2)) + cost[i];
        }

        return -1;
    }

    private static int DPMinCost(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }


}
