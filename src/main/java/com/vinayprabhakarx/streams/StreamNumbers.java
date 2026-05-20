package com.vinayprabhakarx.streams;

import java.util.Arrays;
import java.util.List;

public class StreamNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);

        // filter() selects even numbers.
        // map() squares each selected number.
        int sum = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .reduce(0, Integer::sum);

        System.out.println("Sum of squares of even numbers: " + sum);
    }
}
