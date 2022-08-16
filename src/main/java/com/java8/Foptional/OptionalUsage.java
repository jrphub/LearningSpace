package com.java8.Foptional;

import java.util.Optional;

public class OptionalUsage {
    //Optional is a utility to prevent NPE
    //It's a simple container for a value which may be null or not null
    //instead of returning null, a method can return an Optional in Java8
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Foo");

        System.out.println(optional.get()); //Foo
        System.out.println(optional.isPresent()); //true
        System.out.println(optional.orElse("Bar")); //Foo

        optional.ifPresent((s) -> System.out.println(s.charAt(0))); //F
    }
}
