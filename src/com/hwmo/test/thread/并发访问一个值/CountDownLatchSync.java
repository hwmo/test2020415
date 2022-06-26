package com.hwmo.test.thread.并发访问一个值;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountDownLatchSync {

    private static long num = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        int threadSize = 100;
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(threadSize);
        Object o = new Object();
        for(int i = 0; i < threadSize; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o){
                        for (int j = 0; j < 10000; j++){
                            num++;
                        }
                        latch.countDown();
                    }

                }

            });
            service.execute(thread);

        }

        latch.await();
        //Thread.sleep(5000);
        System.out.println(num);
        service.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" +(end-start)+"毫秒");
    }

}
