package com.wangwei.datastructure.array.leetcode.solution_15;

import java.util.*;

/**
 * @auther wangwei
 * @date 2019-05-17 09:18
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new TreeSet<>();
//        TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>();
        List<Integer> list;
//        int n = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list);
//                        treeMap.put(n, list);
//                        n++;
                    }

                }
            }
        }


//        for (int i = 0; i < treeMap.size(); i++) {
//            res.add(treeMap.get(i));
//        }
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            res.add(iterator.next());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }
}
