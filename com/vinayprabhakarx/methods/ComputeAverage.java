package com.vinayprabhakarx.methods;

import java.util.Scanner;

// Compute Average of Three Numbers

public class ComputeAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first Val:");
        int firstNum = scanner.nextInt();
        System.out.print("Enter second Val:");
        int secondNum = scanner.nextInt();
        System.out.print("Enter third Val:");
        int thirdNum = scanner.nextInt();
        System.out.println("The average value is " + computeAverage(firstNum, secondNum, thirdNum));
        scanner.close();
    }

    static float computeAverage(int firstNum, int secondVal, int thirdVal) {
        float avgVal = (firstNum + secondVal + thirdVal) / 3;
        return avgVal;
    }
}
