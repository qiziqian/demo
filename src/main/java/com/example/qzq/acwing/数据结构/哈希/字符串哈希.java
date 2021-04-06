package com.example.qzq.acwing.数据结构.哈希;

import java.util.Scanner;

/**
 * @ClassName : 字符串哈希
 * @Author : qiziqian
 * @Description: 字符串前缀哈希法,
 * @Date: 2021-04-06 15:42
 */
public class 字符串哈希 {

    /*
        假定运气足够好,就不需要考虑哈希冲突

        P=131 || 13331   Q =2的64次方  这样取,基本可以认为不会出现hash冲突

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();
        StrMap strMap = new StrMap(str);
        while (m-- > 0) {
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            if (strMap.get(l1, r1) == strMap.get(l2, r2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    public static class StrMap {

        int N = 100010;
        int P = 131;

        long[] h = new long[N];
        long[] p = new long[N];

        public StrMap(String str) {
            p[0] = 1;
            for (int i = 1; i <= str.length(); i++) {
                h[i] = h[i - 1] * P + str.charAt(i - 1);
                p[i] = p[i - 1] * P;
            }

        }


        public long get(int l, int r) {
            return h[r] - h[l - 1] * p[r - l + 1];
        }
    }


}