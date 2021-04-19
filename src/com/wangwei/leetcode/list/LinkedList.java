package com.wangwei.leetcode.list;

import sun.nio.cs.FastCharsetProvider;

/**
 * @Author wangwei
 * @Date 2021/4/17 10:55 下午
 * @Version 1.0
 */
public class LinkedList <E>{
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private int size;

    //private Node head;

    //public LinkedList() {
    //    this.size = 0;
    //    this.head = null;
    //}
    private Node dummyHead;

    public LinkedList() {
        this.size = 0;
        this.dummyHead = new Node();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 非虚拟头节点实现方式
    //public void addFirst(E e){
    //    //Node node = new Node(e);
    //    //node.next = head;
    //    //head = node;
    //    head = new Node(e, head);
    //    size++;
    //}

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    // 非虚拟头节点实现方式
    //public void add(int index, E e){
    //    if (index < 0 || index > size){
    //        throw new IllegalArgumentException("参数非法");
    //    }
    //    if (index == 0){
    //        addFirst(e);
    //    }else {
    //
    //        Node prev = head;
    //        for (int i = 0; i < index -1; i++){
    //            prev = prev.next;
    //        }
    //
    //        //Node node = new Node(e);
    //        //node.next = prev.next;
    //        //prev.next = node;
    //        prev.next = new Node(e, prev.next);
    //        size++;
    //    }
    //}

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size);
    }

    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur!=null){
            if (e.equals(cur.e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }
        Node prev = dummyHead.next;
        for (int i = 0; i < index-1; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
