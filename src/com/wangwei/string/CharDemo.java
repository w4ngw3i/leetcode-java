package com.wangwei.string;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @Author wangwei
 * @Date 2021/3/28 4:07 下午
 * @Version 1.0
 */
public class CharDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        for (int i = 65; ; i++){
            char c = (char) i;
            if (!pattern.matcher(String.valueOf(c)).matches()) {
                break;
            }
            hashMap.put(String.valueOf(c), i);
        }

        System.out.println((char)65);

        hashMap.forEach((k, v) -> System.out.println("(" + k + " , " +v + ")"));
    }

    public static boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
