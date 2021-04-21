package com.example.qzq.acwing.数学知识.欧拉函数;

import java.util.Scanner;

/**
 * @ClassName : 欧拉函数
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-04-20 11:06
 */
public class 欧拉函数 {

    /*
    一个数字n,他的欧拉函数为从1~n中与n互质的数的个数
    如何计算个数?
    假设 n=p1α1p2α2p3α3....pnαn
    那么 首先要去掉 p1的倍数,p2的倍数,p3的倍数....pn的倍数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int res = getEuler(x);
            System.out.println(res);
        }
    }

    private static int getEuler(int x) {
        int res = x;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                //res =res *(1-1/i);
                //res =res *((i-1)/i);
                res = res / i * (i - 1);
                while (x % i == 0) x /= i;
            }
        }
        return res;
    }


}