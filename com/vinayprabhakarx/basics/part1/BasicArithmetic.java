package com.vinayprabhakarx.basics.part1;

import java.util.Scanner;

public class BasicArithmetic {
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Addition
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));

            // Subtraction
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));

            // Multiplication
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));

            // Division
            if (num2 != 0) {
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            } else {
                System.out.println("Division by zero is not allowed.");
            }

            // Modulus
            if (num2 != 0) {
                System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
            } else {
                System.out.println("Modulus by zero is not allowed.");
            }
        }
    }

}
