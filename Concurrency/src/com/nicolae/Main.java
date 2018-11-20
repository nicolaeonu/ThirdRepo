package com.nicolae;

public class Main {

    public static void main(String[] args) {

        // === Challenge 1 - Create and start 2 threads ===

        final BankAccount account = new BankAccount("35754-876", 1000.00);

        // First way of doing it,
//        Thread trThread1 = new Thread(){
//            public void run() {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//                System.out.println(account.getBalance());
//            }
//        };
//        Thread trThread2 = new Thread(){
//            public void run(){
//                account.deposit(203.00);
//                account.withdraw(100.00);
//                System.out.println(account.getBalance());
//            }
//        };

        // Second way, create and start threads using runnable interface.
        Thread trThread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });

        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.00);
                account.withdraw(100.00);
            }
        });

        trThread1.start();
        trThread2.start();
    }
}
