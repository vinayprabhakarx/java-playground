package com.vinayprabhakarx.array;
import java.util.Scanner;
// Write a Java program to sum values of an array.
public class SumValueArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements in the array:");
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();

        int sum = 0;
        for (int j : arr) sum += j;
        System.out.println("The sum of the elements in the array is : " + sum);

    }
}

