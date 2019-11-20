package com.ls.java8.lambda;

public interface IPersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
