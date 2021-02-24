package com.example.qzq.leetcode.双指针;

/**
 * @ClassName : 最长湍流子数组
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-08 09:48
 */
public class 最长湍流子数组 {


    public static void main(String[] args) {
        maxTurbulenceSize2(new int[]{100, 100, 100});
    }

    public static int maxTurbulenceSize2(int[] arr) {
        int n = arr.length;
        int res = 0;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                down += up;
                up = 1;
            } else if (arr[i] < arr[i - 1]) {
                up += down;
                down = 1;
            } else {
                up = down = 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;
        int res = 1;
        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}