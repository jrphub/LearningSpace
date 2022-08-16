package com.java8.DconstructorReferences;

public interface IPersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
