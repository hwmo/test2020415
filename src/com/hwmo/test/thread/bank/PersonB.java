package com.hwmo.test.thread.bank;

public class PersonB extends Thread {
    Bank bank;
    String mode;

    public PersonB(Bank bank, String mode){
        this.bank = bank;
        this.mode = mode;
    }

   // @Override
    public void run() {
        if(bank.money >= 200){
            try {
                bank.outMoney(200, mode);
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
