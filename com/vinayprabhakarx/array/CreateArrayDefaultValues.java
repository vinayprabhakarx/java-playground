package com.vinayprabhakarx.array;

import java.util.Arrays;

// Create arrays of different data types and print their default values.
public class CreateArrayDefaultValues {
    public static void main(String[] args) {
        int [] intArr = new int [2];
        float [] floatArr = new float [2];
        double [] doubleArr = new double [2];
        char [] charArr = new char [2];
        byte [] byteArr = new byte [2];
        short [] shortArr = new short [2];
        long [] longArr = new long [2];
        boolean [] booleanArr = new boolean [2];
        String [] strArr = new String[2];

        // Printing ever array of default value
        System.out.println("Integer Type Array of Default Values: " + Arrays.toString(intArr));
        System.out.println("Float Array of Default Values" + Arrays.toString(floatArr));
        System.out.println("Double Array of Default Values" + Arrays.toString(doubleArr));
        System.out.println("Char Array of Default Values" + Arrays.toString(charArr));
        System.out.println("Byte Array of Default Values" + Arrays.toString(byteArr));
        System.out.println("Short Array of Default Values" + Arrays.toString(shortArr));
        System.out.println("Long Array of Default Values" + Arrays.toString(longArr));
        System.out.println("Boolean Array of Default Values" + Arrays.toString(booleanArr));
        System.out.println("String Array of Default Values" + Arrays.toString(strArr));


    }
}
