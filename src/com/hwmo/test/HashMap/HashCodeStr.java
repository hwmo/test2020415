package com.hwmo.test.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashCodeStr {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        List<String> list = Arrays.asList("Aa", "BB", "C#", "DD");
        for(String  s : list){
            System.out.println(s.hashCode());
            map.put(s,s);
        }
    }

}
