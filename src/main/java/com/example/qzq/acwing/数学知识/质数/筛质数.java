package com.example.qzq.acwing.数学知识.质数;

import java.util.Scanner;

/**
 * @Description 埃氏筛法/线性筛法
 * @Date 2021/4/17 10:53
 * @Author by qiziqian
 */
public class 筛质数 {


    static int cnt = 0;
    static int N = 1000010;
    static boolean[] st = new boolean[N];
    static int[] primes = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getPrimeCount2(n));
    }


    /**
     * @Author qiziqian
     * @Description 埃氏筛法
     * 时间复杂度O(NloglogN)
     * 只需要把所有质数的倍数都筛掉,剩下的就是质数的数量
     * @Date 2021/4/17
     **/
    private static int getPrimeCount(int x) {
        for (int i = 2; i <= x; i++) {
            if (!st[i]) {
                cnt++;
            }
            for (int j = i + i; j <= x; j += i) {
                st[j] = true;
            }
        }

        return cnt;
    }

    /**
     * @Author qiziqian
     * @Description 线性筛法(欧拉筛法)
     * 时间复杂度O()
     * 只需要把所有质数的倍数都筛掉,剩下的就是质数的数量
     * @Date 2021/4/17
     **/
    private static int getPrimeCount2(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) break;
            }
        }
        return cnt;
    }
}
