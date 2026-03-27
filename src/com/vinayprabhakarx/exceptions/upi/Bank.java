package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.InsufficientBalanceException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidAmountException;

public class Bank {

    private double balance;

    public Bank(double openingBalance) {
        this.balance = openingBalance;
    }

    public double debit(double amount) throws InsufficientBalanceException, InvalidAmountException {
        validateAmount(amount);

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        return balance;
    }

    public void refund(double amount) throws InvalidAmountException {
        validateAmount(amount);
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    private void validateAmount(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
    }
}
