package com.vinayprabhakarx.collections.vector;

import java.util.Vector;

// Demonstrates core Vector operations in Java
// Vector is a synchronized, thread-safe dynamic array (legacy, prefer ArrayList for single-threaded use)
public class Main {
    public static void main(String[] args) {

        // Create a Vector (default initial capacity: 10, doubles when full)
        Vector<String> vector = new Vector<>();

        // Add elements
        vector.add("Alpha");
        vector.add("Beta");
        vector.add("Gamma");
        vector.add("Delta");

        System.out.println("Vector: " + vector);

        // Access elements
        System.out.println("Element at index 1: " + vector.get(1));
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element:  " + vector.lastElement());

        // Size and capacity
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        // Check contains
        System.out.println("Contains 'Beta': " + vector.contains("Beta"));

        // Add at specific index
        vector.add(1, "Inserted");
        System.out.println("After insert at index 1: " + vector);

        // Remove by index and by value
        vector.remove(0);
        vector.remove("Delta");
        System.out.println("After removals: " + vector);

        // Iterate
        System.out.println("\n--- Iteration ---");
        for (String s : vector) {
            System.out.println(s);
        }

        // Set (update) element
        vector.set(0, "Updated");
        System.out.println("\nAfter set(0, 'Updated'): " + vector);

        // Clear
        vector.clear();
        System.out.println("After clear, isEmpty: " + vector.isEmpty());
    }
}
