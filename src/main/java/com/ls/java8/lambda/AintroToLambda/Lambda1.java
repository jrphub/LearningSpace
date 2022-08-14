package com.ls.java8.lambda.AintroToLambda;

import java.util.*;

public class Lambda1 {

    public static void main(String[] args) {
        List<String> empList = Arrays.asList("Zubin", "Payal", "Ravi", "Deepak");

        //1st
        empList.sort(new Comparator<String>() {
            @Override
            public int compare(String emp1, String emp2) {
                return emp1.compareToIgnoreCase(emp2);
            }
        });
        System.out.println("1 - " + empList);

        //2nd -In Java8, String class has compareToIgnoreCase and compareTo methods in built
        empList.sort((String emp1, String emp2) -> {
            return emp1.compareToIgnoreCase(emp2);
        });

        System.out.println("2 - " + empList);

        //3rd
        empList.sort((emp1, emp2) -> emp1.compareToIgnoreCase(emp2));
        System.out.println("3 - " + empList );

        //4th - List interface has sort method itself in Java 8
        empList.sort((emp1,emp2) -> emp1.compareToIgnoreCase(emp2));
        System.out.println("4 - " + empList);

        //5th - Method reference
        empList.sort(String::compareToIgnoreCase);
        System.out.println("5 - " + empList);

    }
}
