package com.hwmo.test.华为机试练习;

import java.util.Scanner;

public class ContWord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int length = calcLengthOfLastWord1(str);
        System.out.println(length);
    }


    public static int calcLengthOfLastWord(String s){
        if(null == s || s.isEmpty()){
            return 0;
        }
        if(!s.contains(" ")){
            s.length();
        }

        String[] arr = s.split(" ");
        int length = 0;
        for(String str : arr){
            if(str != null && !"".equals(str.trim())){
                length = str.length();
            }
        }

        return length;
    }

    public static int calcLengthOfLastWord1(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        String[] arr = s.split(" ");
        String value = arr[arr.length - 1];
        return value.length();
    }

    public static int getLastStringNum(String st){
        int n = 0;
        if(st != null){
            String[] s = st.split(" ");
            System.out.println(s.length);
            String string = s[s.length-1];
            n = string.length();
        }
        return n;
    }


}
