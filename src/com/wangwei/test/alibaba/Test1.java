package com.wangwei.test.alibaba;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author wangwei
 * @Date 2020/12/25 下午5:48
 * @Version 1.0
 * 题目1：
 * 字符串sfadssjfkh8r901sknci。;XKLJAIDU822'；‘sdjchasdasdasdasdqwdwnjhgosznldcha92312kjn
 * 取出所有临近d和j之间的字符串并进行排序
 *
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "sdjchasdasdasdasdqwdwnjhgosznldcha92312kjn";
        System.out.println(str.indexOf('d', str.indexOf('d')+1));
        modeMatcher(str);
    }

    public static void matcher(String str){
        int length = str.length();
        if (length <= 2) return;
        int d1 = str.indexOf('d');
        for (int i=d1; i<length; i++){
            char c = str.charAt(i + 1);
            if ('d' == c){
                i = i + 1;
                continue;
            }

        }
        int j1 = str.indexOf('j');
    }

    public static void modeMatcher(String str){
        LinkedHashMap<Integer, Character> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('d' == c || 'j' ==c){
                linkedHashMap.put(i, c);
            }
        }
        linkedHashMap.forEach((k, v) -> System.out.println("("+k+" , " + v +")"));
    }

    public static List<String> verifyChar(String str){
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        for (int i = 0; i < str.length(); i++) {
            String word = String.valueOf(str.charAt(i));
            if (!pattern.matcher(word).matches()){
                continue;
            }
            if ("f".equalsIgnoreCase(word) || "e".equalsIgnoreCase(word)){
                list.add(word);
            }
        }
        Collections.sort(list);
        return list;
    }
}
