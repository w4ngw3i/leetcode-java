package com.wangwei.leetcode.list;

/**
 * @Author wangwei
 * @Date 2021/4/17 12:56 下午
 * @Version 1.0
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 */
public class Solution_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};
        Solution_21 solution_21 = new Solution_21();
        System.out.println(solution_21.mergeTwoLists(new ListNode(l1), new ListNode(l2)));
    }
}
