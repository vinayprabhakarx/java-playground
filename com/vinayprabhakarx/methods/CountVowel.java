package com.vinayprabhakarx.methods;

import java.util.Scanner;

// Write a Java method to count all vowels in a string. 
public class CountVowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string:");
        String str = scanner.nextLine();
        System.out.println("Number of Vowels in the string: " + vowelCount(str));

        scanner.close();
    }

    static int vowelCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o') {
                count++;
            }
        }
        return count;

    }

}
