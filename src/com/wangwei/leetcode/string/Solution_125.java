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

    // 基于双指针实现
    public boolean isPalindromeByDoublePointer(String s){
        StringBuffer buffer = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                buffer.append(c);
            }
        }
        int left = 0;
        int right = buffer.length() - 1;
        while (left < right){
            if (Character.toLowerCase(buffer.charAt(left)) != Character.toLowerCase(buffer.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 在原字符串上直接判断
    public boolean isPalindromeByDoublePointerAndSource(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
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
