package com.wangwei.datastructure.linkedlist.recursive;


import com.wangwei.exer.linklist.ListNode;

/**
 * 递归深度调试方法
 */
public class RecursiveDemo {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }
        ListNode res = removeElements(head.next, val, depth+1);

        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;

        if (head.val == val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;



    }

    public String generateDepthString(int depth){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(listNode);

        System.out.println(new RecursiveDemo().removeElements(listNode, 6, 0));
    }
}
