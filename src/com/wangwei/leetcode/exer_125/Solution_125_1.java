package com.wangwei.leetcode.exer_125;

/**
 * @Author wangwei
 * @Date 2020/10/12 3:13 下午
 * @Version 1.0
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Solution_125_1 {
    public boolean isPalindrome(String s) {
        String filteredS = _filterNonNumberAndChar(s);
        return _reverseString(filteredS).equalsIgnoreCase(filteredS);
    }

    private String _reverseString(String filteredS) {
        return new StringBuilder(filteredS).reverse().toString();
    }

    private  String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]", "");
    }

    public static void main(String[] args) {
        Solution_125_1 solution1251 = new Solution_125_1();
        solution1251.isPalindrome("a -b a");
    }
}
