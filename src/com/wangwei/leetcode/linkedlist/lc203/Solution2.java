package com.wangwei.leetcode.linkedlist.lc203;

import com.wangwei.exer.linklist.ListNode;

import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/5/5 1:57 下午
 * @Version 1.0
 */
public class Solution2 {
   public ListNode removeElements(ListNode head, int val) {
       if (head == null)
           return null;
       ListNode dummyHead = new ListNode(-1);
       dummyHead.next = head;
       ListNode cur = dummyHead;
       while (cur.next != null){
           if (cur.next.val == val){
               cur.next = cur.next.next;
           }else {
               cur = cur.next;
           }
       }
       return dummyHead.next;
   }
}
