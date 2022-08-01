package com.wangwei.datastructure.sorts;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-27 16:44
 */
public class BubbleSort implements SortAlgorithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array.length == 1){
            return array;
        }
        for (int i = 1, size = array.length; i < size; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (SortUtils.greater(array[j], array[j+1])) {
                    SortUtils.swap(array, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        for (int i = 0; i < integers.length - 1; ++i) {
            assert integers[i] <= integers[i + 1];
        }
        SortUtils.print(integers);
        /* output: [1, 4, 6, 9, 12, 23, 54, 78, 231] */

        String[] strings = {"c", "a", "e", "b", "d"};
        bubbleSort.sort(strings);
        for (int i = 0; i < strings.length - 1; i++) {
            assert strings[i].compareTo(strings[i + 1]) <= 0;
        }
        SortUtils.print(bubbleSort.sort(strings));
    }
}
