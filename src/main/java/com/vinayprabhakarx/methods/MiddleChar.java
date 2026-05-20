package com.vinayprabhakarx.methods;

import java.util.Scanner;

public class MiddleChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a String: ");
        String input = scanner.next();
        scanner.close();
        System.out.println("The middle character in the string: " + middleChar(input));

    }

    static char middleChar(String str) {
        int num = ((str.length() / 2));
        char middleVal = str.charAt(num);

        return middleVal;
    }

}
