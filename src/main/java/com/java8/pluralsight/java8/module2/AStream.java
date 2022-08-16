package com.java8.pluralsight.java8.module2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream is an object
 * - which doesn't hold any data
 * - on which one can define operation
 * - which should not change the data it processes
 * - which process data in one pass
 * Stream has many patterns
 *
 */
public class AStream {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("one", "two", "three");

        Stream<String> strStream = strList.stream();

        Consumer c1 = s -> System.out.println(s);

        Map<String, Integer> numMap= new HashMap<>();
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);

        // One more consumer
        Consumer<String> c2 = p -> {
            System.out.println(numMap.get(p));
        };



        //strStream.forEach(c1.andThen(c2)); // Stream will process each data with consumer1 and consumer2

        //Let's apply filter on stream
        Predicate<String> predicateEvenCheck = s -> numMap.get(s) % 2 == 0;
        //strStream.filter(predicateEvenCheck).forEach(c1.andThen(c2)); //prints only even data

        //peek returns stream, but foreach doesn't
        Predicate<String> predicateEqual = Predicate.isEqual("three");
        List<String> filteredList = new ArrayList<>();
        //strStream.peek(System.out::println).filter(predicateEqual).peek(filteredList::add); //does nothing
        strStream.peek(System.out::println).filter(predicateEqual).forEach(filteredList::add);
        System.out.println(filteredList.size());
    }
}
