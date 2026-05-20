package com.vinayprabhakarx.array;

import java.util.Scanner;

// Given an array of integers, move all zero elements to the end
// while preserving the order of non-zero elements.

public class MoveAllZeroesEnd {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        input.close();

        // Call method
        moveZeroes(arr);

        // Print result
        System.out.println("Array after moving zeroes to the end:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    // Method must be static because it is called from main
    static void moveZeroes(int[] arr) {
        int j = 0;

        // Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }

        // Fill remaining positions with zero
        for (int i = j; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
