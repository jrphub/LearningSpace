package com.java8.pluralsight.generics.module5.bounded;

public class APerson {
    private String name;
    private int age;

    public APerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public APerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "APerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
