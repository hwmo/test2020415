package com.hwmo.test.thread.并发访问一个值;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchLock {

    private static long num = 0;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        int taskSize = 100;
        CountDownLatch latch = new CountDownLatch(taskSize);
        Lock lock = new ReentrantLock();
        for(int i =0; i < taskSize; i++){

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    for (int j = 0; j < 10000; j++){
                        num++;
                    }
                    lock.unlock();
                    latch.countDown();
                }
            });
            thread.start();
        }

        latch.await();
        System.out.println(num);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - start) + "毫秒");
    }

}
