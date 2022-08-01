package com.wangwei.datastructure.sorts;

import java.util.Arrays;

/**
 * The class contains util methods
 * @author wangwei
 * @version 1.0
 * @date 2022-07-27 16:58
 */
final class SortUtils {

    static <T> boolean swap(T[] arr, int idx, int idy) {
        T swap = arr[idx];
        arr[idx] = arr[idy];
        arr[idy] = swap;
        return true;
    }

    static <T extends Comparable<T>> boolean greater(T v, T w) {
        return v.compareTo(w) > 0;
    }

    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }
}
