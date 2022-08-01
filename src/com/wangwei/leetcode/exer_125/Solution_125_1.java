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
        //String s1 = filterNonNumberAndChar(s);
        //return isPal(s1);
    }

    public static boolean isPal(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static String filterNonNumberAndChar(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s.length());
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar) || Character.isLetter(aChar)) {
                builder.append(aChar);
            }
        }
        return builder.toString();
    }

    private String _reverseString(String filteredS) {
        return new StringBuilder(filteredS).reverse().toString();
    }

    private  String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^A-Za-z0-9]", "");
    }

    public static void main(String[] args) {
        Solution_125_1 solution1251 = new Solution_125_1();
        boolean palindrome = solution1251.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("palindrome = " + palindrome);
    }
}
