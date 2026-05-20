package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.InsufficientBalanceException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidAmountException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidPinException;

public class UpiUser {

    private final String name;
    private final String upiId;
    private int pin;
    private double balance;

    public UpiUser(String name, String upiId, int pin, double balance) {
        this.name = name;
        this.upiId = upiId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getUpiId() {
        return upiId;
    }

    public boolean isPinValid(int enteredPin) {
        return pin == enteredPin;
    }

    public String getUsername() {
        int atIndex = upiId.indexOf('@');
        return atIndex >= 0 ? upiId.substring(0, atIndex) : upiId;
    }

    public double getBalance() {
        return balance;
    }

    public void changePin(int currentPin, int newPin) throws InvalidPinException {
        if (!isPinValid(currentPin)) {
            throw new InvalidPinException("Current PIN is incorrect");
        }

        pin = newPin;
    }

    public void debit(double amount) throws InvalidAmountException, InsufficientBalanceException {
        validateAmount(amount);

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
    }

    public void credit(double amount) throws InvalidAmountException {
        validateAmount(amount);
        balance += amount;
    }

    public void refund(double amount) throws InvalidAmountException {
        credit(amount);
    }

    private void validateAmount(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }
    }
}
