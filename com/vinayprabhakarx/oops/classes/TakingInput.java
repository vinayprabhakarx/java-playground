package com.vinayprabhakarx.oops.encapsulation.classes;

import java.util.Scanner;

public class TakingInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Byte Type Value: ");
        byte byteVal = sc.nextByte();

        System.out.print("Enter Int Value: ");
        int intVal = sc.nextInt();

        System.out.print("Enter Float Value: ");
        float floatVal = sc.nextFloat();

        System.out.print("Enter Double Value: ");
        double doubleVal = sc.nextDouble();

        System.out.print("Enter Boolean Value: ");
        boolean boolVal = sc.nextBoolean();

        sc.nextLine(); // Clear leftover newline

        System.out.print("Enter String Value: ");
        String strVal = sc.nextLine(); // Read full line

        System.out.println("Byte Value: " + byteVal);
        System.out.println("Int Value: " + intVal);
        System.out.println("Float Value: " + floatVal);
        System.out.println("Double Value: " + doubleVal);
        System.out.println("Boolean Value: " + boolVal);
        System.out.println("String Value: " + strVal);

        sc.close();
    }
}
