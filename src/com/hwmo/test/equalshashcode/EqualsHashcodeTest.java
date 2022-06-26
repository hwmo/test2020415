package com.hwmo.test.equalshashcode;

import java.sql.SQLOutput;

public class EqualsHashcodeTest {



    public static void main(String[] args) {
        People p1 = new People("mhw", 12);
        People p2 = new People("mhw", 12);
        System.out.println(p1 == p2);//false
        System.out.println(p1.equals(p2));//true
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        A a1 = new A("mhw", 1);
        A a2 = new A("mhw", 1);
        System.out.println(a1.equals(a2));//false
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());


        

    }

}

class People{
    private String name;
    private int age;

    public People(String name, int age){
        this.age=age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int factorIndex = 31;

        int value = 1;

        value = value * factorIndex + age;
        value = value * factorIndex + (name == null ? 0 : name.hashCode());

        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        People people = (People)obj;
        if(people.age != age){
            return false;
        }
        if(name == null){
            if(people.name != null){
                return false;
            }
        }else if(!name.equals(people.name)){
            return false;
        }

        return true;
    }
}

class A{
    private String name;
    private int age;

    public A(String name, int age){
        this.name = name;
        this.age = age;
    }

}

