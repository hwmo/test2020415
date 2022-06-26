package com.hwmo.test.thread.并发访问一个值;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreThreadSleep {

    private static long num = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadSize = 1000;
        Semaphore semaphore = new Semaphore(1);

        ExecutorService service = Executors.newCachedThreadPool();
        Thread[] threads = new Thread[threadSize];
        //Queue<Thread> queue = new LinkedList<>();

        for(int i = 0; i < threadSize; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        for (int j = 0; j < 10000; j++){
                            num++;
                        }
                        semaphore.release(1);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            service.execute(thread);
            //queue.add(thread);
        }



      /*  Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    try {
                        //this.wait();
                        semaphore.acquire();
                        System.out.println(num);
                        service.shutdown();
                        long end = System.currentTimeMillis();
                        System.out.println("耗时：" +(end-start)+"毫秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        };
        service.execute(runnable);*/


        //latch.await();
        Thread.sleep(1000);//笨方法让所有线程执行完，休眠时间足够长（所有线程执行完）
        System.out.println(num);
        service.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" +(end-start)+"毫秒");

    }

}
