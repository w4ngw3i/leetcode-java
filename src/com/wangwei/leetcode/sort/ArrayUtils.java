package com.wangwei.leetcode.sort;

/**
 * @Auther wangwei
 * @Date 2018/5/10 上午7:28
 */
public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr = {1, 9, 10, 11, 25, 30, 42, 76, 89, 203};
        int i = halfSearch2(arr, 30);
        System.out.println(i);
    }


    public static int getIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }


    public static int halfSearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = (max + min) >> 1;
        while (arr[mid] != key) {
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            if (min > max)
                return -1;
            mid = (max + min) >> 1;
        }

        return mid;
    }


    public static int halfSearch2(int[] arr, int key) {
        if (arr.length == 1)
            return 0;
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (min <= max) {
            mid = (max + min) >> 1;
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            else
                return mid;

        }

        return -1;
    }
}
