package com.vinayprabhakarx.array;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElementSortedArray {

    public static void main(String[] args) {
        int[] arr = { 5, -11, -55, 1, 15, 0, 25 };
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        Scanner input = new Scanner(System.in);
        System.out.print("Enter element: ");
        int element = input.nextInt();
        input.close();

        int index = findInsertIndex(arr, element);

        int[] newArr = new int[arr.length + 1];

        // copy elements before index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // insert element
        newArr[index] = element;

        // shift remaining elements
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        System.out.println("Array After Insertion: " + Arrays.toString(newArr));
    }

    // Binary search to find insertion index
    static int findInsertIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // insert at same position
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low; // insertion point
    }
}
