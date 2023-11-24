package com.designpattern.creational.singleton;

public class Client {
    public static void main(String[] args) {
        //Check instance can't be created using new operator
        //LazyInitialization instance = new LazyInitialization();

        //Create two instances of the class and check both instance has same hashcode
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance1.hashCode());

        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance2.hashCode());

        Thread thread1 = new Thread(() -> {
            LazySingleton instance3 = LazySingleton.getInstance();
            System.out.println(instance3.hashCode());
        });
        Thread thread2 = new Thread(() -> {
            LazySingleton instance4 = LazySingleton.getInstance();
            System.out.println(instance4.hashCode());
        });
        thread1.start();
        thread2.start();

    }
}
