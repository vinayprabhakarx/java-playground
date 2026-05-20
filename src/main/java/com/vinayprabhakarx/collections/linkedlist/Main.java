package com.vinayprabhakarx.collections.linkedlist;

import java.util.LinkedList;

// Demonstrates core LinkedList operations in Java
public class Main {
    public static void main(String[] args) {

        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Add elements
        list.add("Vinay");
        list.add("Prabhakar");
        list.add("Java");

        // Add at specific positions
        list.addFirst("First");
        list.addLast("Last");

        System.out.println("LinkedList: " + list);

        // Access elements
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element:  " + list.getLast());
        System.out.println("Index 2:       " + list.get(2));

        // Remove elements
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first & last: " + list);

        // Remove by value
        list.remove("Java");
        System.out.println("After removing 'Java': " + list);

        // Size and contains
        System.out.println("Size: " + list.size());
        System.out.println("Contains 'Vinay': " + list.contains("Vinay"));

        // Iterate
        System.out.println("\n--- Iteration ---");
        for (String s : list) {
            System.out.println(s);
        }

        // Use as Queue (FIFO): offer / poll / peek
        System.out.println("\n--- Queue operations ---");
        list.offer("Queue1");
        list.offer("Queue2");
        System.out.println("Peek: " + list.peek()); // see front, don't remove
        System.out.println("Poll: " + list.poll()); // remove front
        System.out.println("After poll: " + list);

        // Use as Stack (LIFO): push / pop
        System.out.println("\n--- Stack operations ---");
        list.push("Stack1");
        list.push("Stack2");
        System.out.println("Pop: " + list.pop());
        System.out.println("After pop: " + list);
    }
}
