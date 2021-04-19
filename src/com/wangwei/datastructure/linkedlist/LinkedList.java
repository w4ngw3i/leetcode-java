package com.wangwei.datastructure.linkedlist;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        private Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        private Node(E e) {
            this(e,null);
        }

        private Node() {
            this(null, null);
        }
    }

    private Node dummyHead;//使用虚拟节点头

    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 使用虚拟头节点
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if (index < 0 || index > size)
           throw new IllegalArgumentException("Add failed, Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);

        size++;
    }


    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 使用虚拟头节点
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取第index位置上的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;
    }


    public E getFirst(){
        return get(0);
    }


    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        cur.e=e;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null){
//            builder.append(cur.e+"->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
             builder.append(cur.e).append("->");
        builder.append("NULL");
        return builder.toString();
    }
}
