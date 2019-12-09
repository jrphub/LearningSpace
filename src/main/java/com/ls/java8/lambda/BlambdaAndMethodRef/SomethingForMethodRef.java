package com.ls.java8.lambda.BlambdaAndMethodRef;

public class SomethingForMethodRef {
    //instance method
    //get the first character of a String
    public String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    //Get the first digit of a number
    public int startsWith(Integer integer) {
        String s = String.valueOf(integer);
        return Integer.parseInt(s.substring(0,1));
    }
}
