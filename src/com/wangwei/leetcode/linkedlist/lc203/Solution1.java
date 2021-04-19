package com.wangwei.leetcode.linkedlist.lc203;

import com.wangwei.exer.linklist.ListNode;

/**
 * @Author wangwei
 * @Date 2020/5/5 1:57 下午
 * @Version 1.0
 */
public class Solution1 {
   public ListNode removeElements(ListNode head, int val) {
       // 使用while防止下一头节点的val仍是val
       while (head!= null && head.val == val) {
           ListNode delNode = head;
           head = head.next;
           delNode.next = null;
       }

       if (head == null){
           return null;
       }

       ListNode prev = head;
       while (prev.next != null){
           if (prev.next.val == val){
               //ListNode delNode = prev.next;
               //prev.next = delNode.next;
               //delNode.next = null;
               prev.next = prev.next.next;
           }else
               prev = prev.next;
       }
       return head;
   }
}
