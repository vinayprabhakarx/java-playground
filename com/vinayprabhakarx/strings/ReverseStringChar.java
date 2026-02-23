package com.vinayprabhakarx.strings;
import java.util.Scanner;

public class ReverseStringChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence:");
        String str = input.nextLine();
        input.close();

        String[] arr = str.split(" ");
        String[] revArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            StringBuilder rev = new StringBuilder();
            for (int j = s.length() - 1; j >= 0; j--) {
                rev.append(s.charAt(j));
            }
            revArr[i] = rev.toString();
        }
        String result = String.join(" " , revArr);
        System.out.println("Reversed: " + result);
    }
}
