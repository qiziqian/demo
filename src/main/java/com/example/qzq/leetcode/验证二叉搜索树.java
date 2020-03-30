package com.example.qzq.leetcode;

/**
 * @Classname 验证二叉搜索树
 * @Description
 * @Date 2019/12/19 15:06
 * @Created by qiziqian
 */
public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        int val = node.val;
        if (!helper(node.left, lower, val)) return false;
        if (!helper(node.right, val, upper)) return false;
        return true;
    }
}
