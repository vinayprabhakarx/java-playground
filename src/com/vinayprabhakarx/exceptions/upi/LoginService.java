package com.vinayprabhakarx.exceptions.upi;

import com.vinayprabhakarx.exceptions.upi.exception.AuthenticationException;
import com.vinayprabhakarx.exceptions.upi.exception.InvalidUsernameFormatException;
import java.util.Scanner;

public class LoginService {

    private static final int MAX_PIN_ATTEMPTS = 3;

    public boolean login(Scanner sc, UPIServer server) {
        while (true) {
            UpiUser user = readUsername(sc, server);
            if (user == null) {
                return false;
            }

            int invalidPinAttempts = 0;
            while (invalidPinAttempts < MAX_PIN_ATTEMPTS) {
                int pin = readNumericPin(sc, "Enter login PIN: ");
                if (pin == -1) {
                    return false;
                }

                try {
                    UpiUser loggedInUser = server.login(user.getUsername(), pin);
                    System.out.println("\nLogin successful for " + loggedInUser.getName() + " (" + loggedInUser.getUpiId() + ")");
                    return true;
                } catch (AuthenticationException e) {
                    System.out.println(e.getMessage());
                    if ("Invalid PIN".equals(e.getMessage())) {
                        invalidPinAttempts++;
                        if (invalidPinAttempts >= MAX_PIN_ATTEMPTS) {
                            System.out.println("Too many incorrect PIN attempts. Session terminated.");
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private UpiUser readUsername(Scanner sc, UPIServer server) {
        while (true) {
            System.out.print("Enter username (part before @ in your UPI ID): ");
            if (!sc.hasNextLine()) {
                System.out.println("\nNo more input. Session terminated.");
                return null;
            }

            String username = sc.nextLine().trim();
            try {
                UpiUser user = server.validateUsername(username);
                System.out.println("Username found: " + user.getName() + " (" + user.getUpiId() + ")");
                return user;
            } catch (InvalidUsernameFormatException | AuthenticationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readNumericPin(Scanner sc, String prompt) {
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
}
