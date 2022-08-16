package com.java8.pluralsight.java8.module2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class BStreamMap {
    //Let's learn Mapping operation
    //It uses Function<T,R>

    //FlatMap
    //It uses Function<T, Stream<R>>

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(6,7,8);
        List<Integer> list3 = Arrays.asList(9,10);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        System.out.println(list);

        /*list.stream()
                .map(l -> l.size())
                .forEach(System.out::println); //prints size of each list members
        */

        Function<List<?>, Integer> sizeFunc = List::size;
        list.stream()
                .map(sizeFunc)
                .forEach(System.out::println);

        //Flat map
        Function<List<Integer>, Stream<Integer>> flatMapper = Collection::stream;//l -> l.stream()

        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::print);
    }
}
