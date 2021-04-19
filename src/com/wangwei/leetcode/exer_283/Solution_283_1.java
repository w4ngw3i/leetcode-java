package com.wangwei.leetcode.exer_283;

import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/10/12 4:52 下午
 * @Version 1.0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_283_1 {
    public void moveZeroes(int[] nums) {
       if (Objects.isNull(nums))
           return;
       int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }

        for (int i = 0; i < j; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Solution_283_1 solution2831 = new Solution_283_1();
        int[] arr = {0,1,0,3,12};
        solution2831.moveZeroes(arr);
    }
}
