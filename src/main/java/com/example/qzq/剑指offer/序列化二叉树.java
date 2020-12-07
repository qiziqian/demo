package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.ListNode;
import com.example.qzq.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : 序列化二叉树
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-10-23 16:03
 */
public class 序列化二叉树 {
    public static void main(String[] args) {


    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }};

        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                stringBuilder.append(treeNode.val + ",");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            } else {
                stringBuilder.append("null,");
            }

        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    //[1,2,3,null,null,4,5]
    public TreeNode deserialize(String data) {
        String[] val = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new ArrayDeque();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (val[index] != "null") {
                node.left = new TreeNode(Integer.parseInt(val[index]));
                queue.add(node.left);
            }
            index++;

            if (val[index] != "null") {
                node.left = new TreeNode(Integer.parseInt(val[index]));
                queue.add(node.right);
            }
            index++;

        }
        return root;
    }
}