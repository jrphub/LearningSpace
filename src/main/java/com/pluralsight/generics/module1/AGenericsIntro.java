package com.pluralsight.generics.module1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.pluralsight.com/library/courses/java-generics/table-of-contents
 *
 * Collections can contain any Object
 *
 * Generics stop run time errors at compile time
 */
public class AGenericsIntro {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("hi");
        list.add("hello");
        list.add(1); //Here is the problem

        list.forEach(System.out::println); //works fine

        for (int i=0; i<list.size(); i++) {
            String s = (String) list.get(i); // ClassCastException: java.lang.Integer cannot be cast to java.lang.String
            System.out.println(s);
        }
    }
}
