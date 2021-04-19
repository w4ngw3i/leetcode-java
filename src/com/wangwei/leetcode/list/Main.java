package com.wangwei.leetcode.list;

/**
 * @Author wangwei
 * @Date 2021/4/18 1:00 上午
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }
}
