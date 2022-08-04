package com.wangwei.utils;

import java.util.*;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-08-02 16:12
 */
public class CommonUtils {

    public static String generatePassword(int minLength, int maxLength) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()[]?";
        String allChars = upper+lower+numbers+specialChars;
        List<Character> letterChars = new ArrayList<>();
        char[] chars = allChars.toCharArray();
        for (char ch : chars) {
            letterChars.add(ch);
        }
        // 扰乱顺序
        Collections.shuffle(letterChars);
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = random.nextInt(maxLength - minLength) + minLength; i > 0; i--) {
            System.out.println(i);
            builder.append(letterChars.get(random.nextInt(letterChars.size())));
        }
        return builder.toString();
    }

    public static String removeDuplicateFromString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (builder.toString().indexOf(str.charAt(i)) == -1) {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 10; i++) {
        //    System.out.println(generatePassword(6, 8));
        //}
        String str = "wangwei";
        System.out.println(removeDuplicateFromString(str));
    }
}
