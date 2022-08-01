package com.wangwei.datastructure.sorts;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-28 11:41
 */
public class SelectionSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        if (length == 1) {
            return array;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        SelectionSort selectionSort = new SelectionSort();
        Integer[] sorted = selectionSort.sort(arr);
        for (int i = 0; i < sorted.length - 1; ++i) {
            assert sorted[i] <= sorted[i + 1];
        }
        SortUtils.print(arr);
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort(strings);
        for (int i = 0; i < sortedStrings.length - 1; ++i) {
            assert strings[i].compareTo(strings[i + 1]) <= 0;
        }
        SortUtils.print(strings);
    }
}
