package com.example.qzq.leetcode;

/**
 * @ClassName : 合并二叉树
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-09-23 15:29
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        recur(t1, t2);
        return t1;
    }

    public void recur(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return;
        if (t1 == null && t2 != null) t1 = new TreeNode(t2.val);

        if (t1 != null && t2 != null) t1.val = t1.val + t2.val;
        if (t1 != null && t2 == null) return;
        recur(t1.left, t2.left);
        recur(t1.right, t2.right);
    }
}