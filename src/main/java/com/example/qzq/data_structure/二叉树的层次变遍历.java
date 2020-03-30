package com.example.qzq.data_structure;

import com.example.qzq.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 二叉树的层次变遍历
 * @Description
 * @Date 2019/11/10 14:08
 * @Created by qiziqian
 */
public class 二叉树的层次变遍历 {
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        helper(root, 0);
        Collections.reverse(list);
        return list;
    }

    public void helper(TreeNode node, int level) {
        if (list.size() <= level + 1) list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
}
