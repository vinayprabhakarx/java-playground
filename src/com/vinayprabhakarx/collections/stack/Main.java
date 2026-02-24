package com.vinayprabhakarx.collections.stack;

import java.util.Stack;

// Demonstrates core Stack operations in Java (LIFO - Last In First Out)
public class Main {
    public static void main(String[] args) {

        // Create a Stack
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack: " + stack);

        // Peek — view top without removing
        System.out.println("Top (peek): " + stack.peek());

        // Pop — remove and return top element
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if empty
        System.out.println("Is empty: " + stack.isEmpty());

        // Search — returns 1-based position from top, -1 if not found
        System.out.println("Search 20 (from top): " + stack.search(20));
        System.out.println("Search 99 (from top): " + stack.search(99));

        // Contains
        System.out.println("Contains 30: " + stack.contains(30));

        // Size
        System.out.println("Size: " + stack.size());

        // Iterate (bottom to top)
        System.out.println("\n--- Stack elements (bottom to top) ---");
        for (int val : stack) {
            System.out.println(val);
        }

        // Pop all
        System.out.println("\n--- Popping all elements ---");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
        System.out.println("Stack after clearing: " + stack);
    }
}
