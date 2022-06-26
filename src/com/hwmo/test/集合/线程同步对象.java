package com.hwmo.test.集合;

import java.util.*;

public class 线程同步对象 {

    public static void main(String[] args) {
        //看看下面对象哪些是线程安全的，看源码
        List l = new ArrayList<>();//方法没有synchronize关键字
        Vector v = new Vector();//很多方法有synchronize关键字

        HashMap<String, Object> map = new HashMap<>();//方法没有synchronize关键字
        Hashtable<String, Object> table = new Hashtable<>();//很多方法有synchronize关键字

        StringBuilder stringBuilder = new StringBuilder();//方法没有synchronize关键字
        StringBuffer stringBuffer = new StringBuffer();//很多方法有synchronize关键字


    }

}
