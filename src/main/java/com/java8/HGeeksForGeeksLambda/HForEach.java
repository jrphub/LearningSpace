package com.java8.HGeeksForGeeksLambda;

import java.util.Arrays;
import java.util.List;

public class HForEach {

    public static void main(String[] args) {
        List<String> vegList = Arrays.asList(
                "potato",
                "carrot",
                "cauliflower",
                "tomato"
        );
        System.out.println("===========Vegetables==========");
        //vegList.forEach(s -> System.out.println(s));
        vegList.forEach(System.out::println);
    }
}
