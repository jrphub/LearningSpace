package com.ls.java8.lambda;

public class UseMyFunctionalInterface {

    public static int instanceMethod(int a) {
        System.out.println("instanceMethod() is called ");
        return a * 5;
    }

    public static void main(String[] args) {
        //implementation 1
        MyFunctionalInterface impl1 = (num) -> num+5;
        System.out.println(impl1.function(20));

        //implementation 2
        MyFunctionalInterface impl2 = (num) -> num * 5;
        System.out.println(impl2.function(20));

    }

}
