package com.java8.EbuiltinFuncInterfaces;

public class Employee {
    String firstName;
    String lastName;

    Employee() {}

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
