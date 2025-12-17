package com.vinayprabhakarx.recursion;

// Task: Print numbers from N to 1 using recursion only.
import java.util.Scanner;

public class PrintNToOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();
        scanner.close();
        printNToOne(num);

    }

    public static void printNToOne(int num) {
        // base condition
        if (num == 0) {
            return;
        }

        // Printing the number
        System.out.println(num);

        // Recursive call
        printNToOne(num - 1);

    }
}
