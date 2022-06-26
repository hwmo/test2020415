package com.hwmo.test.thread.龟兔赛跑;

public class Rabbit extends Animal {

    public Rabbit(){
        setName("兔子");
    }

    @Override
    public void running() {
        int dis = 5;

        length -= dis;

        System.out.println("兔子跑了"+dis+"米，距离终点还有"+length+"米");

        if(length <= 0){
            length = 0;
            System.out.println("兔子获得了胜利！");

            if(callback != null){
                callback.win();
            }
        }

        try {
            if((2000-length) % 20 == 0){
                sleep(1000);
            }else {
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
