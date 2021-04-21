package com.example.qzq.acwing.数学知识.约数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName : 最大公约数
 * @Author : qiziqian
 * @Description: 欧几里得/辗转相除法
 * @Date: 2021-04-19 13:21
 */
public class 最大公约数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = getGcd(a, b);
            System.out.println(g);

        }
    }

    private static int getGcd(int a, int b) {
        return b != 0 ? getGcd(b, a % b) : a;
    }


}