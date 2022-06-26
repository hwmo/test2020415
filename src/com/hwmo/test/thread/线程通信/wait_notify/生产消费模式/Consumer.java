package com.hwmo.test.thread.线程通信.wait_notify.生产消费模式;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int v = queue.remove();
                System.out.println("Consumer " + v);
                queue.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
