package com.wangwei.datastructure.linkedlist.leetcode.solution_203;


import com.wangwei.exer.linklist.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution3 {
    /**
     * 使用递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
//        ListNode resNode = removeElements(head.next, val);
//
//        if (head.val == val)
//            return resNode;
//        else{
//            head.next = resNode;
//            return head;
//        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        System.out.println(new Solution3().removeElements(listNode, 6));
    }
}
