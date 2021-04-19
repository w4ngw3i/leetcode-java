package com.wangwei.datastructure.linkedlist;

/**
 * @Author wangwei
 * @Date 2020/5/4 4:19 下午
 * @Version 1.0
 * 基础版本 不使用虚拟头指针
 */
public class LinkedListByEasy<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private int size;

    private Node head;

    public LinkedListByEasy() {
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        //Node node = new Node(e);
        //node.next = head;
        //head = node;
        head = new Node(e, head);
        size++;
    }

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        if (index == 0){
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }
}
