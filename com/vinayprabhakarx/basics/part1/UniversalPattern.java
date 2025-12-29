package com.vinayprabhakarx.basics.part1;

import java.util.Scanner;

public class UniversalPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        input.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 ||
                        j == 0 ||
                        i == n - 1 ||
                        j == n - 1 ||
                        i == ((n - 1) / 2) ||
                        j == ((n - 1) / 2) ||
                        i == j ||
                        i + j == (n - 1) ||
                        i + j == ((n - 1) / 2) ||
                        i - j == ((n - 1) / 2) ||
                        j - i == ((n - 1) / 2) ||
                        i + j == ((n - 1) + ((n - 1) / 2))) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }

    }

}
