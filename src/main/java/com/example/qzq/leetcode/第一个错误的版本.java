package com.example.qzq.leetcode;

/**
 * @Classname 第一个错误的版本
 * @Description
 * @Date 2020/1/19 17:58
 * @Created by qiziqian
 */
public class 第一个错误的版本 {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int curr = high + (low - high) / 2;
            if (!isBadVersion(curr)) low = curr + 1;
            if (isBadVersion(curr)) {
                while (curr > 0 && isBadVersion(curr)) curr--;
                return curr + 1;
            }
        }
        return 0;
    }

    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version) {
        return true;
    }
}
