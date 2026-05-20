package com.vinayprabhakarx.threads.runnable;

import java.util.InputMismatchException;
import java.util.Scanner;

class Demo implements Runnable {

    private final String taskType;

    public Demo(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public void run() {
        switch (taskType) {
            case "SUM":
                adding();
                break;
            case "CHAR":
                printCharacters();
                break;
            case "NUMBER":
                printNumbers();
                break;
            default:
                System.out.println("Unknown task");
        }
    }

    private void printCharacters() {
        System.out.println("Printing characters:");
        for (int i = 65; i <= 70; i++) {
            System.out.println((char) i);
            sleep();
        }
    }

    private void printNumbers() {
        System.out.println("Printing numbers:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            sleep();
        }
    }

    private void adding() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter num1: ");
            int num1 = sc.nextInt();

            System.out.print("Enter num2: ");
            int num2 = sc.nextInt();

            System.out.println("Sum is: " + (num1 + num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
        // DO NOT close System.in scanner
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Demo("SUM"));
        Thread t2 = new Thread(new Demo("CHAR"));
        Thread t3 = new Thread(new Demo("NUMBER"));

        t1.start();
        t2.start();
        t3.start();
    }
}
