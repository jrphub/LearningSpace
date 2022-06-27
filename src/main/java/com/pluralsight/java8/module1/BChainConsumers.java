package com.pluralsight.java8.module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BChainConsumers {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("one", "two", "three", "four");

        List<String> result = new ArrayList<>();

        //define consumer
        //Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c1 = System.out::println;

        //Consumer<String> c2 = s -> result.add(s);
        Consumer<String> c2 = result::add;

        strList.forEach(c1.andThen(c2));
        System.out.println("--------");
        result.forEach(c1);

    }
}
