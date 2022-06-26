package com.hwmo.test.集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedvsArrayList效率比较 {

    private static int N = 500000;

    public static void main(String[] args) {
        List list = addList(new ArrayList());
        List linkedList = addList(new LinkedList());
        System.out.println("ArrayList查找"+N+"条耗时："+readList(list));
        System.out.println("LinkedList"+N+"条耗时："+readList(linkedList));
    }

    static long readList(List list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++){
            Object o = list.get(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
    static List addList(List list){
        for(int i=0; i < N; i++){
            Object o = new Object();
            list.add(0, o);
        }
        return list;
    }

    static long timeArrayList(List list){
        long start = System.currentTimeMillis();
//        List<Object> list = new ArrayList<>();
        for(int i=0; i < N; i++){
            Object o = new Object();
            list.add(0, o);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

}
