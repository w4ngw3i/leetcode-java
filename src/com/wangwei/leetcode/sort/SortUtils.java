package com.wangwei.leetcode.sort;

/**
 * @Author wangwei
 * @Date 2021/4/19 12:25 上午
 * @Version 1.0
 */
public class SortUtils {

    // 冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr.length <= 1)
            return;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i -1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;;
        }
    }

    // 插入排序
    public static void insertSort(int[] arr){
        if (arr.length <= 1)
            return;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i -1;
            for (; j>=0; j--){
                if (arr[j] > value){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    // 选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void printArr(int[] arr){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length -1){
                builder.append(" ,");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};
        printArr(arr);
        //bubbleSort(arr);
        //insertSort(arr);
        selectSort(arr);
        printArr(arr);
    }
}
