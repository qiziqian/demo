package com.example.qzq.leetcode.双指针;

/**
 * @ClassName : 替换后的最长重复字符
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-02 11:00
 */
public class 替换后的最长重复字符 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int left = 0, right = 0, max = 0, res = 0;

        while (right < n) {
            count[s.charAt(right) - 'A']++;
            max = Math.max(max, count[s.charAt(right) - 'A']);
            while (right - left + 1 - max > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }

    public int characterReplacement2(String s, int k) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(s, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }

        }
        return left;
    }

    public boolean check(String s, int mid, int k) {
        int[] count = new int[26];
        for (int i = 0; i < mid; i++) {
            count[s.charAt(i) - 'A']++;
            if (count[s.charAt(i) - 'A'] + k >= mid) return true;

        }
        for (int i = 0, j = mid; j < s.length(); j++, i++) {
            count[s.charAt(i) - 'A']--;
            count[s.charAt(j) - 'A']--;
            if (count[s.charAt(j) - 'A'] + k >= mid) return true;
        }
        return false;
    }
}