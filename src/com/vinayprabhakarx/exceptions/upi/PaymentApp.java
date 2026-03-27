package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.InvalidAmountException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidPinException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidUpiFormatException;
import com.vinayprabhakarx.exceptions.upi.exception.UpiNotFoundException;
import java.util.Scanner;

public class PaymentApp {

    private static final int MAX_PIN_ATTEMPTS = 3;

    private final LoginService loginService = new LoginService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        UPIServer server = new UPIServer();

        try {
            if (!loginService.login(sc, server)) {
                return;
            }

            while (true) {
                System.out.println("\nWelcome, " + server.getLoggedInUserDisplayName());
                System.out.println("1. Send Money");
                System.out.println("2. Check Balance");
                System.out.println("3. Change PIN");
                System.out.println("4. Terminate Session");
                int option = readMenuOption(sc);

                switch (option) {
                    case 1:
                        if (!sendMoney(sc, server)) {
                            System.out.println("\nSession terminated.");
                            return;
                        }
                        break;
                    case 2:
                        if (!checkBalance(sc, server)) {
                            System.out.println("\nSession terminated.");
                            return;
                        }
                        break;
                    case 3:
                        if (!changePin(sc, server)) {
                            System.out.println("\nSession terminated.");
                            return;
                        }
                        break;
                    case 4:
                        System.out.println("\nSession terminated.");
                        return;
                    default:
                        System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
                }
            }
        } finally {
            sc.close();
        }
    }

    private static int readMenuOption(Scanner sc) {
        while (true) {
            System.out.print("Enter option: ");
            if (!sc.hasNextLine()) {
                System.out.println("\nNo more input. Session terminated.");
                return 4;
            }
            String input = sc.nextLine().trim();

            try {
                int option = Integer.parseInt(input);
                if (option >= 1 && option <= 4) {
                    return option;
                }
            } catch (NumberFormatException e) {
                // Keep prompting until a valid numeric menu option is entered.
            }

            System.out.println("Invalid option. Please enter 1, 2, 3, or 4.");
        }
    }

    private static boolean sendMoney(Scanner sc, UPIServer server) {
        String upi = readUpiId(sc, server);
        if (upi.isEmpty()) {
            return false;
        }

        double amount = readAmount(sc, server);
        if (amount == -1) {
            return false;
        }

        int pin = readPin(sc, server, "Enter PIN to confirm payment: ");
        if (pin == -1) {
            return false;
        }

        TransactionResult result = server.paymentInitiated(upi, amount, pin);

        System.out.println("\n----- TRANSACTION STATUS -----");
        System.out.println("Status: " + (result.isSuccess() ? "SUCCESS" : "FAILED"));
        System.out.println("Message: " + result.getMessage());
        System.out.println("Balance: " + result.getBalance());
        return true;
    }

    private static boolean checkBalance(Scanner sc, UPIServer server) {
        int pin = readPin(sc, server, "Enter UPI PIN to check balance: ");
        if (pin == -1) {
            return false;
        }

        System.out.println("\nCurrent Balance: " + server.getBalance());
        return true;
    }

    private static String readUpiId(Scanner sc, UPIServer server) {
        while (true) {
            System.out.print("Enter recipient UPI ID: ");
            if (!sc.hasNextLine()) {
                System.out.println("\nNo more input. Session terminated.");
                return "";
            }

            String upi = sc.nextLine().trim();

            if (upi.isEmpty()) {
                System.out.println("UPI ID cannot be empty. Enter a valid UPI like name@bank.");
                continue;
            }

            try {
                UpiUser recipient = server.validateRecipientUpi(upi);
                System.out.println("Recipient found: " + recipient.getName() + " (" + recipient.getUpiId() + ")");
                return upi;
            } catch (InvalidUpiFormatException | UpiNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double readAmount(Scanner sc, UPIServer server) {
        while (true) {
            System.out.print("Enter amount: ");
            if (!sc.hasNextLine()) {
                System.out.println("\nNo more input. Session terminated.");
                return -1;
            }
            String input = sc.nextLine().trim();

            try {
                double amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }

                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a numeric value.");
            }
        }
    }

    private static int readPin(Scanner sc, UPIServer server, String prompt) {
        int invalidPinAttempts = 0;

        while (invalidPinAttempts < MAX_PIN_ATTEMPTS) {
            int pin = readNumericPin(sc, prompt);
            if (pin == -1) {
                return -1;
            }

            try {
                server.validateSenderPin(pin);
                System.out.println("PIN verified successfully.");
                return pin;
            } catch (InvalidPinException e) {
                invalidPinAttempts++;
                int attemptsLeft = MAX_PIN_ATTEMPTS - invalidPinAttempts;
                System.out.println("Incorrect UPI PIN.");
                if (attemptsLeft > 0) {
                    System.out.println("Please try again. Attempts left: " + attemptsLeft);
                }
            }
        }

        System.out.println("Too many incorrect PIN attempts. Session terminated.");
        return -1;
    }

    private static int readNumericPin(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextLine()) {
                System.out.println("\nNo more input. Session terminated.");
                return -1;
            }
            String input = sc.nextLine().trim();

            if (!input.matches("\\d{4}")) {
                System.out.println("Invalid PIN. Please enter digits only.");
                continue;
            }

            return Integer.parseInt(input);
        }
    }

    private static boolean changePin(Scanner sc, UPIServer server) {
        int invalidPinAttempts = 0;

        while (true) {
            int currentPin = readNumericPin(sc, "Enter current PIN: ");
            if (currentPin == -1) {
                return false;
            }
            int newPin = readNumericPin(sc, "Enter new PIN: ");
            if (newPin == -1) {
                return false;
            }
            int confirmPin = readNumericPin(sc, "Confirm new PIN: ");
            if (confirmPin == -1) {
                return false;
            }

            if (newPin != confirmPin) {
                System.out.println("New PIN and confirm PIN do not match.");
                continue;
            }

            try {
                server.changePin(currentPin, newPin);
                System.out.println("PIN changed successfully.");
                return true;
            } catch (InvalidPinException | InvalidAmountException e) {
                System.out.println(e.getMessage());
                if (e instanceof InvalidPinException) {
                    invalidPinAttempts++;
                    if (invalidPinAttempts >= MAX_PIN_ATTEMPTS) {
                        System.out.println("Too many incorrect PIN attempts. Session terminated.");
                        return false;
                    }
                }
            }
        }
    }
}
