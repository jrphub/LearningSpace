package com.java8.pluralsight.java8.module2;

public class DPerson {
    private String name;
    private int age;

    public DPerson() {
    }

    public DPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DPerson{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
