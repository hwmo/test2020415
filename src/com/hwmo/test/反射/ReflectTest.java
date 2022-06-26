package com.hwmo.test.反射;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        A a = new A();
        Class class1 = a.getClass();

        Class class2 = A.class;

        Class class3 = Class.forName("com.hwmo.test.反射.A");

        System.out.println(class1 == class2);

        System.out.println(class1 == class3);

        A aa = (A) class1.newInstance();
        aa.sayHello();
    }

}

class A{

    public void sayHello(){
        System.out.println("hello");
    }
}
