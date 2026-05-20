package com.vinayprabhakarx.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSources {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango");
        int[] marks = {85, 90, 95};

        // stream() creates a stream from a collection.
        System.out.println("Stream from List:");
        fruits.stream().forEach(System.out::println);

        // Arrays.stream() creates a stream from an array.
        System.out.println("Stream from Array:");
        Arrays.stream(marks).forEach(System.out::println);

        // Stream.of() creates a stream from given values.
        System.out.println("Stream from Values:");
        Stream.of("Java", "Python", "Go").forEach(System.out::println);
    }
}
