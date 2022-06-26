package com.hwmo.test.thread.bank;

import java.util.Objects;

public class Bank {

    static double money = 1000;//假设一个账户有1000块钱

    //柜台取钱的方法
    private void counter(double money){
        Bank.money -= money;
        System.out.println("柜台取钱"+money+"元，还剩"+ Bank.money);
    }

    //ATM取钱方法
    private void atm(double money){
        Bank.money -= money;
        System.out.println("ATM取钱"+money+"元，还剩"+ Bank.money);
    }

    //取钱的方法，防止直接调取方法同时取钱时，并发余额显示错误
    public synchronized void outMoney(double money, String mode) throws Exception{
        if(money > Bank.money){
            throw new Exception("取款失败！余额不足，余额为"+ Bank.money);
        }
        if(Objects.equals(mode, "ATM")){
            atm(money);
        }else {
            counter(money);
        }
    }

}
