package com.wangwei.leetcode.string;

/**
 * @Author wangwei
 * @Date 2021/4/27 7:44 下午
 * @Version 1.0
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *  示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Solution_125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        StringBuilder reverse = new StringBuilder(s).reverse();
        return s.equalsIgnoreCase(reverse.toString());
    }

    public String _filterNoNumAndChar(String s){
        return s.replaceAll("[^0-9a-zA-Z]", "");
    }

    public String _reverseString(String source){
        return new StringBuilder(source).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution_125 solution_125 = new Solution_125();
        String numAndChar = solution_125._filterNoNumAndChar(s);
        System.out.println(numAndChar.equalsIgnoreCase(solution_125._reverseString(numAndChar)));
    }
}
