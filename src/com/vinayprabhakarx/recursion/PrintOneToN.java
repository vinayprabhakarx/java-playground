package com.vinayprabhakarx.recursion;

// Task: Print numbers from 1 to N using recursion only.
import java.util.Scanner;

public class PrintOneToN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        printOneToN(num);
    }

    public static void printOneToN(int num) {
        // Base condition
        if (num == 0) {
            return;
        }

        // Recursive call
        printOneToN(num - 1);

        // Print during stack unwinding
        System.out.println(num);
    }
}
