package com.ls.java8.lambda;

public class CreatePersons {

    public static void main(String[] args) {
        //Calling constructor using method reference
        IPersonFactory<Person> personFactory = Person::new; //one method in interface
        personFactory.create("Rohit", "Sharma");
        System.out.println("person created");
    }
}
