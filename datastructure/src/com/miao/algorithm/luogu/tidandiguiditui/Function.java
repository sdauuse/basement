package com.miao.algorithm.luogu.tidandiguiditui;

import java.util.Scanner;

public class Function {
    static int N = 30;
    static long[][][] record = new long[N][N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        while (a != -1 || b != -1 || c != -1) {
            System.out.print("w(" + a + ", " + b + ", " + c + ") = ");
            if (a > 20) {
                a = 21;
            }
            if (b > 20) {
                b = 21;
            }
            if (c > 20) {
                c = 21;
            }
            Long ans = w((int) a, (int) b, (int) c);
            System.out.println(ans);
            a = sc.nextLong();
            b = sc.nextLong();
            c = sc.nextLong();
        }
    }

    private static Long w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1L;
        } else if (record[a][b][c] != 0) {
            return record[a][b][c];
        } else if (a > 20 || b > 20 || c > 20) {
            record[a][b][c] = w(20, 20, 20);
        } else if (a < b && b < c) {
            record[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        } else {
            record[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        }

        return record[a][b][c];
    }
}
