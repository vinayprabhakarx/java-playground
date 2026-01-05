package com.vinayprabhakarx.oops.encapsulation;

public class BankAccountTest {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // 1. Open account with null name
        try {
            account.openAccount(null);
        } catch (Exception e) {
            System.out.println("TEST 1 PASSED: " + e.getMessage());
        }

        // 2. Open account with empty name
        try {
            account.openAccount("   ");
        } catch (Exception e) {
            System.out.println("TEST 2 PASSED: " + e.getMessage());
        }

        // 3. Open account with valid name
        try {
            account.openAccount("Vinay Prabhakar");
            System.out.println("TEST 3 PASSED: Account opened successfully");
        } catch (Exception e) {
            System.out.println("TEST 3 FAILED: " + e.getMessage());
        }

        // 4. Open account again
        try {
            account.openAccount("Another Name");
        } catch (Exception e) {
            System.out.println("TEST 4 PASSED: " + e.getMessage());
        }

        // 5. Deposit negative amount
        try {
            account.deposit(-100);
        } catch (Exception e) {
            System.out.println("TEST 5 PASSED: " + e.getMessage());
        }

        // 6. Deposit valid amount
        try {
            double balance = account.deposit(1000);
            System.out.println("TEST 6 PASSED: Deposit ₹" + balance + " successful");
        } catch (Exception e) {
            System.out.println("TEST 6 FAILED: " + e.getMessage());
        }

        // 7. Withdraw more than balance
        try {
            account.withdraw(5000);
        } catch (Exception e) {
            System.out.println("TEST 7 PASSED: " + e.getMessage());
        }

        // 8. Withdraw negative amount
        try {
            account.withdraw(-200);
        } catch (Exception e) {
            System.out.println("TEST 8 PASSED: " + e.getMessage());
        }

        // 9. Valid withdrawal
        try {
            account.withdraw(300);
            System.out.println("TEST 9 PASSED: Withdrawal successful");
        } catch (Exception e) {
            System.out.println("TEST 9 FAILED: " + e.getMessage());
        }

        // 10. Get balance
        try {
            double balance = account.getBalance();
            System.out.println("TEST 10 PASSED: Balance = " + balance);
        } catch (Exception e) {
            System.out.println("TEST 10 FAILED: " + e.getMessage());
        }

        // 11. Get account details
        try {
            System.out.println("TEST 11 PASSED: Account Details:");
            System.out.println(account.getAccountDetails());
        } catch (Exception e) {
            System.out.println("TEST 11 FAILED: " + e.getMessage());
        }
    }
}
