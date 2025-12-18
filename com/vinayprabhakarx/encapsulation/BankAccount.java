package com.vinayprabhakarx.encapsulation;

import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    private long accountNumber;
    private String accountHolderName;
    private double balance;
    private boolean isActive;

    // Account number generator
    private static long generateAccountNumber() {
        int year = Year.now().getValue();
        int randomPart = ThreadLocalRandom.current().nextInt(100_000, 1_000_000);
        return (long) year * 1_000_000 + randomPart;
    }

    // Open account
    public void openAccount(String accountHolderName) {
        if (isActive) {
            throw new IllegalStateException("Account is already active.");
        }

        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be null or empty.");
        }
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName.trim().toUpperCase();
        this.balance = 0.0;
        this.isActive = true;

        String firstName = this.accountHolderName.split("\\s+")[0];

        String capitalizedName = firstName.substring(0, 1).toUpperCase()
                + firstName.substring(1).toLowerCase();

        System.out.println("Welcome, " + capitalizedName + "! Your account has been successfully opened.");

    }

    // Deposit money
    public double deposit(double amount) {
        validateAccount();
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        return balance += amount;
    }

    // Withdraw money
    public void withdraw(double amount) {
        validateAccount();
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }

    // Get balance
    public double getBalance() {
        validateAccount();
        return balance;
    }

    // Get account details
    public String getAccountDetails() {
        validateAccount();
        return """
                Account Number : %d
                Holder Name    : %s
                Balance        : %.2f
                """.formatted(accountNumber, accountHolderName, balance);
    }

    // Validation helper
    private void validateAccount() {
        if (!isActive) {
            throw new IllegalStateException("Account is not active.");
        }
    }
}
