package com.pluralsight.generics.module2;

import java.util.ArrayList;
import java.util.List;

public class AList {

    public static void main(String[] args) {
        APerson p1 = new APerson("Sambit", 29);
        APerson p2 = new APerson("Abhishek", 39);

        List<APerson> madMen = new ArrayList<>();
        madMen.add(p1);
        madMen.add(p2);

        System.out.println(madMen);

        madMen.add(new APerson("Durga", 35));

        System.out.println(madMen);

        APerson aPerson = madMen.get(2);



    }
}
