package com.designpattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClientHackerTwo {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        createMultipleInstanceUsingReflection();
    }

    private static void createMultipleInstanceUsingReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] declaredConstructors = DLazySingleton.class.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);

        DLazySingleton instance1 = (DLazySingleton) constructor.newInstance();
        DLazySingleton instance2 = DLazySingleton.getInstance();

        System.out.println("Object1 : " + instance1.hashCode());
        System.out.println("Object2 : " + instance2.hashCode());

        //To solve this, use Enum
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        System.out.println("Object1 : " + singleton1.hashCode());
        System.out.println("Object2 : " + singleton2.hashCode());




    }
}
