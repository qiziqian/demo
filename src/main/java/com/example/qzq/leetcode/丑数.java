package com.example.qzq.leetcode;

/**
 * @Classname 丑数
 * @Description
 * @Date 2019/10/7 20:08
 * @Created by qiziqian
 */
public class 丑数 {
    public static void main(String[] args) {

    }

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}
