package com.wangwei.leetcode.list;

/**
 * @Author wangwei
 * @Date 2021/4/18 1:28 上午
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr){
        if (arr == null || arr.length ==0){
            throw new IllegalArgumentException("参数非法");
        }
        ListNode cur = this;
        cur.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur!=null){
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
