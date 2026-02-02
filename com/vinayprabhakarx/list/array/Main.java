package com.vinayprabhakarx.list.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(80);

        // Print element by index
        System.out.println(list.get(2));
        System.out.println(list.size());


        // Print Element using loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("____________________________________________");

        //Enhanced for get element
        for(int x : list) {
            System.out.println(x);
        }

        System.out.println("---------------------------------------------");
        // printing whole list
        System.out.println("Arraylist: " + list);


        System.out.println("---------------------------------------------");

        // Check element is present in list
        System.out.println(list.contains(50));
        System.out.println(list.contains(80));

        System.out.println("---------------------------------------------");
        // Remove element
        list.remove(1);

        // add element in middle
        list.add(1, 50);

        for(int i : list) {
            System.out.println(i);
        }

        System.out.println("---------------------------------------------");
        // by default initial capacity is 10, we can set initial capacity
        ArrayList<Integer> list1 = new ArrayList<>(15);
        System.out.println("SIZE: " + list1.size());
        list1.add( 2);
        for (int i : list1) {
            System.out.println(i);
        }

        // Trim size of list
        list1.trimToSize();


        // on the fly list make
        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list2 = Arrays.asList(array); // asList is fixed size we can't add new element

    }
}
