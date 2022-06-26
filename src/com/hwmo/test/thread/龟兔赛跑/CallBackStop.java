package com.hwmo.test.thread.龟兔赛跑;

public class CallBackStop implements Animal.Callback {
    Animal a;

    public CallBackStop(Animal a){
        this.a = a;
    }

    @Override
    public void win() {
        a.stop();
    }
}
