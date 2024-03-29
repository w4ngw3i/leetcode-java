package com.wangwei.leetcode.array;

import java.util.*;

/**
 * @auther wangwei
 * @date 2019-05-12 13:13
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2);
        return list.stream().distinct().mapToInt(i->i).toArray();
        //Set<Integer> set1 = new HashSet<>();
        //Set<Integer> set2 = new HashSet<>();
        //for (int j : nums1) {
        //    set1.add(j);
        //}
        //for (int i : nums2) {
        //    set2.add(i);
        //}
        //return getIntersection(set1, set2);
    }

    private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<>(set1.size());
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                intersectionSet.add(integer);
            }
        }
        int[] arr = new int[intersectionSet.size()];
        int index = 0;
        for (Integer num : intersectionSet) {
            arr[index++] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
//        int[] nums1 = new int[]{1,2,2,1};
//        int[] nums2 = new int[]{2,2};
        int[] arr = new Solution_349().intersection(nums1, nums2);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + ",");
            else
                System.out.print(arr[i]+"]");
        }
    }
}
