package com.wangwei.datastructure.tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author wangwei
 * @Date 2021/4/7 9:12 下午
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        List<Integer> list = new ArrayList<>(bst.getSize());
        while (!bst.isEmpty()){
            list.add(bst.removeMin());
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) > list.get(i)){
                throw new IllegalArgumentException("Err");
            }
        }

        System.out.println(list);
        System.out.println("removeMin test completed");
    }
}
