package com.vinayprabhakarx.basics.part1;

import java.util.Scanner;

public class EligibleToVote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter you Nationality: ");
        String nation = scanner.nextLine().toLowerCase();
        switch (nation) {
            case "indian":
                System.out.print("Enter you age:");
                int age = scanner.nextInt();
                scanner.close();
                if (age >= 18) {
                    System.out.println("Your are eligible to vote.");
                } else {
                    System.out.println("You are not eligible to vote.");
                }
                break;

            default:
                System.out.println("You are not an Indian Citizen.");
                break;

        }

    }

}
