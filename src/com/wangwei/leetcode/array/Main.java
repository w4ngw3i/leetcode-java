package com.wangwei.leetcode.array;

/**
 * @Author wangwei
 * @Date 2021/4/17 10:20 下午
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.addLast(100);
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        System.out.println(array.remove(1));
        System.out.println(array.remove(9));
        System.out.println(array);
    }
}
