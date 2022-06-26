package com.hwmo.test.jdk8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        List<Integer> collect = intList.stream().filter(x -> x > 7).collect(Collectors.toList());
        System.out.println(collect);

        //引用类型筛选
        List<Person> list = new ArrayList<Person>();
        Person p = new Person("mhw", 20000);
        list.add(p);
        p = new Person("myc", 40000);
        list.add(p);

        List<Person> newList = list.stream().filter(x -> x.getSalary() > 30000).collect(Collectors.toList());

        System.out.println(newList.size());

        long count = intList.stream().count();
        System.out.println(count);

    }
}


class Person{
    private String name;
    private int salary;

    public Person(String name, int salary){
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}