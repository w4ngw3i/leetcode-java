package com.wangwei.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wangwei
 * @Date 2020/12/2 下午5:08
 * @Version 1.0
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap.put(1, 5);
        linkedHashMap.put(3, 7);
        linkedHashMap.put(2, 6);
        linkedHashMap.put(5, 8);
        linkedHashMap.put(4, 9);
        for (Map.Entry entry: linkedHashMap.entrySet()){
            System.out.println("("+entry.getKey() + "," + entry.getValue() + ")");
        }
        linkedHashMap.forEach( (key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });
        linkedHashMap.put(3, 26);
        linkedHashMap.get(5);
        System.out.println("=================================");
        for (Map.Entry entry: linkedHashMap.entrySet()){
            System.out.println("("+entry.getKey() + "," + entry.getValue() + ")");
        }
        linkedHashMap.forEach( (key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });
    }
}
