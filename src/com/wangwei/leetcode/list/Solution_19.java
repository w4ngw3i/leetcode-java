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
        System.out.println(solution.removeNthFromEnd(new ListNode(arr), 1));

        System.out.println(solution.removeNthFromEndByStack(new ListNode(arr), 1));
    }
}
