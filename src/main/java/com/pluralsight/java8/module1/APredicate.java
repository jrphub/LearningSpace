package com.pluralsight.java8.module1;

import java.util.function.Predicate;

public class APredicate {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 10;

        Predicate<String> p3 = p1.and(p2);
        boolean checkLength = p3.test("I am learning Java8");
        System.out.println(checkLength);
        boolean checkLength2 = p3.test("Hello");
        System.out.println(checkLength2);
    }
}
