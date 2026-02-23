package com.vinayprabhakarx.methods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PentagonalNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter starting point: ");
            int start = scanner.nextInt();

            System.out.print("Enter ending point: ");
            int end = scanner.nextInt();

            if (start <= 0 || end <= 0) {
                throw new IllegalArgumentException("Pentagonal numbers are defined only for positive integers.");
            }

            if (start > end) {
                throw new IllegalArgumentException("Starting point cannot be greater than ending point.");
            }

            printPentagonalNumbers(start, end);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integer values only.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static void printPentagonalNumbers(int start, int end) {
        for (int n = start; n <= end; n++) {
            long pentagonal = n * (3L * n - 1) / 2;
            System.out.println("P(" + n + ") = " + pentagonal);
        }
    }
}
