package com.hwmo.test.jvm;

public class OverFlowTest {

    public static void main(String[] args) {
        a();
    }

    public static void a(){
        b();
    }
    public static void b(){
        c();
    }
    public static void c(){
        d();
    }
    public static void d(){
        System.out.println("----------------");
        d();//递归调用，会抛StackOverflowError异常
    }
}
