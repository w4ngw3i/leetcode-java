package com.wangwei.leetcode.list;

/**
 * @Author wangwei
 * @Date 2021/4/18 9:53 上午
 * @Version 1.0
 *  给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 *  输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 输入：head = [], val = 1
 * 输出：[]
 */
public class Solution_203 {

    // 递归解法
    public ListNode removeElementsByRecursion(ListNode head, int val) {
        if (head == null)
            return head;
        head.next = removeElementsByRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 非递归解法
    public ListNode removeElementsNoRecursion(ListNode head, int val) {
        while (head != null && head.val == val){
            //ListNode delNode = head;
            //head.next = delNode.next;
            //delNode.next = null;
            head = head.next;
        }
        if (head == null)
            return head;
        ListNode cur = head;
        while (cur.next != null){
            if (val == cur.next.val){
                //ListNode delNode = cur.next;
                //cur.next = delNode.next;
                //delNode.next = null;
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    // 增加虚拟头节点解法
    public ListNode removeElementsByDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (val == prev.next.val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution_203 solution_203 = new Solution_203();
        int[] arr = {1,2,6,3,4,5,6};
        System.out.println(solution_203.removeElementsByRecursion(new ListNode(arr), 6));
        System.out.println(solution_203.removeElementsNoRecursion(new ListNode(arr), 1));
        System.out.println(solution_203.removeElementsByDummyHead(new ListNode(arr), 1));
    }
}
