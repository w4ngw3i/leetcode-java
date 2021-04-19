package com.wangwei.datastructure.queue;

/**
 * @Auther wangwei
 * @Date 2018/5/1 下午6:40
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入列
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出列
     *
     * @return
     */
    E dequeue();

    E getFront();
}
