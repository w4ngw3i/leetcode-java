package com.wangwei.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-29 15:39
 */
public class StringUtils {

    public static String toLowerCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    public static String toUpperCase(String str) {
        char[] values = str.toCharArray();
        for (int i = 0; i < values.length; i++) {
            if (Character.isLetter(values[i]) && Character.isLowerCase(values[i])) {
                values[i] = Character.toUpperCase(values[i]);
            }
        }
        return new String(values);
    }

    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] values = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        return new String(values);
    }

    public static boolean isAnagrams(String str1, String str2) {
        Map<Character, Integer> charAppearances = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char value = str1.charAt(i);
            Integer numOfAppearances = charAppearances.getOrDefault(value, 0);
            charAppearances.put(value, numOfAppearances + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char value = str2.charAt(i);
            if (!charAppearances.containsKey(value)) {
                return false;
            }
            charAppearances.put(value, charAppearances.get(value) - 1);
        }
        for (Integer value : charAppearances.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"ABC", "ABC123", "abcABC", "abc123ABC"};
        String s1 = toUpperCase(Arrays.toString(strings));
        System.out.println("s1 = " + s1);
        for (String s : strings) {
            assert toLowerCase(s).equals(s.toLowerCase());
        }
    }
}
