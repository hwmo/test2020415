package com.hwmo.test.thread.bank;

public class MainClass {


    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA a = new PersonA(bank, "COUNTER");
        PersonA a2 = new PersonA(bank, "ATM");
        PersonB b = new PersonB(bank, "ATM");
        a.start();
        b.start();
        //a2.start();
    }

}
