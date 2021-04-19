package com.wangwei.leetcode.string;

/**
 * @Author wangwei
 * @Date 2021/4/1 7:09 下午
 * @Version 1.0
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]

 */
public class Solution_344 {

    public static void main(String[] args) {
        String[] s = {"h","e","l","l","o"};
        char[] ch = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            ch[i] = s[i].charAt(0);
        }
        System.out.println(ch);
        reverseString(ch);
        System.out.println(ch);
    }

    public static void reverseString(char[] s){
        if (null == s) return;
        for (int i=0, j=s.length-1; i<j; i++, j--){
            char temp = s[i]; s[i] = s[j]; s[j]=temp;
        }
    }
}
