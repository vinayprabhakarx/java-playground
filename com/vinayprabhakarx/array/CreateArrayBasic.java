package com.vinayprabhakarx.array;
import java.util.Scanner;

//Create an integer array of size N and initialize it with user input.
public class CreateArrayBasic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = input.nextInt();
        String[] arr = new String[n];
        System.out.print("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=input.next();
        }
        input.close();
        
        for (String i:arr){
            System.out.print(i + " ");
        }
    }
}
