package com.designpattern.creational.singleton;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientHackerOne {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        createMultipleInstanceUsingSerialization();
    }

    private static void createMultipleInstanceUsingSerialization() throws IOException, ClassNotFoundException {
        LazySingleton instance1 = LazySingleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("tmp.obj")));
        objectOutputStream.writeObject(instance1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("tmp.obj")));
        LazySingleton instance2 = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Object1 : " + instance1.hashCode());
        System.out.println("Object2 : " + instance2.hashCode());

        File file = new File ("tmp.obj");
        file.deleteOnExit();

        //To solve this implement readResolve in LazySingleton

    }
}
