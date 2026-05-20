package com.vinayprabhakarx.exceptions.general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionExceptionHandle {
    static void main(String[] args) {
        System.out.println("Program Started!");
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the Numerator:");
            double numerator = input.nextDouble();
            System.out.print("Enter Denominator:");
            double denominator = input.nextDouble();

            double result = numerator / denominator;
            System.out.println("The result of the Division is: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer");
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Division by zero is not possible");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            input.close();
            System.out.println("Program terminated!");
        }
    }
}
