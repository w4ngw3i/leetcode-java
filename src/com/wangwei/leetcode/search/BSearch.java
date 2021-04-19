package com.wangwei.leetcode.search;

/**
 * @Author wangwei
 * @Date 2021/4/19 10:50 上午
 * @Version 1.0
 */
public class BSearch {

    public static int searchByRecursion(int[] arr, int low, int height, int target){
        if (low > height) return -1;
        int mid = low + ((height - low) >> 1);
        if (arr[mid] == target){
            return mid;
        }else if (arr[mid] > target){
            return searchByRecursion(arr, low, mid - 1, target);
        }else {
            return searchByRecursion(arr, mid+1, height, target);
        }
    }

    public static int searchNoRecursion(int[] arr, int value){
        int low = 0;
        int height = arr.length - 1;
        int mid = low + ((height - low) >> 1);
        while (low <= height){
            if (value == arr[mid]){
                return mid;
            }else if (value > arr[mid]){
                low = mid + 1;
            }else {
                height = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,9};
        System.out.println(searchByRecursion(arr, 0, arr.length - 1, 5));
        System.out.println(searchNoRecursion(arr, 5));
    }
}
