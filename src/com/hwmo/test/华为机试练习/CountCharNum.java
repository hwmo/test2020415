package com.hwmo.test.华为机试练习;

import java.util.Scanner;

public class CountCharNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();

        System.out.println("20220416");
        int count = 0;

        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(c.equalsIgnoreCase(chars[i]+"")){
                count++;
            }
        }
        System.out.println(count);

        scanner.close();

//        readUser();
    }

    //检验所给字符串是否为数字、字母的组合
    public static boolean matchLetterDigit(String str){
        if(str == null){
            return false;
        }
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    public static void readUser(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }

}
