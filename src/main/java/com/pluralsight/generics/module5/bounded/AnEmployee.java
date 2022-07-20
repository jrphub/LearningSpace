package com.pluralsight.generics.module5.bounded;

public class AnEmployee extends APerson {
    public AnEmployee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "AnEmployee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
