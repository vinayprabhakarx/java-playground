package com.vinayprabhakarx.exceptions;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayExceptionHandle {

    public static void main(String[] args) {
        System.out.println("Connection established!");
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter Array Size: ");
            int size = input.nextInt();

            System.out.println("Array size must be positive.");
            int[] array = new int[size];

            System.out.print("Enter a Value: ");
            int value = input.nextInt();

            System.out.print("Enter index where you want to add: ");
            int index = input.nextInt();

            array[index] = value;

            System.out.println("Your array is: " + Arrays.toString(array));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. Please enter index within array size.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integer input.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Array size cannot be negative.");
        }
        finally {
            input.close();
            System.out.println("Connection closed!");
        }
    }
}