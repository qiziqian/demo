package com.example.qzq.leetcode.双指针;

/**
 * @ClassName : K连续位的最小翻转次数
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-18 10:37
 */
public class K连续位的最小翻转次数 {

    static class Solution {
        public static void main(String[] args) {
            minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3);
        }

        public static int minKBitFlips(int[] A, int K) {
            int n = A.length;
            int ans = 0, revertCount = 0;
            int[] diff = new int[n + 1];
            for (int i = 0; i < n; i++) {
                revertCount += diff[i];
                if ((A[i] + revertCount) % 2 == 0) {
                    if (i + K > n) return -1;
                    ans++;
                    revertCount++;
                    diff[i + K]--;
                }
            }
            return ans;
        }
    }

}