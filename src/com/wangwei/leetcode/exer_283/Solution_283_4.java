package com.wangwei.leetcode.exer_283;

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
public class Solution_283_4 {
    public void moveZeroes(int[] nums) {
     if (nums == null || nums.length == 0) return;
        int site = 0;
        for (int num : nums) {
            if (num != 0){
                nums[site++] = num;
            }
        }

        while (site < nums.length){
            nums[site++] = 0;
        }

        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
        if (i < nums.length-1){
        System.out.print(nums[i] + ",");
        }else {
        System.out.print(nums[i] + "]");
        }
        }
    }

    public static void main(String[] args) {
        Solution_283_4 solution283 = new Solution_283_4();
        int[] arr = {0,1,0,3,12};
        solution283.moveZeroes(arr);
    }
}
