package com.hwmo.test.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryTest {

    static class A{

    }

    public static void main(String[] args) throws InterruptedException {
        //下面代码执行久了抛Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        List<A> list = new ArrayList<A>();
        while(true){
            list.add(new A());
            System.out.println("-------------------");
//            Thread.sleep(1);
        }
    }
}
