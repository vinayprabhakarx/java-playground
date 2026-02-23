package com.vinayprabhakarx.array;


import java.util.Arrays;
import java.util.Scanner;

public class JaggedArrayString {
    public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of classes: ");
        int size = input.nextInt();
        String[][] name = new String[size][];

        for (int i = 0; i < name.length; i++) {
            System.out.print("Enter number of students in class " + (i + 1) + ": ");
            int students = input.nextInt();
            name[i] = new String[students];
            
            for (int j = 0; j < name[i].length; j++) {
                System.out.print("Enter name of Student " + (j + 1) + ", of class " + (i + 1) + ": ");
                name[i][j] = input.next();
            }
        }


        // Print class-wise
        System.out.println("\nClass-wise name:");
        for (int i = 0; i < name.length; i++) {
            System.out.print("Class " + (i + 1) + ": ");
            for (int j = 0; j < name[i].length; j++) {
                System.out.print(name[i][j] + " ");
            }
            System.out.println();
        }

        // Print using deepToString
        System.out.println("\nAll name (2D Array):");
        System.out.println(Arrays.deepToString(name));

        input.close();
    }
}

