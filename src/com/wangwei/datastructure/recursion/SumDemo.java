package com.wangwei.datastructure.recursion;

/**
 * @Author wangwei
 * @Date 2021/4/2 6:37 下午
 * @Version 1.0
 */
public class SumDemo {
    public static void main(String[] args) {
        System.out.println(sum(100));
        int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr, 0));
    }

    public static int sum(int n){
        if (n < 0){
            return 0;
        }
        return sum(n-1) + n;
    }

    public static int sum(int[] arr, int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
