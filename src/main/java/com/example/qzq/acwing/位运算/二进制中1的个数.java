package com.example.qzq.acwing.位运算;

import java.util.Scanner;

/**
 * @ClassName : 二进制中1的个数
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-26 14:45
 */
public class 二进制中1的个数 {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        int[] res  = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = getCount(a[i]);
//            System.out.print(getCount(a[i])+" ");
//        }
        System.out.println(~10);

    }

    private static int getCount(int a) {
        int res = 0;
        while (a > 0) {
            int last = getLowBit(a);
            a -= last;
            res++;
        }

        return res;
    }


    //获取n的二进制的第k位
    //把第K位移动到最后一位,然后&1即可
    public static int getBinaryK(int n, int k) {
        return n >> k & 1;
    }
    //返回数字的最后一位1   作用:计算二进制中1的个数
    // -x = ~x+1

    public static int getLowBit(int x) {
        return x & -x;
    }


}