package com.java8.HGeeksForGeeksLambda;

public class CLambdaExpressionTwoArgs {

    @FunctionalInterface
    interface FunctInterface1 {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface FuncInterface2 {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, FunctInterface1 obj1) {
        return obj1.operation(a, b);
    }

    public static void main(String[] args) {
        FunctInterface1 add = (x, y) -> x + y; //Integer::sum
        FunctInterface1 multiply = (x, y) -> x * y;

        CLambdaExpressionTwoArgs test = new CLambdaExpressionTwoArgs();
        System.out.println("Addition : " + test.operate(5, 2, add));
        System.out.println("Multiplication : " + test.operate(5, 2, multiply));

        FuncInterface2 fobj = m -> System.out.println(m); //System.out::println
        fobj.sayMessage("calculation completed");
    }

}
