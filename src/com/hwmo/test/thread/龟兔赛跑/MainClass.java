package com.hwmo.test.thread.龟兔赛跑;

public class MainClass {

    public static void main(String[] args) {

        Rabbit rabbit = new Rabbit();
        CallBackStop stopRabbit = new CallBackStop(rabbit);

        Tortoise tortoise = new Tortoise();
        CallBackStop stopTortoise = new CallBackStop(tortoise);

        rabbit.callback = stopTortoise;
        tortoise.callback = stopRabbit;

        rabbit.start();
        tortoise.start();

    }

}
