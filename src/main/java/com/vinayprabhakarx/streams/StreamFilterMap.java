package com.vinayprabhakarx.streams;

import java.util.Arrays;
import java.util.List;

public class StreamFilterMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("vinay", "java", "stream", "api", "code");

        // filter() keeps only values that match the condition.
        // map() transforms each value into another form.
        List<String> result = names.stream()
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .toList();

        System.out.println("Names with length greater than 4 in uppercase:");
        result.forEach(System.out::println);
    }
}
