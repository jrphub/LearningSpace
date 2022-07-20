package com.pluralsight.generics.module5.bounded;

public class APartner extends APerson {

    public APartner(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "APartner{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
