package com.wangwei.leetcode.linkedlist.lc203;

import com.wangwei.exer.linklist.ListNode;

/**
 * @Author wangwei
 * @Date 2021/4/3 12:19 上午
 * @Version 1.0
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next: head;
    }
}
