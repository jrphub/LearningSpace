package com.ls.java8.lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInInterfacesUse {

    public static void main(String[] args) {

        //Predicates - Predicates are boolean-valued functions of one argument
        Predicate<String> predicateImpl = (s) -> s.length() > 0;
        System.out.println(predicateImpl.test("hello world")); //true
        System.out.println(predicateImpl.negate().test("hello world")); //false
        System.out.println(predicateImpl.test("")); //false

        Predicate<String> isEmptyCheck = String::isEmpty;
        System.out.println(isEmptyCheck.test("")); //true
        //System.out.println(isEmptyCheck.test(null)); //NPE
        System.out.println(isEmptyCheck.negate().test("")); //false

        Predicate<Boolean> nonNullCheck = Objects::nonNull;
        Predicate<Boolean> isNullCheck = Objects::isNull;

        //Functions - Functions accept one argument and produce a result.
        Function<String, Integer> strToInteger = Integer::valueOf;
        System.out.println(strToInteger.apply("10"));

        Function<String, String> backToString = strToInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("100"));

        //Suppliers - Suppliers produce a result of a given generic type.
        //Unlike Functions, Suppliers don't accept arguments.
        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());
        System.out.println(personSupplier.get().firstName); //null

        //Consumers - Consumers represent operations to be performed on a single input argument.
        Consumer<Person> personConsumer = (p) -> System.out.println("hello " + p.firstName);
        personConsumer.accept(new Person("Hrithik", "Roshan"));//hello Hrithik


    }
}
