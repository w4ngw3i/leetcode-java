package com.wangwei.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangwei
 * @Date 2021/4/1 6:12 下午
 * @Version 1.0
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 */
public class Solution_387 {
    public int firstUniqCharByArray(String s) {
        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charArr[s.charAt(i) - 'a']  == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharByMap(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


}
