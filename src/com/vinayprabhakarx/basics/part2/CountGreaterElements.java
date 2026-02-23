package com.vinayprabhakarx.basics.part2;

import java.util.Scanner;

public class CountGreaterElements {

    // Problem: Given an array and a key, count how many elements are strictly
    // greater than the key.
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int key = readInt("Enter a value: ");
        int n = readInt("Now enter size of array: ");

        int[] arr = readIntArray(n);

        int result = countGreaterElements(key, arr);
        System.out.println("Count of elements greater than " + key + " is: " + result);

        sc.close();
    }

    // Method to read an integer
    private static int readInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    // Method to read an array of integers
    private static int[] readIntArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter value number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    // Business logic method
    public static int countGreaterElements(int key, int[] arr) {
        int count = 0;

        for (int value : arr) {
            if (value > key) {
                count++;
            }
        }

        return count;
    }
}
