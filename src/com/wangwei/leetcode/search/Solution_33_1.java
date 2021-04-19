package com.wangwei.leetcode.search;

/**
 * @Author wangwei
 * @Date 2020/12/2 上午10:58
 * @Version 1.0
 */
public class Solution_33_1 {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,9,8,3,11,10,12,13};
        System.out.println(new Solution_33_1().search(nums, 3));
        System.out.println(new Solution_33_1().search(nums, 11));
        int[] nums2 = {1, 3};
        System.out.println(new Solution_33_1().search(nums2, 3));
    }


    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return -1;
        if (length == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0;
        int r = length - 1;
        int mid;
        while (l <= r){
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid])
                    r = mid -1;
                else
                    l = mid + 1;
            }else {
                if (nums[mid] < target && target <= nums[length - 1])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
