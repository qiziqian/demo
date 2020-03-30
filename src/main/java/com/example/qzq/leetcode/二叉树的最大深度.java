package com.example.qzq.leetcode;

/**
 * @Classname 二叉树的最大深度
 * @Description
 * @Date 2019/10/8 21:31
 * @Created by qiziqian
 */
public class 二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
