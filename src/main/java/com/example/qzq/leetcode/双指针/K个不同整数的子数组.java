package com.example.qzq.leetcode.双指针;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : K个不同整数的子数组
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-09 10:00
 */
public class K个不同整数的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct3(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinct3(new int[]{1, 2, 1, 3, 4}, 3));
    }


    //暴力   通不过
    public static int subarraysWithKDistinct2(int[] A, int K) {
        int n = A.length;
        int res = 0;

        for (int right = n - 1; right >= K - 1; right--) {
            int[] set = new int[n];
            int count = 0;
            for (int i = right; i >= 0; i--) {
                if (set[A[i]] == 0) {
                    count++;
                }
                set[A[i]]++;
                if (count > K) {
                    break;
                } else if (count == K) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int subarraysWithKDistinct1(int[] A, int K) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.size();
        int left = 0, right = 0;
        while (right < n) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            right++;
            if (map.size() > K) {
                while (map.size() > K) {
                    map.put(A[left], map.get(A[left]) - 1);
                    if (map.get(A[left]) == 0) map.remove(A[left]);
                }
                res++;
            } else if (map.size() < K) {
                continue;
            } else {
                res++;
            }

        }
        return res;
    }

    public static int subarraysWithKDistinct3(int[] A, int K) {
        return atMostKDistint(A, K) - atMostKDistint(A, K - 1);
    }

    public static int atMostKDistint(int[] a, int k) {
        int n = a.length;
        int left = 0, right = 0;
        int res = 0, count = 0;
        int[] array = new int[n + 1];
        while (right < n) {
            if (array[a[right]] == 0) {
                count++;
            }
            array[a[right]]++;
            right++;

            while (count > k) {
                array[a[left]]--;
                if (array[a[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

}