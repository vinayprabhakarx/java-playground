package com.vinayprabhakarx.exceptions.general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionResourceHandling {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // OR USE THIS, called
        // try (Scanner sc = new Scanner(System.in) {
        try (sc) {

            System.out.print("Enter Numerator value: ");
            int a = sc.nextInt();
            System.out.print("Enter  Denominator value: ");
            int b = sc.nextInt();
            System.out.println(a + " / " + b + " = " + (a / b));

            System.out.print("Enter the array size:");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Enter the elements in the array:");
            int element = sc.nextInt();
            System.out.print("Enter the index of the element in the array:");
            int index = sc.nextInt();
            arr[index] = element;
            System.out.println(arr[index]);

        } catch (InputMismatchException |
                 ArithmeticException |
                 NegativeArraySizeException |
                 ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
