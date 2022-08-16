package com.java8.BlambdaAndMethodRef;

@FunctionalInterface
public interface IConverter<F, T> {

    T convert(F from);
}