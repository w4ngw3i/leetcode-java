package com.wangwei.leetcode.list;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @Author wangwei
 * @Date 2021/4/17 12:56 下午
 * @Version 1.0
 *  给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  输入：head = [1,2,3,4,5], n = 2
 *  输出：[1,2,3,5]
 *
 *  输入：head = [1], n = 1
 *  输出：[]
 */
public class Solution_19 {

    // 暴力解法
    public ListNode removeNthFromEndByBC(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode listNode){
        int length = 0;
        while (listNode != null){
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    // 快慢双双指针解法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i=0; i<n; i++){
            first  = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    // 基于栈解法
    public ListNode removeNthFromEndByStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_19 solution = new Solution_19();
        int[] arr = {1,2,3,4,5};
        System.out.println(solution.removeNthFromEndByBC(new ListNode(arr), 1));
        System.out.println(solution.removeNthFromEnd(new ListNode(arr), 1));

        System.out.println(solution.removeNthFromEndByStack(new ListNode(arr), 1));
    }
}
