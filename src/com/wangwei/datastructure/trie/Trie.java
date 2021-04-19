package com.wangwei.datastructure.trie;

import java.util.TreeMap;

/**
 * @Author wangwei
 * @Date 2021/3/29 10:54 上午
 * @Version 1.0
 */
public class Trie {
    private class Node{
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private int size;
    private Node root;

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
    }
}
