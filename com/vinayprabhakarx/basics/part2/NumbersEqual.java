package com.vinayprabhakarx.basics.part2;

import java.util.Scanner;

public class NumbersEqual {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter First Number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter Second Number: ");
            int num2 = scanner.nextInt();

            System.out.print("Enter Thrid Number: ");
            int num3 = scanner.nextInt();

            System.out.print("Enter Forth Number: ");
            int num4 = scanner.nextInt();

            if (num1 == num2 && num2 == num3 && num3 == num4) {
                System.out.println("Numbers are equal");
            } else {
                System.out.println("Numbers are not equal");
            }
        }

    }

}
