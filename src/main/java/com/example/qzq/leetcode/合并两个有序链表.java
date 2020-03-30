package com.example.qzq.leetcode;

/**
 * @Classname 合并两个有序链表
 * @Description
 * @Date 2019/10/18 10:20
 * @Created by qiziqian
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
    //[1,3,5]  [2,4,6,7]
    // 2019/10/18 11:02  qiziqian  写了半天,跑不起来
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode headNode =  new ListNode(0);
//        ListNode tailNode ;
//        while(l1.next!=null|l2.next!=null){
//           if(l2==null){
//            tailNode.next=l1;
//            tailNode=tailNode.next;
//           }
//            else if(l1==null){
//                tailNode.next =l2;
//                tailNode=tailNode.next;
//            }else if(l1.val>=l2.val){
//                if(tailNode==null){
//                    tailNode=l2;
//                    tailNode.next=null;
//                    headNode.next=tailNode;
//                }else {
//                    tailNode.next=l2;
//                    tailNode=tailNode.next;
//                }
//            l2=l2.next;
//            }else if(l1.val<l2.val){
//                if(tailNode==null){
//                    tailNode=l1;
//                    tailNode.next=null;
//                    headNode.next=tailNode;
//                }else {
//                    tailNode.next=l1;
//                    tailNode=tailNode.next;
//                }
//                l1=l1.next;
//            }
//        }
//        return  headNode.next;
//        }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
