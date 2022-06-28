package com.pluralsight.generics.module3;

import com.pluralsight.generics.module2.APerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AList {

    public static void main(String[] args) {
        APerson p1 = new APerson("Sambit", 29);
        APerson p2 = new APerson("Abhishek", 39);

        List<APerson> madMen = new ArrayList<>();
        madMen.add(p1);
        madMen.add(p2);

        //System.out.println(madMen);

        madMen.add(new APerson("Durga", 35));

        //System.out.println(madMen);

        //Collections.sort(madMen, new AgeComparator());

        /*Collections.sort(madMen, new Comparator<APerson>() {
            @Override
            public int compare(APerson p1, APerson p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });*/

        Collections.sort(madMen, (p11, p21) -> Integer.compare(p11.getAge(), p21.getAge()));
        System.out.println(madMen);
        //reverse
        //Collections.sort(madMen, (p11, p21) -> -1 * Integer.compare(p11.getAge(), p21.getAge()));

        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));

        System.out.println(madMen);





    }
}
