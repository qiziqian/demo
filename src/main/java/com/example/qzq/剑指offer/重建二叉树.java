package com.example.qzq.剑指offer;

import com.example.qzq.leetcode.TreeNode;

/**
 * @ClassName : 重建二叉树
 * @Author : qiziqian
 * @Description: 没做出来
 * @Date: 2020-08-18 15:46
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        int num = array.length;
        int index = 0;
        TreeNode node = new TreeNode();
        //node.left = buildNode(index,num,array);
        while (index < num) {

            index++;
        }

    }

//    public static  TreeNode  buildNode(int index,int num,int[] array ){
//        TreeNode treeNode = new TreeNode(array[index]);
//        if(index*2 < num) treeNode.left = new TreeNode(array[index*2]);
//        if(index*2 < num) treeNode.right = new TreeNode(array[index*2+1]);
//    }

}