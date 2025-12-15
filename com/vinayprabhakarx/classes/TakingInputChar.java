package com.vinayprabhakarx.classes;

import java.util.Scanner;

public class TakingInputChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first character: ");
        char ch1 = sc.next().charAt(0);

        System.out.print("Enter second character: ");
        char ch2 = sc.next().charAt(0);

        System.out.println("Character 1: " + ch1);
        System.out.println("Character 2: " + ch2);

        sc.close();
    }
}
