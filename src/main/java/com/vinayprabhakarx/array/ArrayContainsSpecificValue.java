package com.vinayprabhakarx.array;

import java.util.Arrays;
import java.util.Scanner;

import static com.vinayprabhakarx.array.IterativeBinarySearch.contains;

public class ArrayContainsSpecificValue {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Invalid array size. Size must be greater than zero.");
            input.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integer elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter target element to search: ");
        int target = input.nextInt();

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        boolean result = contains(sortedArr, target);

        System.out.println("\nOriginal Array : " + Arrays.toString(arr));
        System.out.println("Sorted Array   : " + Arrays.toString(sortedArr));
        System.out.println("Target Element : " + target);
        System.out.println("Result         : " + (result ? "Found" : "Not Found"));

        input.close();
    }
}
