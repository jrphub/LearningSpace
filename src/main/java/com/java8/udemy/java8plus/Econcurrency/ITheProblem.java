package com.java8.udemy.java8plus.Econcurrency;

import java.util.HashMap;
import java.util.Map;

public class ITheProblem {
    public static void main(String[] args) {
        iteratorNoIssue();
        //enhancedForIssue();
    }
    public static void iteratorNoIssue(){
        Map<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");

        System.out.println("Before: "+capitalCities);
        for (var iter = capitalCities.keySet().iterator(); iter.hasNext(); ) {
            var key = iter.next();
            System.out.println(key + " is the capital of " + capitalCities.get(key));
            iter.remove();
        }
        System.out.println("After: "+capitalCities);
    }
    public static void enhancedForIssue(){
        Map<String, String> capitalCities = new HashMap<>();
//        Map<String, String> capitalCities = new ConcurrentHashMap<>(); // fixes the issue
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");

        System.out.println("Before: "+capitalCities);
        for(String key: capitalCities.keySet()){
            System.out.println(key+ " is the capital of "+capitalCities.get(key));
            capitalCities.remove(key);// ConcurrentModificationException
        }
        System.out.println("After: "+capitalCities);
    }
}
