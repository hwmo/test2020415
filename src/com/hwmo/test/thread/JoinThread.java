package com.hwmo.test.thread;

public class JoinThread extends Thread {
    private Thread thread;

    public JoinThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + "开始执行 ");
        try {
            thread.join();
            for (int i = 0; i < 4; i++) {
                System.out.println(thread.getName() + "的执行 " + i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + "执行完毕！");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
//        Thread previousThread = new Thread();
        for (int i = 1; i <= 5; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }

    }
}
