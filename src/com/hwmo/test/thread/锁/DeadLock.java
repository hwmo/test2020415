package com.hwmo.test.thread.锁;

import com.hwmo.test.socket.reconnect.SocketUtil;

public class DeadLock {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("t1 lock o1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println("t1 lock o2");
                    }

                }
                System.out.println("----------------t1执行完成-----------");//死锁导致这条语句没有执行到
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("t2 lock o2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println("t2 lock o1");
                    }
                }
                System.out.println("----------------t2执行完成-----------");//死锁导致这条语句没有执行到
            }
        });

        t1.start();
        t2.start();//死锁发生

        System.out.println("---------------------------");
    }



}
