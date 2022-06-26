package com.hwmo.test.thread.线程通信.wait_notify.生产消费模式;

import java.util.LinkedList;
import java.util.Queue;

public class MainTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;
        Product p = new Product(queue, maxSize);
        Consumer c = new Consumer(queue, maxSize);

        new Thread(p).start();
        new Thread(c).start();
    }
}
