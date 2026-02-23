package com.vinayprabhakarx.array;
import  java.util.Scanner;
public class PrintGridOfDashes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int n = input.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }

    }
}
