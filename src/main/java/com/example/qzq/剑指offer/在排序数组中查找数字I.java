package com.example.qzq.剑指offer;

/**
 * @ClassName : 在排序数组中查找数字I
 * @Author : qiziqian
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @Date: 2020-09-27 11:26
 */
public class 在排序数组中查找数字I {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == target ? 1 : 0;
        int low = 0;
        int high = nums.length - 1;
        int count = 0;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] > target) {
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                count++;
                int right = middle + 1;
                int left = middle - 1;
                while (left >= 0 && nums[left] == target) {
                    left--;
                    count++;
                }
                while (right < nums.length && nums[right] == target) {
                    right++;
                    count++;
                }
                return count;
            }
        }
        return count;
    }
}