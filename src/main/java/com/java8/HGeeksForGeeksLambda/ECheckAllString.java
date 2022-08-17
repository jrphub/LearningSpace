package com.java8.HGeeksForGeeksLambda;

import java.util.function.Predicate;

public class ECheckAllString {

    static Predicate<String> p = ECheckAllString::test;

    //sol2 : static Predicate<String> p = s -> s.matches("^[a-zA-Z]*$");

    public static boolean isAllString(String str) {
        //sol1 : return (str != null) && (str != "") && str.chars().allMatch(Character::isLetter);
        return (str != null) && (str != "") && p.test(str);
    }

    public static void main(String[] args) {
        System.out.println("For XYZ :" + ECheckAllString.isAllString("XYZ")); //true
        System.out.println("For XYZ12 :" + ECheckAllString.isAllString("XYZ12")); //false
        System.out.println("For null :" + ECheckAllString.isAllString(null)); //false
        System.out.println("For empty :" + ECheckAllString.isAllString("")); //false
    }

    private static boolean test(String s) {
        return s.matches("^[a-zA-Z]*$");
    }
}
