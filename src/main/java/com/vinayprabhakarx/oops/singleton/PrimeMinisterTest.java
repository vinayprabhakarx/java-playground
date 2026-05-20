package com.vinayprabhakarx.oops.singleton;

public class PrimeMinisterTest {
    public static void main(String[] args) {
        PrimeMinister firstPrimeMinister = PrimeMinister.getInstance("Narendra Modi", 73);
        PrimeMinister secondPrimeMinister = PrimeMinister.getInstance("Yogi Adityanath", 50);

        System.out.println(firstPrimeMinister);
        System.out.println(secondPrimeMinister);
        System.out.println("Same object: " + (firstPrimeMinister == secondPrimeMinister));
    }
}
