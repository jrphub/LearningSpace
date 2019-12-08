package com.ls.java8.lambda.BlambdaAndMethodRef;

public class Converters {

    public static void main(String[] args) {
        //impl1
        IConverter<String,Integer> strToIntegerConverter = (from) -> Integer.valueOf(from);
        Integer strToIntegerVal = strToIntegerConverter.convert("01");
        System.out.println("strToIntegerVal : " + strToIntegerVal);

        //impl2
        IConverter<String, Double> strToDoubleConverter = (from) -> Double.valueOf(from);
        Double strToDoubleVal = strToDoubleConverter.convert("01");
        System.out.println("strToDoubleVal : " + strToDoubleVal);

        //Method reference
        //impl2
        //for static method valueOf
        IConverter<String, Double> strToDoubleConverter2 = Double::valueOf;
        Double strToDoubleVal2 = strToDoubleConverter.convert("01");
        System.out.println("strToDoubleVal2 : " + strToDoubleVal2);

        //Method Reference for object method
        //impl3
        //returns first character as String
        SomethingForMethodRef objMethodRef = new SomethingForMethodRef();
        IConverter<String, String> startsWithConverter = objMethodRef::startsWith;
        System.out.println("Object Method call : " + startsWithConverter.convert("Hello"));


    }
}
