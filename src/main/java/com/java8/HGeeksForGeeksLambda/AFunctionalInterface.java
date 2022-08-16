package com.java8.HGeeksForGeeksLambda;

public class AFunctionalInterface {
    public static void main(String[] args) {

        //before Java8, we had to create anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Started!");
            }
        }).start();

        //lambda expression
        new Thread(() -> System.out.println("Thread Started!")).start();
    }
}
