package com.vinayprabhakarx.functional;

import java.util.Arrays;
import java.util.List;

public class ListForEachLambda {

    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // forEach using lambda expression
        numbers.forEach(n -> System.out.println(n));

        // forEach using lambda with block body
        numbers.forEach(n -> {
            System.out.println("Value: " + n);
        });

        // forEach using method reference (lambda shorthand)
        numbers.forEach(System.out::println);

        // forEach with conditional logic inside lambda
        numbers.forEach(n -> {
            if (n % 20 == 0) {
                System.out.println("Multiple of 20: " + n);
            }
        });

        // Create a list of strings
        List<String> names = Arrays.asList("Vinay", "Prabhakar", "Java", "Lambda");

        // forEach lambda printing string length
        names.forEach(name ->
                System.out.println(name + " length = " + name.length())
        );
    }
}
