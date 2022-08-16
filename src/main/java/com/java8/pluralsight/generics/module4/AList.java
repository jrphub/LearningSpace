package com.java8.pluralsight.generics.module4;

import com.java8.pluralsight.generics.module2.APerson;
import com.java8.pluralsight.generics.module3.AgeComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AList {

    public static void main(String[] args) {
        APerson p1 = new APerson("Sambit", 29);
        APerson p2 = new APerson("Abhishek", 39);

        List<APerson> madMen = new ArrayList<>();
        madMen.add(p1);
        madMen.add(p2);
        madMen.add(new APerson("Durga", 35));

        final APerson youngestMadMen = minOf(madMen, new AgeComparator());

        System.out.println(youngestMadMen);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(7);
        numbers.add(15);

        System.out.println(minOf(numbers, Integer::compare));

    }

    private static <T> T minOf(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("madMen is empty");
        }

        T lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }

}
