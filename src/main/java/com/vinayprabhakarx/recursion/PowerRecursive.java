package com.vinayprabhakarx.recursion;

import java.util.Scanner;

public class PowerRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();
        System.out.print("Now, enter power");
        int pow = scanner.nextInt();
        scanner.close();
        System.out.println(power(num, pow));
    }

    public static int power(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        return num * power(num, pow - 1);
    }

}
