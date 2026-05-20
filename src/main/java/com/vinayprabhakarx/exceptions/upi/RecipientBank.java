package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.InvalidAmountException;

public class RecipientBank {

    private double balance = 0;

    void credit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        balance += amount;
        System.out.println("Recipient credited with: " + amount);
    }

    public double getBalance() {
        return balance;
    }
}
