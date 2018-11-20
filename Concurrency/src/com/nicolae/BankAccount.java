package com.nicolae;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    //   Challenge 1
//    private double balance;
//    private String accountNumber;
//
//    public BankAccount(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//    }
//
//    public void deposit(double amount) {
//        balance += amount;
//    }
//
//    public void withdraw(double amount) {
//        balance -= amount;
//    }
//
//    public double getBalance() {
//        return balance;
//    }

    // === Challenge 2 - Make the BankAccount class Threadsafe using the synchronize keyword  ===
//    private double balance;
//    private String accountNumber;

//    public BankAccount(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//    }
//
//     // One way of doing it
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }
//
//     // Second way of doing it synchronized with in
//    public  void deposit(double amount) {
//        synchronized (this){
//            balance += amount;
//        }
//    }
//
//    public  void withdraw(double amount) {
//        synchronized (this){
//            balance -= amount;
//        }
//    }
//

    // === Challenge 3 - Make the BankAccount class threadsafe using the ReentrantLock class ===
//    private double balance;
//    private String accountNumber;
//
//    private Lock lock;
//
//    public BankAccount(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//        this.lock = new ReentrantLock();
//    }
//
//    public  void deposit(double amount) {
//        lock.lock();
//        try{
//            balance += amount;
//        }finally{
//            lock.unlock();
//        }
//    }
//
//    public  void withdraw(double amount) {
//       lock.lock();
//       try{
//           balance -= amount;
//       }finally {
//           lock.unlock();
//       }
//
//    }

    // === Challenge 4 - Use tryLock with a timeout value ===
//    private double balance;
//    private String accountNumber;
//
//    private Lock lock;
//
//    public BankAccount(String accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//        this.lock = new ReentrantLock();
//    }
//
//    public  void deposit(double amount) {
//      try{
//          if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
//              try{
//                  balance += amount;
//              }finally {
//                  lock.unlock();
//              }
//          }else{
//              System.out.println("Could not get the lock");
//          }
//
//      }catch(InterruptedException e){
//          //do something here
//      }
//    }
//
//    public  void withdraw(double amount) {
//      try{
//          if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
//              try{
//                  balance -= amount;
//              }finally {
//                  lock.unlock();
//              }
//          }else{
//              System.out.println("Could not get the lock");
//          }
//
//      }catch(InterruptedException e) {
//          // do something here
//      }
//
//    }

    // === Challenge 5 - update the code so that the status variable is threat safe ===
    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public  void deposit(double amount) {

        boolean status = false; // the status variable is a local variable, it's already threadsafe

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance += amount;
                    status = true;
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("Could not get the lock");
            }

        }catch(InterruptedException e){
            //do something here
        }
        System.out.println("Transaction status = " + status);
    }

    public  void withdraw(double amount) {

        boolean status = false; // the status variable is a local variable, it's already threadsafe

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance -= amount;
                    status = true;
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("Could not get the lock");
            }

        }catch(InterruptedException e) {
            // do something here
        }
        System.out.println("Transaction status = " + status);

    }

}