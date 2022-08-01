package com.wangwei.test;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-08-01 10:47
 */
public class Main {

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 5, 4};
        Integer[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    public static <T extends Comparable<T>> T[] sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        //for (int i = 1; i < arr.length; i++) {
        //    T insertValue = arr[i];
        //    int j;
        //    for (j = i - 1; j >=0 ; j--) {
        //        if ( insertValue.compareTo(arr[j]) < 0) {
        //            arr[j+1] = arr[j];
        //        }else {
        //            break;
        //        }
        //    }
        //    if (j != i-1) {
        //        arr[j+1] = insertValue;
        //    }
        //}

        //for (int i = 1; i < arr.length; i++) {
        //    boolean swapped = false;
        //    for (int j = 0; j < arr.length - i; j++) {
        //        if (arr[j].compareTo(arr[j+1]) > 0) {
        //            T temp = arr[j];
        //            arr[j] = arr[j+1];
        //            arr[j+1] = temp;
        //            swapped = true;
        //        }
        //    }
        //    if (!swapped) {
        //        break;
        //    }
        //}
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
