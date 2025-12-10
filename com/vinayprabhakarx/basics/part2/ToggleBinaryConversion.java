package com.vinayprabhakarx.basics.part2;

public class ToggleBinaryConversion {

    public static void main(String[] args) {
        decimalToBinary(5);
    }

    public static void decimalToBinary(int num) {
        String bin = "";

        if (num == 0) {
            bin = "0";
        } else {
            while (num > 0) {
                int mod = num % 2;
                bin = mod + bin;
                num = num / 2;
            }
        }

        System.out.println("Binary: " + bin);

        String toggled = toggleBinary(bin);
        System.out.println("Toggled Binary: " + toggled);

        int decimal = binaryToDecimal(toggled);
        System.out.println("Toggled Decimal: " + decimal);
    }

    // Flip each bit: 0 -> 1, 1 -> 0
    public static String toggleBinary(String bin) {
        StringBuilder toggled = new StringBuilder();

        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            toggled.append(c == '0' ? '1' : '0');
        }

        return toggled.toString();
    }

    // Convert binary string to decimal
    public static int binaryToDecimal(String bin) {
        int result = 0;
        int base = 1;

        for (int i = bin.length() - 1; i >= 0; i--) {
            int digit = bin.charAt(i) - '0';
            result += digit * base;
            base *= 2;
        }

        return result;
    }
}

// Efficent Way

/*
 * public class ToggleBinaryConversion {
 * 
 * public static void main(String[] args) {
 * int num = 5;
 * int toggled = toggleBits(num);
 * System.out.println("Original: " + num);
 * System.out.println("Toggled: " + toggled);
 * }
 * 
 * public static int toggleBits(int n) {
 * if (n == 0) return 1;
 * 
 * int bits = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1;
 * int mask = (1 << bits) - 1;
 * 
 * return n ^ mask;
 * }
 * }
 */