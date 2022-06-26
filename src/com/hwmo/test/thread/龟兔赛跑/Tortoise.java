package com.hwmo.test.thread.龟兔赛跑;

public class Tortoise extends Animal {

    public Tortoise(){
        setName("乌龟");
    }
    @Override
    public void running() {
        int dis = 2;
        length -= dis;
        System.out.println("乌龟跑了"+dis+"米，距离终点还剩"+length+"米");
        if(length <= 0){
            length = 0;
            System.out.println("乌龟获得了胜利！");
            if(callback != null){
                callback.win();
            }
        }

        try {
            sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
