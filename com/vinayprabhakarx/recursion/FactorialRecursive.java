package com.vinayprabhakarx.recursion;

import java.util.Scanner;

// Task: Print factorial expression and return factorial using recursion
public class FactorialRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        int result = factorial(num);
        System.out.println(" = " + result);
    }

    public static int factorial(int num) {
        // Base condition
        if (num == 1) {
            System.out.print("1");
            return 1;
        }

        // Print current number
        System.out.print(num + " * ");

        // Recursive call
        return num * factorial(num - 1);
    }
}
