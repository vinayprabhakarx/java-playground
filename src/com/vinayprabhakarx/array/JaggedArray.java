package com.vinayprabhakarx.array;

import java.util.Arrays;
import java.util.Scanner;

public class JaggedArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Hard Input in jagged array
        /*
        String[][] name = new String[3][];
        name[0] = new String[3];
        name[1] = new String[4];
        name[2] = new String[1];
         */

        System.out.print("Enter number of classes: ");
        int size = input.nextInt();

        int[][] marks = new int[size][];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter number of students in class " + (i + 1) + ": ");
            int students = input.nextInt();
            marks[i] = new int[students];

            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("Enter marks of Student " + (j + 1) + ", of class " + (i + 1) + ": ");
                marks[i][j] = input.nextInt();
            }
        }

        // Print class-wise
        System.out.println("\nClass-wise Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Class " + (i + 1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }

        // Print using deepToString
        System.out.println("\nAll Marks (2D Array):");
        System.out.println(Arrays.deepToString(marks));

        input.close();
    }
}
