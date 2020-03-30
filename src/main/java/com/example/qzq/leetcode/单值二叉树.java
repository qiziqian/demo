package com.example.qzq.leetcode;


/**
 * @Classname 单值二叉树
 * @Description
 * @Date 2019/10/7 11:20
 * @Created by qiziqian
 */
public class 单值二叉树 {
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
