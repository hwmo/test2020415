package com.hwmo.test.thread.线程通信;


public class Join通信 {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value = "1";

    public static void main(String[] args) {

        Join通信 j = new Join通信();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j.setValue("1000");

            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();//线程间通信
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String v = j.getValue();//j.value获取也行

                System.out.println(v);
            }
        });
        thread2.start();
    }

}

