package com.example.qzq.编程珠玑.开篇题;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * @ClassName : GenerateRandomNumber
 * @Author : qiziqian
 * @Description: 内存占用
 * @Date: 2020-08-14 11:26
 */
public class GenerateRandomNumber {
    public static void main(String[] args) {
        int[] array = new int[10000000];
        System.out.println("占用的堆内存: " + RamUsageEstimator.shallowSizeOf(array));
        System.out.println("占用的总内存: " + RamUsageEstimator.humanSizeOf(array));
    }

}