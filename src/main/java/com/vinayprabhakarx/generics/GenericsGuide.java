package com.vinayprabhakarx.generics;

import java.util.List;

public class GenericsGuide {
    public static void main(String[] args) {
        // Box<T> can store any single type safely. Here T becomes String.
        Box<String> nameBox = new Box<>("Vinay");

        // Here the same Box<T> class is reused, but T becomes Integer.
        Box<Integer> marksBox = new Box<>(97);

        System.out.println("Name: " + nameBox.getValue());
        System.out.println("Marks: " + marksBox.getValue());

        // The compiler detects T automatically from the value passed to the method.
        printItem("Java");
        printItem(100);
        printItem(98.5);

        // getFirst() returns the same type as the array element type.
        Integer[] numbers = {10, 20, 30, 40};
        System.out.println("First number: " + getFirst(numbers));

        List<Integer> integerMarks = List.of(80, 90, 95);
        List<Double> percentageMarks = List.of(82.5, 91.0, 96.5);

        // List<? extends Number> accepts Integer, Double, Float, Long, and other Number lists.
        printNumbers(integerMarks);
        printNumbers(percentageMarks);
    }

    // Generic method: T is decided separately every time this method is called.
    private static <T> void printItem(T item) {
        System.out.println("Generic method value: " + item);
    }

    // Generic return type: returns the exact same type that the caller passes in the array.
    private static <T> T getFirst(T[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }

        return values[0];
    }

    // Upper bounded wildcard: accepts lists whose element type is Number or a subclass of Number.
    private static void printNumbers(List<? extends Number> numbers) {
        System.out.println("Number list:");

        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    // Generic class: T is a placeholder for the value type stored in the box.
    private static class Box<T> {
        private final T value;

        private Box(T value) {
            this.value = value;
        }

        private T getValue() {
            return value;
        }
    }
}
