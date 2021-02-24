package com.example.qzq.leetcode.双指针;

import java.util.Arrays;

/**
 * @ClassName : 非递减数列
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-02-07 09:59
 */
public class 非递减数列 {
    //    public static void main(String[] args) {
//       // [2,1,3,4]
//        System.out.println(check(new int[]{2, 1, 3, 4}));
//        System.out.println(check(new int[]{3,4,5,1,2}));
//        System.out.println(check(new int[]{1,1,1}));
//        System.out.println(check(new int[]{1,2,3}));
//        System.out.println(check(new int[]{6,10,6}));
//        System.out.println(check(new int[]{7,9,1,1,1,3}));
//    }
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }


    //    public static void main(String[] args) {
//        System.out.println(maximumScore(2,4,6));
//        System.out.println(maximumScore(4,4,6));
//        System.out.println(maximumScore(1,8,8));
//        System.out.println(maximumScore(6,2,1));
//    }
    public static int maximumScore(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        int other = a + b + c - max - min;
        if (max >= min + other) {
            return min + other;
        } else {
            int count = 0;
            while (min + other > max) {
                count++;
                min--;
                other--;
            }
            return count + min + Math.min((max - min), other);
        }

    }

    public static void main(String[] args) {
        System.out.println("cbcabaaaaa".equals(largestMerge("cabaa", "bcaaa")));
        System.out.println("abdcabcabcaba".equals(largestMerge("abcabc", "abdcaba")));
    }

    public static String largestMerge(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (word1.charAt(index1) > word2.charAt(index2)) {
                sb.append(word1.charAt(index1));
                index1++;
            } else if (word1.charAt(index1) < word2.charAt(index2)) {
                sb.append(word2.charAt(index2));
                index2++;
            } else {
                int i1 = index1;
                int i2 = index2;
                while (i1 < length1 && i2 < length2 && word1.charAt(i1) == word2.charAt(i2)) {
                    i1++;
                    i2++;
                }
                if (i1 < length1 && i2 < length2) {
                    if (word1.charAt(i1) > word2.charAt(i2)) {
                        sb.append(word1.charAt(index1));
                        index1++;
                    } else if (word1.charAt(i1) < word2.charAt(i2)) {
                        sb.append(word2.charAt(index2));
                        index2++;
                    }
                } else {
                    if (i1 < length1) {
                        sb.append(word1.charAt(index1));
                        index1++;
                    } else if (i2 < length2) {
                        sb.append(word2.charAt(index2));
                        index2++;
                    } else {
                        sb.append(word1.charAt(index1));
                        index1++;
                    }

                }

            }
        }

        while (index1 < length1) {
            sb.append(word1.charAt(index1));
            index1++;
        }
        while (index2 < length2) {
            sb.append(word2.charAt(index2));
            index2++;
        }
        return sb.toString();
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    return false;
                }
            }
        }
        return count <= 1;
    }

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getCount(s, i, i);
            res += getCount(s, i, i + 1);
        }
        return res;
    }

    public int getCount(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            } else {
                break;
            }
        }
        return count;
    }
}