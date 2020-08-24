package com.example.qzq.剑指offer;

/**
 * @ClassName : 调整数组顺序使奇数位于偶数前面
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-20 11:02
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int[] temp = new int[nums.length];
        int head = 0;
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                temp[last--] = nums[i];
            } else {
                temp[head++] = nums[i];
            }
        }
        return temp;
    }

}