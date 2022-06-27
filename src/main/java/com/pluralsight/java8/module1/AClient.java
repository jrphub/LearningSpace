package com.pluralsight.java8.module1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class AClient {
    public static void main(String[] args) {
        File dir = new File("src/main/java/com/pluralsight/java8/module1");

        System.out.println("Using traditional interface>>>>");
        FileFilter javaFilter1 = new AJavaFileFilter();
        File[] files1 = dir.listFiles(javaFilter1);

        for (File file : files1) {
            System.out.println(file);
        }

        //2-Using anonymous class
        System.out.println("Using anonymous class>>>>");
        FileFilter javaFilter2 = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };
        File[] files2 = dir.listFiles(javaFilter2);

        for (File file : files2) {
            System.out.println(file);
        }

        //3 - Using Lambda Expression
        System.out.println("Using Lamda expression>>>>");
        //Lamda expression is another way to write anonymous class, more readable
        //Type of Lmbda expression : Functional Interface
        //Functional Interface : An interface with only one abstract method
        //Example :
        //Runnable has run()
        //Comparator has compareTo()
        //Lambda expression is without new operator,
        //FileFilter javaFilter3 = (File file) -> file.getName().endsWith(".java");
        //FileFilter javaFilter3 = (File file) -> file.getName().endsWith(".java");
        //FileFilter javaFilter3 = file -> file.getName().endsWith(".java");
        FileFilter javaFilter3 = f -> f.getName().endsWith(".java");


        File[] files3 = dir.listFiles(javaFilter3);
        for (File file : files3) {
            System.out.println(file);
        }

        //Method Reference
        List<File> files = Arrays.asList(files3);
        //files.forEach(file -> System.out.println(file));
        files.forEach(System.out::println);


    }
}
