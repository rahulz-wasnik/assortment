package com.javaconcepts.leet.code.queue;

import java.util.*;

public class ReverseFirstKElementsInQueue {

    public Queue<Integer> reverse (Queue<Integer> queue, int k) {

        List<Integer> list = new ArrayList();
        int remaining = queue.size() - k;

        while (k != 0) {
            list.add(queue.poll());
            k--;
        }

        Collections.reverse(list);

        for(Integer val: list) {
            queue.add(val);
        }

        while (remaining != 0) {
            queue.add(queue.poll());
            remaining--;
        }

        System.out.println(queue);

        return queue;
    }

    public static void main(String[] args) {
        ReverseFirstKElementsInQueue reverseFirstKElementsInQueue = new ReverseFirstKElementsInQueue();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        reverseFirstKElementsInQueue.reverse(queue, 3);
    }
}
