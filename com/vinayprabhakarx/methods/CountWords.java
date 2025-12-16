package com.vinayprabhakarx.methods;

import java.util.Scanner;

public class CountWords {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String str = scanner.nextLine();
            System.out.println("Total words in string: " + wordCount(str));
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    static int wordCount(String str) {
        try {
            if (str == null) {
                return 0;
            }

            // Remove accidental quotes and normalize spaces
            str = str.replace("\"", "").trim();

            if (str.isEmpty()) {
                return 0;
            }

            // Split on one or more whitespace characters
            return str.split("\\s+").length;

        } catch (Exception e) {
            // Absolute safety fallback
            return 0;
        }
    }
}
