package com.vinayprabhakarx.array;
import java.util.Scanner;
// Write a Java program to calculate the average value of array elements.
public class AverageOfArrayElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements in the array:");
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();

        double sum = 0;
        for (int i: arr) {
            sum += i;
        }
        System.out.println("The average of the elements in the array is: " + sum/arr.length);
    }
}
