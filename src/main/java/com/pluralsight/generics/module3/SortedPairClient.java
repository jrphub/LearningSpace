package com.pluralsight.generics.module3;

public class SortedPairClient {

    public static void main(String[] args) {
        SortedPair<Integer> sortedPair = new SortedPair<>(10, 20);
        System.out.println(sortedPair.getFirst());
        System.out.println(sortedPair.getSecond());

        SortedPair<Integer> sortedPair2 = new SortedPair<>(100, 50);
        System.out.println(sortedPair2.getFirst());
        System.out.println(sortedPair2.getSecond());

    }
}
