package com.hwmo.test.thread.并发访问一个值;

import java.util.concurrent.Semaphore;

/**
 4.   * 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
 5. 线程的阻塞和释放是通过 permit 概念来实现的
 6.   * 线程通过 semaphore.acquire()方法获取 permit，如果当前 semaphore 有 permit 则分配给该线程，
 7. 如果没有则阻塞该线程直到 semaphore
 8.   * 调用 release（）方法释放 permit。
 9.   * 构造函数中参数：permit（允许） 个数，
 10.   */
public class SemaphoreTest {

    private static int num = 0;
    private  static Semaphore semaphore = new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                num = 1;

                semaphore.release(2);
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"获得num值为："+num);
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获得num值为："+num);
            }
        });


        b.start();
        c.start();
        Thread.sleep(1000);//不管线程a什么时候初始化num值，bc线程都会等待a初始化完成
        a.start();
    }

}
