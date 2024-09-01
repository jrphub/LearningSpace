package com.designpattern.creational.singleton;

public class Client {
    public static void main(String[] args) {
        //Check instance can't be created using new operator
        //LazyInitialization instance = new LazyInitialization();

        //Create two instances of the class and check both instance has same hashcode
        DLazySingleton instance1 = DLazySingleton.getInstance();
        System.out.println(instance1.hashCode());

        DLazySingleton instance2 = DLazySingleton.getInstance();
        System.out.println(instance2.hashCode());

        Thread thread1 = new Thread(() -> {
            DLazySingleton instance3 = DLazySingleton.getInstance();
            System.out.println(instance3.hashCode());
        });
        Thread thread2 = new Thread(() -> {
            DLazySingleton instance4 = DLazySingleton.getInstance();
            System.out.println(instance4.hashCode());
        });
        thread1.start();
        thread2.start();

    }
}
