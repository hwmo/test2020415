package com.hwmo.test.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Put返回旧值 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println("第一次put返回值："+map.put("mhw", "ksdfjlk"));
        System.out.println("第二次put返回值："+map.put("mhw", "myc"));
    }

}
