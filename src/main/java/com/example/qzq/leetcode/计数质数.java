package com.example.qzq.leetcode;


import java.util.Arrays;
import java.util.BitSet;

/**
 * @Classname 计数质数
 * @Description
 * @Date 2020/1/10 16:44
 * @Created by qiziqian
 */
public class 计数质数 {
    public static void main(String[] args) {
    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        BitSet bitSet = new BitSet(n);
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) {
                bitSet.set(j);
            }
        }
        return n - 2 - bitSet.cardinality();
    }
}
