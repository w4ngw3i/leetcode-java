package com.wangwei.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2021/4/1 10:38 下午
 * @Version 1.0
 *
 *  给定一个字符串，逐个翻转字符串中的每个单词
 *
 *  说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括
 *

 */
public class Solution_151 {

    public static void main(String[] args) {
       String s = "  Bob    Loves  Alice   ";
        StringBuilder builder = trimSpaces(s);
        reverse(builder, 0, builder.length() - 1);
        reverseEachWord(builder);
        System.out.println(builder.toString());

    }

    // 借助jdk提供的API实现
    public static String reverseWords(String s) {
        String trim = s.trim();
        List<String> wordsList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordsList);
        return String.join(" ", wordsList);
    }

    // 自定义API实现
    public static void reverseEachWord(StringBuilder builder) {
        int n = builder.length();
        int start = 0, end = 0;
        while (start < n){
            while (end < n && builder.charAt(end) != ' '){
                end++;
            }
            reverse(builder, start, end - 1);
            start = end + 1;
            end++;
        }
    }


    // 自定义API实现反转
    public static void reverse(StringBuilder builder, int left, int right){
        while (left < right){
            char temp = builder.charAt(left);
            builder.setCharAt(left++, builder.charAt(right));
            builder.setCharAt(right--, temp);
        }
    }

    // 自定义API实现去掉前后空格
    public static StringBuilder trimSpaces(String s){
        int left = 0, right = s.length() - 1;
        while (left<=right && s.charAt(left) == ' '){
            ++left;
        }
        while (left<=right && s.charAt(right) == ' '){
            --right;
        }
        StringBuilder builder = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                builder.append(c);
            }else if (builder.charAt(builder.length() - 1) != ' '){ // 中间保留一个空格
                builder.append(c);
            }
            left++;
        }
        return builder;
    }
}
