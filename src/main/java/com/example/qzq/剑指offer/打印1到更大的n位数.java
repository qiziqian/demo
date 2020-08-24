package com.example.qzq.剑指offer;


/**
 * @ClassName : 打印1到更大的n位数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-19 15:40
 */
public class 打印1到更大的n位数 {


    public static void main(String[] args) {
        int[] chars = new int[10];
        chars[0] = 1;
        chars[1] = 2;
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "");
        }
    }

    public int[] printNumbers(int n) {
        int num = 1;
        while (n > 0) {
            num *= 10;
            n--;
        }
        int[] array = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}