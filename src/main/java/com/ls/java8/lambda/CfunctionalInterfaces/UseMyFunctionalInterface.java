package com.ls.java8.lambda.CfunctionalInterfaces;

public class UseMyFunctionalInterface {

    public static void main(String[] args) {
        //implementation 1
        MyFunctionalInterface impl1 = (num) -> num+5;
        System.out.println(impl1.function(20));

        //implementation 2
        MyFunctionalInterface impl2 = (num) -> num * 5;
        System.out.println(impl2.function(20));

    }

}
