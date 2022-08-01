package com.wangwei.leetcode.string;

import java.util.LongSummaryStatistics;

/**
 * @Author wangwei
 * @Date 2021/4/1 7:31 下午
 * @Version 1.0
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 */
public class Solution_5 {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static boolean validPalindromic(char[] charArray, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
       //while (left < right) {
       //    if (charArray[left] != charArray[right]) {
       //        return false;
       //    }
       //    left++;
       //    right--;
       //}
       return true;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        //String s = longestPalindrome("cbbd");
        System.out.println(s);
    }
}
