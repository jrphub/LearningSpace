package com.java8.HGeeksForGeeksLambda;

import java.util.Optional;

public class IOptionalJava {

    public static void main(String[] args) {
        String[] arr = new String[3];
        Optional<String> checkNull = Optional.ofNullable(arr[1]);
        if (checkNull.isPresent()) {
            System.out.println(arr[1].toLowerCase());
        } else {
            System.out.println("String is null");
        }
    }
}
