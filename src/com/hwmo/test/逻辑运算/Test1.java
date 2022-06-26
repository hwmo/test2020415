package com.hwmo.test.逻辑运算;

public class Test1 {

    public static void main(String[] args) {
        //左移与右移运算
        System.out.println(17>>>1);//10001->1000 => 8
        System.out.println(5<<2);
        System.out.println(13>>>2);

        //(n-1)&m与m%(n+1)的运算结果是一样的。其中，n为数组长度，为2的整数次幂
        System.out.println(15&31);
        System.out.println(31%16);


    }

}
