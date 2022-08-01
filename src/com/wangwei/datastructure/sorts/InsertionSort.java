package com.wangwei.datastructure.sorts;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-27 17:22
 */
public class InsertionSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 1) {
            return array;
        }
        for (int i = 1; i < array.length;  i++) {
            T insertValue = array[i];
            int j;
            for (j = i - 1; j >= 0 && SortUtils.less(insertValue, array[j]); --j) {
                array[j+1] = array[j];
            }
            if (j != i - 1) {
                array[j+1] = insertValue;
            }
        }
        return array;
        //for (int i = 1; i < array.length; i++) {
        //    T insertValue = array[i];
        //    int j;
        //    for (j = i -1; j >= 0; --j) {
        //        if (insertValue.compareTo(array[j]) < 0) {
        //            array[j+1] = array[j];
        //        }else {
        //            break;
        //        }
        //    }
        //    if (j != i-1) {
        //        array[j+1] = insertValue;
        //    }
        //}
        //return array;
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        InsertionSort sort = new InsertionSort();
        sort.sort(integers);
        SortUtils.print(integers);
        /* [1, 4, 6, 9, 12, 23, 54, 78, 231] */

        String[] strings = {"c", "a", "e", "b", "d"};
        sort.sort(strings);
        SortUtils.print(strings);
        /* [a, b, c, d, e] */
    }
}
