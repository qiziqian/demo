package com.example.qzq.leetcode;

/**
 * @ClassName : 单调递增的数字
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-15 10:08
 */
public class 单调递增的数字 {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }

    static int sizeOfInt(int x) {
        for (int i = 0; ; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    public static int monotoneIncreasingDigits(int N) {
        if (N <= 10) return N - 1;
        int num = sizeOfInt(N);
        int[] numArray = new int[num];
        for (int i = num - 1; i >= 0; i--) {
            numArray[i] = N % 10;
            N /= 10;
        }
        for (int i = num - 1; i >= 1; i--) {
            if (numArray[i] < numArray[i - 1]) {
                numArray[i - 1]--;

                for (int j = i; j < num; j++) {
                    numArray[i] = 9;
                }
            }

        }
        int result = 0;
        for (int i = 0; i < num; i++) {
            result = result * 10 + numArray[i];
        }
        return result;

    }

}