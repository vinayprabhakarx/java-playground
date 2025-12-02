package com.vinayprabhakarx.basics.part1;

public class TypeCasting {

    /*
     * Type Casting in Java
     *
     * 1. Implicit Type Casting (Widening)
     * Occurs when a smaller data type is converted to a larger data type
     * automatically by the compiler.
     * Example: int to double
     *
     * 2. Explicit Type Casting (Narrowing)
     * Occurs when a larger data type is converted to a smaller data type.
     * This requires a cast operator.
     * Example: double to int
     *
     * Boolean => Cannot be cast to or from any numeric type
     *
     * Data type hierarchy (from smaller to larger):
     * byte -> short -> int -> long -> float -> double
     *
     * Note: char can be cast to int and back.
     */

    public static void main(String[] args) {

        // Implicit Type Casting (Widening)
        int intValue = 100;
        double doubleValue = intValue;
        // int is smaller than double, so widening happens automatically

        System.out.println("Implicit Type Casting:");
        System.out.println("Integer value: " + intValue);
        System.out.println("Converted to Double: " + doubleValue);

        // Explicit Type Casting (Narrowing)
        double anotherDoubleValue = 9.78;
        int anotherIntValue = (int) anotherDoubleValue;
        // double is larger than int; narrowing removes decimal part

        System.out.println("\nExplicit Type Casting:");
        System.out.println("Double value: " + anotherDoubleValue);
        System.out.println("Converted to Integer: " + anotherIntValue);

        // Char to Int and other conversions
        char charValue = 'A'; // ASCII value is 65
        int charToInt = charValue; // implicit: char to int (widening)
        char intToChar = (char) charToInt;
        // explicit: int back to char (narrowing to fit char range)

        System.out.println("\nChar to Int and vice versa:");
        System.out.println("Character value: " + charValue);
        System.out.println("Converted to Integer (ASCII): " + charToInt);
        System.out.println("Converted back to Character: " + intToChar);

        // Additional valid casts from char (examples)
        byte byteValue = (byte) charValue; // narrowing: may lose data if >127
        short shortValue = (short) charValue;
        long longValue = charValue; // widening
        float floatValue = charValue; // widening
        double doubleFromChar = charValue; // widening

        // Additional output if needed
        System.out.println("Byte value from char: " + byteValue);
        System.out.println("Short value from char: " + shortValue);
        System.out.println("Long value from char: " + longValue);
        System.out.println("Float value from char: " + floatValue);
        System.out.println("Double value from char: " + doubleFromChar);

        // Reverse conversions into char
        // char from byte, short, long, float, double (all require explicit casting)
        char charFromByte = (char) byteValue;
        char charFromShort = (char) shortValue;
        char charFromLong = (char) longValue;
        char charFromFloat = (char) floatValue;
        char charFromDouble = (char) doubleFromChar;

        System.out.println("Char from Byte: " + charFromByte);
        System.out.println("Char from Short: " + charFromShort);
        System.out.println("Char from Long: " + charFromLong);
        System.out.println("Char from Float: " + charFromFloat);
        System.out.println("Char from Double: " + charFromDouble);

    }
}
