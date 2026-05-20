package com.vinayprabhakarx.array;

import java.util.Arrays;
import java.util.Scanner;

public class MultiClassInput {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of classes: ");
        int cla = input.nextInt();

        System.out.print("Enter number of students per class: ");
        int size = input.nextInt();

        int[][] marks = new int[cla][size];

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print("Enter marks of Student " + (j + 1)  + ", of class " + (i + 1)  + ": ");
                marks[i][j] = input.nextInt();
            }
        }

        // Print using deepToString
        System.out.println("\nAll Marks (2D Array):");
        System.out.println(Arrays.deepToString(marks));

        // Print class-wise
        System.out.println("\nClass-wise Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Class " + (i + 1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}
