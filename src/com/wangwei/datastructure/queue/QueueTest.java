package com.wangwei.datastructure.queue;

/**
 * @Auther wangwei
 * @Date 2018/5/1 下午6:55
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            System.out.println(i + "%" + 3 + "=" + i % 3);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
