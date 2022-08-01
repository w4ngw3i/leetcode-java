package com.wangwei.datastructure.tree.test;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-26 11:53
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(13);
        bst.add(8);
        bst.add(18);
        bst.add(6);
        bst.add(10);
        bst.add(20);
        bst.add(16);
        //bst.levelOrder();
        //bst.prOrderNr();
        //bst.inOrder();
        System.out.println(bst.toString());
        //System.out.println(bst.min());
    }
}
