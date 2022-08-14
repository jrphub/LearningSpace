package com.ls.java8.lambda.Gstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamUsage {
    /*
    A java.util.Stream represents a sequence of elements on
    which one or more operations can be performed.
    Stream operations are either intermediate or terminal.
    While terminal operations return a result of a certain type,
    intermediate operations return the stream itself
    so you can chain multiple method calls in a row
     */

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //filter
        stringCollection.stream()
                .filter((s) -> s.startsWith("a")) //predicate
                .forEach(System.out::print); //aaa2 aaa1 //consumer

        //sorted
        stringCollection.stream()
                .sorted()
                .filter((s) -> s.startsWith("b"))
                .forEach(System.out::println); //bbb1 bbb2 bbb3

        //Note : stringCollection is untouched
        System.out.println(stringCollection); //[ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]

        //map
        stringCollection.stream()
                .map(String::toUpperCase)  //Function
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::print);//DDD2 DDD1 CCC BBB3 BBB2 BBB1 AAA2 AAA1


        //match - terminal operation, returns boolean
        boolean anyMatchA = stringCollection.stream()
                .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyMatchA); //true

        boolean allMatchA = stringCollection.stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(allMatchA); //false

        boolean noneMatchZ = stringCollection.stream()
                .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneMatchZ); //true

        //count - terminal operation , returns long
        long startsWithB = stringCollection.stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB); //3

        //reduce
        //This terminal operation performs a reduction
        // on the elements of the stream with the given function.
        // The result is an Optional holding the reduced value.

        Optional<String> reduced = stringCollection.stream()
                .sorted()
                .reduce((a,b) -> a + "#" + b);

        reduced.ifPresent(System.out::println); //aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2

    }

}
