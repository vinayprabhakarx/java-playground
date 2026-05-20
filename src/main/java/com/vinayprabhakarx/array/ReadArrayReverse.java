package com.vinayprabhakarx.array;
import java.util.Scanner;

//Print array elements in reverse order
public class ReadArrayReverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of courses: ");
        String[] numArray = new String[input.nextInt()];
        System.out.print("Enter the courses: ");
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = input.next();
        }

        // Printing array in reverse order
        for (int i = numArray.length - 1; i >= 0; i--) {
            System.out.print(numArray[i] + " ");
        }

    }
}
