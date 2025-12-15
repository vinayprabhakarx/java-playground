package com.vinayprabhakarx.methods;

public class SmallestNumber {
    public static void main(String[] args) {
        System.out.println("The smallest value is " + smallestNumber(25f, 37f, 29f));
    }

    static float smallestNumber(float firstNum, float secondNum, float thirdNum) {
        if (firstNum <= secondNum && firstNum <= thirdNum) {
            return firstNum;
        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
            return secondNum;
        } else
            return thirdNum;
    }

}
