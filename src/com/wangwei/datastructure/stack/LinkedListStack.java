package com.wangwei.datastructure.stack;


import com.wangwei.datastructure.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Stack: top ");
        builder.append(linkedList);
        return builder.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LinkedListStack<Integer> list = new LinkedListStack();

        for (int i = 0; i < 5; i++) {
            list.push(i);
            System.out.println(list);
        }

        list.pop();

        System.out.println(list);

    }
}
