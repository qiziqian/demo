package com.example.qzq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : 分割数组为连续子序列
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-04 11:18
 */
public class 分割数组为连续子序列 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap();
        Map<Integer, Integer> preEndMap = new HashMap();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (countMap.get(num) <= 0) continue;
            if (preEndMap.get(num - 1) > 0) {
                countMap.put(num, countMap.get(num) - 1);
                preEndMap.put(num - 1, preEndMap.get(num - 1) - 1);
                preEndMap.put(num, preEndMap.get(num) + 1);
            } else {
                if (countMap.get(num + 1) > 0 && countMap.get(num + 2) > 0) {
                    countMap.put(num, countMap.get(num) - 1);
                    countMap.put(num + 1, countMap.get(num + 1) - 1);
                    countMap.put(num + 2, countMap.get(num + 2) - 1);
                    preEndMap.put(num + 2, preEndMap.get(num + 2) + 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}