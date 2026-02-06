package com.vinayprabhakarx.array;

import java.util.Scanner;

public class InsertElementAtPosition {
    public static void main(String[] args) {
        int[] arr = { 11, 22, 33, 42, 55, 66 };

        Scanner input = new Scanner(System.in);
        System.out.print("Enter position you want replace element:");
        int position = input.nextInt();
        System.out.print("Enter element:");
        int element = input.nextInt();
        arr[position] = element;

        for (int i : arr) {
            System.out.print(i + " ");
        }

        input.close();
    }
}
