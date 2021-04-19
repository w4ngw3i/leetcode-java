package com.wangwei.datastructure.linkedlist.leetcode;

/**
 * @Auther wangwei
 * @Date 2018/5/2 下午5:49
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 使用arr数组为参数构建一个链表，当前listnode为链表头节点
     *
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            builder.append(cur.val).append("->");
            cur = cur.next;
//            if (cur.next != null)
//                builder.append(cur.val + "->");
//            else
//                builder.append(cur.val);
//            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
