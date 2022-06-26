package com.hwmo.test.jvm;

public class StatckOverFlowTest {

    static int statckLeng = 1;

    public static void main(String[] args) {

        while(true){
            statckLeng++;
            System.out.println(statckLeng);
        }
    }



}
