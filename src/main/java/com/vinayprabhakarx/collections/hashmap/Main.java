package com.vinayprabhakarx.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

// Demonstrates core HashMap operations in Java
public class Main {
    public static void main(String[] args) {

        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Put key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 25);
        map.put("Cherry", 15);

        // Access a value by key
        System.out.println("Apple count: " + map.get("Apple"));

        // Check if a key or value exists
        System.out.println("Contains 'Banana': " + map.containsKey("Banana"));
        System.out.println("Contains value 15: " + map.containsValue(15));

        // Update a value
        map.put("Apple", 20);
        System.out.println("Updated Apple count: " + map.get("Apple"));

        // Remove a key
        map.remove("Cherry");
        System.out.println("After removal: " + map);

        // Iterate over entries
        System.out.println("\n--- All Entries ---");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Size of map
        System.out.println("\nMap size: " + map.size());

        // getOrDefault
        System.out.println("Mango count: " + map.getOrDefault("Mango", 0));

        // putIfAbsent
        map.putIfAbsent("Banana", 999); // will NOT update since key exists
        map.putIfAbsent("Mango", 5); // will INSERT since key is absent
        System.out.println("After putIfAbsent: " + map);
    }
}
