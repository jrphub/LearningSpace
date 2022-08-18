package com.java8.HGeeksForGeeksLambda;

import java.io.Serializable;

public class GLambdaSerialization {

    interface SerializableRunnable extends Runnable, Serializable {
    }

    public static Object getLambdaObject() {
        //Runnable r = (Serializable & Runnable )() -> System.out.println("Serialize the message");
        SerializableRunnable r = () -> System.out.println("Serialize the message");
        return r;
    }

    public static void main(String[] args) {
        System.out.println(GLambdaSerialization.getLambdaObject());
    }
}
