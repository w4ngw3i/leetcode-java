package com.wangwei.leetcode.sort;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};

        System.out.println(getArraryMax2(arr));


    }

    public static int getArraryMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    public static int getArraryMax2(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }

        return arr[max];
    }
}
