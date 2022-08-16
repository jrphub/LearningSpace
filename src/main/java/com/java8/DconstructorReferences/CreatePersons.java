package com.java8.DconstructorReferences;

public class CreatePersons {

    public static void main(String[] args) {
        //Calling constructor using method reference
        IPersonFactory<Person> personFactory = Person::new; //one method in interface
        Person p = personFactory.create("Rohit", "Sharma");
        System.out.println("person created : " + p);
    }
}
