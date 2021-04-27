package com.wangwei.leetcode.search;

import java.lang.annotation.Target;

/**
 * @Author wangwei
 * @Date 2021/4/19 3:14 下午
 * @Version 1.0
 */
public class HalfSearch {

    // 查找第一个值等于给定值的元素
    public static int searchFirstEqualsTarget(int[] arr, int value){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + ((height - low) >> 1);
            if (value > arr[mid]){
                low = mid + 1;
            }else if (value < arr[mid]){
                height = mid - 1;
            }else {
                if (mid == 0 || arr[mid - 1] != value)
                    return mid;
                else
                    height = mid - 1;
            }
        }
        return -1;
    }

    //变体二：查找最后一个值等于给定值的元素
    public static int searchLastEqualsTarget(int[] arr, int value){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + ((height - low) >> 1);
            if (value > arr[mid])
                low = mid + 1;
            else if (value < arr[mid])
                height = mid - 1;
            else
                if (mid == arr.length - 1 || arr[mid+1] != value)
                    return mid;
                else
                    low = mid + 1;
        }
        return -1;
    }

    //变体三：查找第一个大于等于给定值的元素
    public static int searchFirstGreaterTarget(int[] arr, int value){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + ((height - low) >> 1);
            if (arr[mid] >= value){
                if (mid == 0 || arr[mid-1] < value)
                    return mid;
                else
                    height = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 变体四：查找最后一个小于等于给定值的元素
    public static int searchLastLessTarget(int[] arr, int value){
        int low = 0;
        int height = arr.length - 1;
        while (low <= height){
            int mid = low + ((height - low) >> 1);
            if (arr[mid] <= value){
                if (mid == arr.length - 1 || arr[mid+1] > value)
                    return mid;
                else
                    low = mid + 1;
            }else {
                height = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,8,8,8,11,18};
        System.out.println(searchFirstEqualsTarget(arr, 8)); //5
        System.out.println(searchLastEqualsTarget(arr, 8)); //7
        System.out.println(searchFirstGreaterTarget(arr, 8)); //8
        System.out.println(searchLastLessTarget(arr, 8)); // 0
    }
}
