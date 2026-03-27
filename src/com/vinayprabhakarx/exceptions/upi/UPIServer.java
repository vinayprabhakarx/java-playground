package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.AuthenticationException;
import com.vinayprabhakarx.exceptions.upi.exception.InsufficientBalanceException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidAmountException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidPinException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidUpiFormatException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidUsernameFormatException;
import com.vinayprabhakarx.exceptions.upi.exception.UpiNotFoundException;

public class UPIServer {

    private static final String UPI_ID_REGEX = "^[a-zA-Z0-9._-]{2,}@[a-zA-Z]{2,}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{2,}$";

    private final UpiUserDatabase userDatabase = new UpiUserDatabase();
    private UpiUser loggedInUser;

    public UpiUser login(String username, int pin) throws AuthenticationException {
        UpiUser user;
        try {
            user = validateUsername(username);
        } catch (InvalidUsernameFormatException e) {
            throw new AuthenticationException(e.getMessage());
        }

        if (!user.isPinValid(pin)) {
            throw new AuthenticationException("Invalid PIN");
        }

        loggedInUser = user;
        return user;
    }

    public UpiUser validateUsername(String username)
            throws InvalidUsernameFormatException, AuthenticationException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidUsernameFormatException("Username is required");
        }

        String normalizedUsername = username.trim();
        if (!normalizedUsername.matches(USERNAME_REGEX)) {
            throw new InvalidUsernameFormatException(
                    "Invalid username format. Use only letters, numbers, dot, underscore, or hyphen."
            );
        }

        UpiUser user = userDatabase.findByUsername(normalizedUsername);
        if (user == null) {
            throw new AuthenticationException("User not found");
        }

        return user;
    }

    public TransactionResult paymentInitiated(String upi, double amount, int pin) {
        boolean amountDebited = false;
        UpiUser sender = requireLoggedInUser();

        try {
            UpiUser recipient = validatePaymentRequest(upi, pin, sender);

            sender.debit(amount);
            amountDebited = true;

            recipient.credit(amount);

            return new TransactionResult(
                    true,
                    "Payment successful to " + recipient.getName() + " (" + recipient.getUpiId() + ")",
                    sender.getBalance()
            );

        } catch (InvalidPinException | UpiNotFoundException | InvalidUpiFormatException e) {
            return new TransactionResult(false, e.getMessage(), getBalanceOrZero(sender));

        } catch (InsufficientBalanceException | InvalidAmountException e) {
            return new TransactionResult(false, e.getMessage(), getBalanceOrZero(sender));

        } catch (Exception e) {
            if (amountDebited) {
                try {
                    sender.refund(amount);
                } catch (InvalidAmountException refundException) {
                    return new TransactionResult(
                            false,
                            "Payment failed and refund could not be completed: " + refundException.getMessage(),
                            getBalanceOrZero(sender)
                    );
                }

                return new TransactionResult(false, "Payment failed. Amount refunded.", getBalanceOrZero(sender));
            }

            return new TransactionResult(false, "Payment failed before money was debited.", getBalanceOrZero(sender));
        }
    }

    public double getBalance() {
        UpiUser sender = requireLoggedInUser();
        return getBalanceOrZero(sender);
    }

    public UpiUser validateRecipientUpi(String recipientUpi)
            throws UpiNotFoundException, InvalidUpiFormatException {
        UpiUser sender = requireLoggedInUser();
        return validateRecipientUpi(recipientUpi, sender);
    }

    public void validateSenderPin(int pin) throws InvalidPinException {
        UpiUser sender = requireLoggedInUser();
        if (sender == null) {
            throw new IllegalStateException("Sender account is not available");
        }

        if (!sender.isPinValid(pin)) {
            throw new InvalidPinException("Invalid PIN");
        }
    }

    public void changePin(int currentPin, int newPin)
            throws InvalidPinException, InvalidAmountException {
        UpiUser sender = requireLoggedInUser();

        if (newPin < 1000 || newPin > 9999) {
            throw new InvalidAmountException("New PIN must be a 4-digit number");
        }

        sender.changePin(currentPin, newPin);
    }

    public String getLoggedInUserDisplayName() {
        UpiUser sender = requireLoggedInUser();
        return sender.getName() + " (" + sender.getUpiId() + ")";
    }

    private UpiUser validatePaymentRequest(String recipientUpi, int pin, UpiUser sender)
            throws InvalidPinException, UpiNotFoundException, InvalidUpiFormatException {
        if (sender == null) {
            throw new IllegalStateException("Sender account is not available");
        }

        validateSenderPin(pin);

        return validateRecipientUpi(recipientUpi, sender);
    }

    private double getBalanceOrZero(UpiUser user) {
        return user != null ? user.getBalance() : 0;
    }

    private UpiUser requireLoggedInUser() {
        if (loggedInUser == null) {
            throw new IllegalStateException("No user is logged in");
        }

        return loggedInUser;
    }

    private UpiUser validateRecipientUpi(String recipientUpi, UpiUser sender)
            throws UpiNotFoundException, InvalidUpiFormatException {
        if (sender == null) {
            throw new IllegalStateException("Sender account is not available");
        }

        if (recipientUpi == null || recipientUpi.trim().isEmpty()) {
            throw new UpiNotFoundException("Recipient UPI ID is required");
        }

        String normalizedRecipientUpi = recipientUpi.trim();
        if (!normalizedRecipientUpi.matches(UPI_ID_REGEX)) {
            throw new InvalidUpiFormatException("Invalid UPI ID format. Use format like name@bank");
        }

        UpiUser recipient = userDatabase.findByUpi(normalizedRecipientUpi);
        if (recipient == null) {
            throw new UpiNotFoundException("User not found for this UPI ID");
        }

        if (sender.getUpiId().equalsIgnoreCase(recipient.getUpiId())) {
            throw new UpiNotFoundException("Sender and recipient UPI IDs cannot be the same");
        }

        return recipient;
    }
}
