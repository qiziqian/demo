package com.example.qzq.acwing.数学知识.约数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName : 约数个数
 * @Author : qiziqian
 * @Description: 所有int范围内的数, 最多的约数个数是1600多
 * @Date: 2021-04-19 10:19
 */
public class 约数个数 {


    static Map<Integer, Integer> primes = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            getYueShuCount(x);
        }

        long mod = (long) (1e9 + 7);
        long res = 1;
        for (Integer value : primes.values()) {
            res *= (value + 1);
            res %= mod;
        }

        System.out.println(res);
    }

    public static void getYueShuCount(int x) {
        for (int i = 2; i <= x / i; i++) {
            while (x % i == 0) {
                primes.put(i, primes.getOrDefault(i, 0) + 1);
                x /= i;
            }

        }
        if (x > 1) primes.put(x, primes.getOrDefault(x, 0) + 1);
    }


}