package com.wangwei.datastructure.tree.test;

import com.wangwei.datastructure.queue.LinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wangwei
 * @version 1.0
 * @date 2022-07-26 10:27
 */
public class BST<E extends Comparable<E>>{
    private class Node {
        public E e;
        public Node left;
        public Node right;
        public Node(E e) {
            this.e = e;
        }
    }
    private Node root;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        //if (root == null) {
        //    root = new Node(e);
        //    size++;
        //}else {
        //    add(root, e);
        //}
        root = add(root, e);
    }

    //private void add(Node node, E e) {
    //    if (e.compareTo(node.e) == 0) {
    //        return;
    //    }
    //    if (e.compareTo(node.e) < 0 && node.left == null) {
    //        node.left = new Node(e);
    //        size++;
    //    }
    //    if (e.compareTo(node.e) > 0 && node.right == null) {
    //        node.right = new Node(e);
    //        size++;
    //    }
    //    if (e.compareTo(node.e) < 0) {
    //        add(node.left, e);
    //    }else {
    //        add(node.right, e);
    //    }
    //}

    private Node add(Node node, E e) {
       if (node == null) {
           size++;
           return new Node(e);
       }
       if (e.compareTo(node.e) > 0) {
           node.right = add(node.right, e);
       }else if (e.compareTo(node.e) < 0) {
           node.left = add(node.left, e);
       }
       return node;
    }

    public Node fin(E data) {
        Node cur = root;
        while (cur != null) {
            if (data.compareTo(cur.e) == 0) {
                return cur;
            }else if (data.compareTo(cur.e) > 0) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) ==  0) {
            return true;
        }else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }else {
            return contains(node.left, e);
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public void prOrderNr() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void prOrder() {
        prOrder(root);
    }

    private void prOrder(Node node) {
        if (node == null){
            return;
        }
        System.out.println(node.e);
        prOrder(node.left);
        prOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public E min() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is null");
        }
        return min(root).e;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder stringBuilder){
        if (node == null){
            stringBuilder.append(generateDepthString(depth) + "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth)+ node.e + "\n");
        generateBSTString(node.left, depth+1, stringBuilder);
        generateBSTString(node.right, depth+1, stringBuilder);
    }

    private String generateDepthString(int depth){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}
