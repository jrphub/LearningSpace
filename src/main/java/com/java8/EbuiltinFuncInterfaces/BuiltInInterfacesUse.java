package com.java8.EbuiltinFuncInterfaces;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//4 types : Predicate, Function, Supplier, Consumer
public class BuiltInInterfacesUse {

    public static void main(String[] args) {

        //Predicates - Predicates are boolean-valued functions of one argument
        Predicate<String> predicateImpl = (s) -> s.length() > 0;
        System.out.println(predicateImpl.test("hello world")); //true
        System.out.println(predicateImpl.negate().test("hello world")); //false
        System.out.println(predicateImpl.test("")); //false

        Predicate<String> isEmptyCheck = String::isEmpty;
        System.out.println(isEmptyCheck.test("")); //true
        //System.out.println(isEmptyCheck.test(null)); //NPE
        System.out.println(isEmptyCheck.negate().test("")); //false

        Predicate<Date> nonNullCheck = Objects::nonNull;
        Predicate<Date> isNullCheck = Objects::isNull;
        System.out.println("nonNullCheck " + nonNullCheck.test(new Date()));
        System.out.println("isNullCheck " + isNullCheck.test(null));

        //Functions - Functions accept one argument and produce a result.
        Function<String, Integer> strToInteger = Integer::valueOf;
        System.out.println(strToInteger.apply("10"));

        Function<String, String> backToString = strToInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("100"));

        //Suppliers - Suppliers produce a result of a given generic type.
        //Unlike Functions, Suppliers don't accept arguments.
        Supplier<Employee> employeeSupplier = Employee::new;
        System.out.println(employeeSupplier.get());
        System.out.println(employeeSupplier.get().firstName); //null

        //As method reference can't accept argument, we can use lambda expression
        //to call parameterized constructor
        Supplier<Employee> employeeSupplier1 = (() -> new Employee("Peter", "Parker"));
        System.out.println(employeeSupplier1.get());

        //Consumers - Consumers represent operations to be performed on a single input argument.
        Consumer<Employee> employeeConsumer = (p) -> System.out.println("hello " + p.firstName);
        employeeConsumer.accept(new Employee("Hrithik", "Roshan"));//hello Hrithik

        //Java8 adds various default methods to Comparator
        Comparator<Employee> employeeComparator = (e1, e2) -> e1.firstName.compareToIgnoreCase(e2.firstName);
        Employee emp1 = new Employee("Sachin", "Tendulkar");
        Employee emp2 = new Employee("Virat", "Kohli");

        System.out.println(employeeComparator.compare(emp1,emp2)); // negative
        System.out.println(employeeComparator.reversed().compare(emp1,emp2)); // positive


    }
}
