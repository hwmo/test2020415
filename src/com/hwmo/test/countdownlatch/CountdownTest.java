package com.hwmo.test.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch latchOrder = new CountDownLatch(1);//裁判
        final CountDownLatch latchAnswer = new CountDownLatch(3);//选手
        for (int i = 0; i < 3; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("选手"+Thread.currentThread().getName()+"正在等待裁判发令");
                        latchOrder.await();
                        System.out.println("选手"+Thread.currentThread().getName()+"已接收发令");
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println("选手"+Thread.currentThread().getName()+"到达终点");
                        latchAnswer.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        Thread.sleep((long)(Math.random() * 10000));
        System.out.println("裁判即将发令");
        latchOrder.countDown();
        System.out.println("裁判已经发令，正在等待选手到达终点");
        //Thread.sleep(1000);
        latchAnswer.await();
        System.out.println("所有选手到达终点！");
        System.out.println("裁判在汇总成绩");
        service.shutdown();
    }
}
