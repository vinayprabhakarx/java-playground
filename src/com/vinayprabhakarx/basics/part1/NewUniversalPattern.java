package com.vinayprabhakarx.basics.part1;

import java.util.Scanner;

public class NewUniversalPattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        input.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j == 0 && i > 0) ||
                        (i > 0 && j == n - 1) ||
                        (i == 0 && j > 0 && j < n - 1) ||
                        (i == (n - 1)/2)
                ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }

    }

}

// A, B, K, N
