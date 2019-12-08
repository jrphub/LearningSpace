package com.ls.java8.lambda.AintroToLambda;

import java.util.*;

public class Lambda1 {

    public static void main(String[] args) {
        List<String> empList = Arrays.asList("Zubin", "Payal", "Ravi", "Deepak");

        //1st
        Collections.sort(empList, new Comparator<String>() {
            @Override
            public int compare(String emp1, String emp2) {
                return emp1.compareToIgnoreCase(emp2);
            }
        });
        System.out.println("1 - " + empList);

        //2nd
        Collections.sort(empList, (String emp1, String emp2) -> {
            return emp1.compareToIgnoreCase(emp2);
        });

        System.out.println("2 - " + empList);

        //3rd
        Collections.sort(empList, (emp1, emp2) -> emp1.compareToIgnoreCase(emp2));
        System.out.println("3 - " + empList );

        //4th
        empList.sort((emp1,emp2) -> emp1.compareToIgnoreCase(emp2));
        System.out.println("4 - " + empList);


    }
}
