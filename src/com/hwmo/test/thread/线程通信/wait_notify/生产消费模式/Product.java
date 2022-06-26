package com.hwmo.test.thread.线程通信.wait_notify.生产消费模式;

import java.util.Queue;
import java.util.Random;

public class Product implements Runnable{

    private Queue<Integer> queue;
    private int maxSize;
    public Product(Queue<Integer> queue, int maxSize){

        this.queue = queue;
        this.maxSize = maxSize;
    }
    @Override
    public void run() {

        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try {
                        System.out.println("Queue is full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random r = new Random();
                int value = r.nextInt();
                System.out.println("Product "+value);
                queue.add(value);
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
