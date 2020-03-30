package com.example.qzq.geekbang;

import com.example.qzq.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二叉树的层次遍历II
 * @Description
 * @Date 2019/11/4 10:28
 * @Created by qiziqian
 */
public class 二叉树的层次遍历II {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        rank(root, 0);
        return list;
    }

    public void rank(TreeNode root, int level) {
        if (root == null) return;
        if (list.get(level) == null) {
            list.add(new ArrayList<Integer>());
            list.get(level).add(root.val);
        } else {
            list.get(level).add(root.val);
        }
        rank(root.left, level + 1);
        rank(root.right, level + 1);
    }

}
