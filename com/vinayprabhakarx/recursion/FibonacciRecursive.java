package com.vinayprabhakarx.recursion;

//Task: Return the Nth Fibonacci number.
import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a nth number:");
        int N = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(N));

    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }

}
