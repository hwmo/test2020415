package com.hwmo.test.thread.并发访问一个值;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountDownLatchSemaphore {

    private static long num = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadSize = 1000000;
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(threadSize);

        ExecutorService service = Executors.newCachedThreadPool();
        //Thread[] threads = new Thread[threadSize];

        for(int i = 0; i < threadSize; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        for (int j = 0; j < 10000; j++){
                            num++;
                        }
                        latch.countDown();
                        semaphore.release(1);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            service.execute(thread);
        }


        latch.await();
        System.out.println(num);
        service.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" +(end-start)+"毫秒");

    }

}
