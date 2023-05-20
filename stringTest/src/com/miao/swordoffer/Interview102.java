package com.miao.swordoffer;

/**
 * 题目：给定一个非空的正整数数组和一个目标值S，如果为每个
 * 数字添加“+”或“-”运算符，请计算有多少种方法可以使这些整
 * 数的计算结果为S。例如，如果输入数组[2，2，2]并且S等于2，有3
 * 种添加“+”或“-”的方法使结果为2，它们分别是2+2-2=2、2-
 * 2+2=2及-2+2+2=2。
 */
public class Interview102 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        int target = 2;
        int count = findTargetSumWays(nums, target);
        System.out.println("一共有" + count + "种可能");
    }

    public static int findTargetSumWays(int[] nums, int target) {
        // 动态规划
        int n = nums.length;
        int sum = 0;
        // 将正整数数组中的所有数进行求和
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // pos = (sum+target)/2
        // 将原问题进行转化
        int posSum = (target + sum) % 2 == 0 ? (target + sum) / 2 : 0;
        // 进行边界条件判定
        // 如果目标值target + 正整数总和有余数，那说明找不到一种组合为目标值，直接返回。
        if ((target + sum) % 2 != 0 || sum < target) {
            return 0;
        }

        // 定义前i个数选取某些元素组成和为j的个数
        // n*pos
        int[][] dp = new int[n + 1][posSum + 1];

        // 缓存数组初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 状态转移 n*pos
        for (int i = 1; i <= n; i++) {
            //这里j是从0开始的
            for (int j = 0; j <= posSum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][posSum];
    }

}
