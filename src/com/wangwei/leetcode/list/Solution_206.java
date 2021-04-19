package com.wangwei.leetcode.list;

/**
 * @Author wangwei
 * @Date 2021/4/17 12:55 下午
 * @Version 1.0
 *  反转一个单链表。
 *  输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution_206 solution_206 = new Solution_206();
        int[] arr = {1,2,3,4,5};
        System.out.println(new ListNode(arr));
        System.out.println(solution_206.reverseList(new ListNode(arr)));
    }
}
