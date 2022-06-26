package com.hwmo.test.thread.bank;

public class PersonA extends Thread {
    Bank bank;
    String mode;

    public PersonA(Bank bank, String mode){
        this.bank = bank;
        this.mode = mode;
    }

    //@Override
    public void run(){
        while (bank.money >= 100){
            try {
                bank.outMoney(100, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
