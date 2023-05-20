package com.miao.swordoffer;

/**
 * 题目：输入2个int型整数，它们进行除法计算并返回商，要求
 * 不得使用乘号'*'、除号'/'及求余符号'%'。当发生溢出时，返回最
 * 大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结
 * 果，即7。
 *
 * @author miaoyin
 */
public class Interview1 {
    public static void main(String[] args) {
        int dividend = -15;
        int divisor = 2;
        int number = dividend;
        int divisorNumber = divisor;

        int negative = 2;//用于判断最后的正负号
        if (dividend < 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor < 0) {
            negative--;
            divisor = -divisor;
        }

        int count = negative == 1 ? -divide(dividend, divisor) : divide(dividend, divisor);


        System.out.println(number + "/" + divisorNumber + "=" + count);

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;

        while (dividend >= divisor) {
            int value = divisor;
            int quotient = 1;

            while (dividend >= value + value) {
                quotient += quotient;
                value += value;
            }

            result += quotient;
            dividend -= value;
        }

        return result;
    }
}
