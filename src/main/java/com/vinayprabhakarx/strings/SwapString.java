package com.vinayprabhakarx.strings;

import java.util.Scanner;

public class SwapString {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Enter a sentence:");
       String str = input.nextLine();
       input.close();
       String[] arr = str.split(" ");
       String[] revArr = new String[arr.length];
       int j = 0;
       for (int i = arr.length - 1; i >= 0; i--){
           revArr[j] = arr[i];
           j++;
       }
       String result = String.join(" ", revArr);
       System.out.println("Reversed: " + result);
    }
}
