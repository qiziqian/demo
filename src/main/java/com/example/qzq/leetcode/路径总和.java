package com.example.qzq.leetcode;


import java.util.Arrays;
import java.util.Collections;

/**
 * @Classname 路径总和
 * @Description
 * @Date 2019/12/19 15:51
 * @Created by qiziqian
 */
public class 路径总和 {
    public static void main(String[] args) {
        Arrays.asList(1, 2);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }

    public static boolean helper(TreeNode root, int count, int sum) {
        count += root.val;
        if (root.left == null && root.right == null) {
            if (count == sum) {
                return true;
            } else {
                return false;
            }
        }
        boolean helper = helper(root.left, count, sum);
        boolean helper1 = helper(root.right, count, sum);
        return helper || helper1;
    }
}
