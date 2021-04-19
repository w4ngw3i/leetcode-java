package com.wangwei.datastructure.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author wangwei
 * @Date 2021/4/7 5:57 下午
 * @Version 1.0
 */
public class BST<E extends Comparable<E>>{
    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private int size;
    private Node root;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        //if (root == null){
        //    root = new Node(e);
        //    size++;
        //}else {
        //    add(root, e);
        //}
        root = add(root, e);
    }

    private Node add(Node node, E e){
        //if (node.e.compareTo(e) == 0){
        //    return;
        //}
        //if (node.e.compareTo(e) < 0 && node.left == null){
        //    node.left = new Node(e);
        //    size++;
        //}
        //if (node.e.compareTo(e) > 0 && node.right == null){
        //    node.right = new Node(e);
        //    size++;
        //}
        //if (node.e.compareTo(e) < 0){
        //    add(node.left, e);
        //}
        //if (node.e.compareTo(e) > 0){
        //    add(node.right, e);
        //}
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    // 层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 前序遍历非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void  inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void  afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node node){
        if (node == null)
            return;
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);
    }

    public E minmum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(root).e;
    }

    private Node minmum(Node node){
        if (node.left == null)
            return node;
        return minmum(node.left);
    }

    public E maxmum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root).e;
    }

    public Node maxmum(Node node){
        if (node.right == null)
            return node;
        return maxmum(node.right);
    }

    public E maxmumNR(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        if (root.right == null){
            return root.e;
        }
        Node cur = root;
        while (cur.right != null){
            cur = cur.right;
        }
        return cur.e;
    }

    // 从二叉树中删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
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
