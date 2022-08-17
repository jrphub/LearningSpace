package com.java8.HGeeksForGeeksLambda;

public class DThreadLambda {
    public static void main(String[] args) {
        // Creating Lambda expression for run() method in
        // functional interface "Runnable"
        Runnable runnable = () -> {
            Thread.currentThread().setName("Test Thread");
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        // Instantiating Thread class by passing Runnable
        // reference to Thread constructor
        Thread thread = new Thread(runnable);

        //Starting the thread
        thread.start();
    }
}
