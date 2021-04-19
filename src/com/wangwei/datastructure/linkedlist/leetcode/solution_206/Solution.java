package com.wangwei.datastructure.linkedlist.leetcode.solution_206;

import com.wangwei.exer.linklist.ListNode;


/**
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        //递归到底的结果
        if(head == null) return null;
        if(head.next ==null) return head;

        //假设ReverseList(head.next)已经将以head.next为头结点的链表翻转；
        //同时返回翻转后链表的头节点reverse_head_next
        //那么接下来的工作就是将head节点加入这个翻转后的链表里。
        ListNode reverse_head_next = reverseList(head.next);

        // 上面的代码递归处理完了head.next对应的链表
        // 下面的代码用来维护head
        //ListNode reverse_tail = head.next; // 这个变量不声明也可以，声明语义更清晰：）
        //reverse_tail.next = head;
        //head.next = null;

        reverse_head_next = head;

        return reverse_head_next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        System.out.println(new Solution().reverseList(listNode));
    }
}
