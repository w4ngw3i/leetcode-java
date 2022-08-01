package com.wangwei.test;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2021/3/29 1:08 下午
 * @Version 1.0
 *  有一个值都不相同的整数数组，计算两个数差值为 k 的对数。例如， 数组{1, 7, 5, 9, 2, 12, 3}，差值 k 为 2
 */
public class ArrayDemo {
    private static boolean demo;
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        calcDiff(arr, 2);
        System.out.println();
    }

    public static void calcDiff(int[] arr, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer integer = hashMap.get(arr[i] + target);
            if (Objects.nonNull(integer)) {
                System.out.println("(" + arr[i] + ", " + arr[integer] + ")");
            }
        }
    }
}
