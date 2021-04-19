package com.wangwei.datastructure.array;

/**
 * @Auther wangwei
 * @Date 2018/4/29 上午10:22
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认数组容量10
     */
    public Array() {
        this(10);
    }


    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向所有元素头添加一个新元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向index位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add e fail, require index >= 0 and index <= size");
        }
        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;

        size++;

    }

    /**
     * 获取索引为index的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Parameter error");
        return data[index];
    }


    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }


    /**
     * 更新索引为index的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Parameter error");
        data[index] = e;
    }

    /**
     * 判断数组中是否包含某个函数
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 获取指定元素的索引
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除index位置的元素并返回该元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Parameter error");

        E result = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        size--;
        return result;
    }

    /**
     * 删除数组中第一个元素并返回该元素
     *
     * @param
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int i = find(e);
        if (i != -1)
            remove(i);
    }

    /**
     * 删除数组中最后一个元素并返回该元素
     *
     * @param
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("index is illegal.");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}


