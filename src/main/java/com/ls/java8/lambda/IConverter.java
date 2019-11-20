package com.ls.java8.lambda;

@FunctionalInterface
public interface IConverter<F, T> {

    T convert(F from);
}
