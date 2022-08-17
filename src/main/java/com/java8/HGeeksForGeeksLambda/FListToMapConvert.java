package com.java8.HGeeksForGeeksLambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input : List : [1="1", 2="2", 3="3"]
 * Output: Map  : {1=1, 2=2, 3=3, 4=4, 5=5}
 *
 * Input : List : [1="I", 2="love", 3="Geeks" , 4="for" , 5="Geeks"]
 * Output: Map  : {1=I, 2=Love, 3=Geeks, 4=For, 5=Geeks}
 */
public class FListToMapConvert {

    public static void main(String[] args) {
        List<ListItems> list = Arrays.asList(
                new ListItems(1, "I"),
                new ListItems(2, "Love"),
                new ListItems(3, "Geeks"),
                new ListItems(4, "For"),
                new ListItems(5, "Geeks")
        );
        list.forEach(
                System.out::println
        );
        Map<Integer, String> map = new HashMap<>();
        list.forEach(
                l -> map.put(l.getKey(), l.getValue())
        );
        System.out.println(map);

    }
}

class ListItems {
    int key;
    String value;

    ListItems(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ListItems{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
