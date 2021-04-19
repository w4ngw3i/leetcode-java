package com.wangwei.leetcode.array;

/**
 * @Author wangwei
 * @Date 2021/4/17 10:04 下午
 * @Version 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.size = 0;
        data = (E[])new Object[capacity];
    }

    public Array() {
        this(10);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add faild, index muset index < 0 and index <= size");
        }
        if (size == data.length)
            resize(2 * data.length);
        for(int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    public boolean contains (E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    public void remove(E e){
        int i = find(e);
        if (i != -1){
            remove(i);
        }
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("参数非法");
        }
        E retE = data[index];
        for (int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        return retE;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size: %d, capaciey: %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
