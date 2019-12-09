package com.ls.java8.lambda.BlambdaAndMethodRef;

@FunctionalInterface
public interface IConverter<F, T> {

    T convert(F from);
}