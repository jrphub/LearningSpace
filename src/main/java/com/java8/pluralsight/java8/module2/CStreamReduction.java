package com.java8.pluralsight.java8.module2;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class CStreamReduction {

    public static void main(String[] args) {
        Stream<Integer> streamInt = Stream.of(1,2,3,4);

        //BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
        BinaryOperator<Integer> sum = Integer::sum;

        BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;

        BinaryOperator<Integer> min = (i1, i2) -> i1 < i2 ? i1 : i2;


        System.out.println(streamInt.reduce(sum).get());
        //System.out.println(streamInt.reduce(max).get());
        //System.out.println(streamInt.reduce(min).get());
        //System.out.println(streamInt.min(Comparator.naturalOrder()).get());

    }
}
