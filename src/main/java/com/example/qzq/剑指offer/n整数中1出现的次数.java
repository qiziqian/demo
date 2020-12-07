package com.example.qzq.剑指offer;

/**
 * @ClassName : n整数中1出现的次数
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-27 13:35
 */
public class n整数中1出现的次数 {

    public int countDigitOne(int n) {
        int high = n / 10;
        int curr = n % 10;
        int low = 0;
        int dight = 0;
        int result = 0;
        while (high != 0) {
            if (curr == 0) {
                result += high * dight;
            } else if (curr == 1) {
                result += high * dight + low + 1;
            } else {
                result += (high + 1) * dight;
            }
            low += curr * dight;
            curr = high % 10;
            high /= 10;
            dight *= 10;
        }
        return result;
    }

}