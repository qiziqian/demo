package com.example.qzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 找到所有数组中消失的数字
 * @Description
 * @Date 2019/10/10 15:24
 * @Created by qiziqian
 */
public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
