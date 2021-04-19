package com.wangwei.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author wangwei
 * @Date 2021/4/1 10:52 下午
 * @Version 1.0
 */
public class DequeueDemo {
    public static void main(String[] args) {
        Deque<Integer> linkedList = new LinkedList<>();
        linkedList.add(8);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList);
        System.out.println(linkedList.peek());
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
    }
}
