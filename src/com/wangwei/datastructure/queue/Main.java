package com.wangwei.datastructure.queue;

import java.util.Random;

/**
 * @Auther wangwei
 * @Date 2018/5/1 下午9:11
 */
public class Main {


    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time:" + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time:" + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time:" + time3 + " s");
    }


    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
//        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
//        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000000000.0;

//        return endTime - startTime;

    }
}

