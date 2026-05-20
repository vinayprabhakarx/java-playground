package com.vinayprabhakarx.array;
// Traverse an array using a for loop and print all elements.

public class ReadArrayElements {
    public static void main(String[] args) {
        int[] arr = {0,1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Traversing the Array: ");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
