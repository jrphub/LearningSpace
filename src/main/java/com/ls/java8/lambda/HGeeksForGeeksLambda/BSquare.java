package com.ls.java8.lambda.HGeeksForGeeksLambda;

@FunctionalInterface
public interface BSquare {
    int calculate(int x);
}

class calculator {
    public static void main(String[] args) {
        int a = 5;
        //lambda expression : instance of Functional Interface
        BSquare s = (int x) -> x * x;
        System.out.println(s.calculate(a));
    }
}
