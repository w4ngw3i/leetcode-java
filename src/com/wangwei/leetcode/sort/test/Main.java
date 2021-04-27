package com.wangwei.leetcode.sort.test;

import com.wangwei.leetcode.sort.SortUtils;

/**
 * @Author wangwei
 * @Date 2021/4/22 10:42 下午
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};

        SortUtils.printArr(arr);
        insertSort(arr);
        SortUtils.printArr(arr);
    }

    public static void insertSort(int[] arr){
        if (arr.length <= 0) return;
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j>=0; j--){
                if (arr[j] > val){
                    arr[j+1]=arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = val;
        }
    }
}
