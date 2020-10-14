package com.example.qzq.剑指offer;

/**
 * @ClassName : 数组中出现次数超过一半的数字
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-22 17:52
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        majorityElement(new int[]{2, 1, 3, 2, 2, 2, 5, 4, 2});
    }

    public static int majorityElement(int[] nums) {
        return Partition1(nums, 0, nums.length - 1);
    }

    private static int Partition1(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            if (pivot > arr[high]) {
                swap(arr, low, high);
            }
            while (low < high && pivot >= arr[low]) {
                low++;
            }
            if (pivot < arr[low]) {
                swap(arr, low, high);
            }

        }
        return arr[high / 2];
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}