package com.vinayprabhakarx.recursion;
// Task: Return sum from 1 to N using recursion.

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();
        scanner.close();
        int result = sumOfNatural(num);
        System.out.println(" = " + result);
    }

    public static int sumOfNatural(int num) {
        // base logic
        if (num == 1) {
            System.out.print(1);
            return 1;
        }

        System.out.print(num + " + ");

        return num + sumOfNatural(num - 1);

    }

}
