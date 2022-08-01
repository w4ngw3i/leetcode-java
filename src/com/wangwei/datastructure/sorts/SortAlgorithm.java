package com.wangwei.datastructure.sorts;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-27 16:41
 */
public interface SortAlgorithm {

    /**
     * Main method arrays sorting algorithms
     *
     * @param unsorted - an array should be sorted
     * @return a sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);
}
