package com.vinayprabhakarx.threads;
// Create a BankAccount class where multiple threads perform deposit and withdraw operations concurrently.
/*
Requirements:
Initial balance = 1000
3 thread deposit money
3 thread withdraw money
Prevent race conditions using synchronized
Withdraw should fail if Insufficient balance
*/

public class BankConcurrent {
    public static void main(String[] args) {  // FIXED
        Bank account = new Bank(1000);

        // Deposit threads
        Runnable depositTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(500);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // better practice
                }
            }
        };

        // Withdraw threads
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(500);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // better practice
                }
            }
        };

        // Creating 3 deposit threads
        Thread d1 = new Thread(depositTask, "Deposit-1");
        Thread d2 = new Thread(depositTask, "Deposit-2");
        Thread d3 = new Thread(depositTask, "Deposit-3");

        // Creating 3 withdraw threads
        Thread w1 = new Thread(withdrawTask, "Withdraw-1");
        Thread w2 = new Thread(withdrawTask, "Withdraw-2");
        Thread w3 = new Thread(withdrawTask, "Withdraw-3");

        // Start all threads
        d1.start(); d2.start(); d3.start();
        w1.start(); w2.start(); w3.start();
    }
}

class Bank {
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    // synchronized deposit method
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposited " + amount + ", Balance: " + balance);
    }

    // synchronized withdraw method
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " failed to withdraw " + amount +
                    " (Insufficient Balance: " + balance + ")");
        }
    }
}