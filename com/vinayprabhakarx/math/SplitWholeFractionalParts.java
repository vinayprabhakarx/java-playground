package com.vinayprabhakarx.math;
import java.util.Scanner;

public class SplitWholeFractionalParts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a fractional number: ");
        double number = input.nextDouble();
        input.close();
        double fraction_part = number % 1;
        int integral_part = (int) (number - fraction_part);
        System.out.println("Original number: " + number);
        System.out.println("Integral Part: " + integral_part);
        System.out.println("Fraction part: " + fraction_part);

    }
}
