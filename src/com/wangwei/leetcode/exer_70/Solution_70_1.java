package com.wangwei.leetcode.exer_70;

/**
 * @Author wangwei
 * @Date 2020/10/13 10:35 上午
 * @Version 1.0
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_70_1 {
    public int climbStairs(int n) {
        // base case
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    public static void main(String[] args) {
        Solution_70_1 solution_70_1 = new Solution_70_1();

        solution_70_1.climbStairs(5);
    }
}
