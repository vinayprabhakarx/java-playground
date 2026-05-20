package com.vinayprabhakarx.array;

import java.util.Arrays;
import java.util.Scanner;

public class NameInput {
    static void main() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a size of Array:");
        int size = input.nextInt();

        String[] name = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name student " + (i + 1) + ":");
            name[i] = input.next();
        }

        System.out.println(Arrays.toString(name)); // Using string method printing array


        System.out.println("--------------------------------");
        for (String i : name) {
            System.out.print(i + " ");
        }
    }
}
