package com.wangwei.datastructure.array.javase;

/**
 * @Author wangwei
 * @Date 2020/4/15 2:27 下午
 * @Version 1.0
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};
        printArray(arr);
        System.out.println();
        bubbleSort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1){
                System.out.print(arr[i] + ",");
            }else {
                System.out.print(arr[i] + "]");
            }
        }
    }

    // 选择排序
    private static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int x = i+1; x < arr.length; x++) {
                if (arr[i] > arr[x]){
                    int temp = arr[i];
                    arr[i] = arr[x];
                    arr[x] = temp;
                }
            }
        }
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr){
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length-x-1; y++) {
                if (arr[y] > arr[y+1]){
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }
        }

    }
}
