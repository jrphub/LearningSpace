package com.pluralsight.generics.module3;

import com.pluralsight.generics.module2.APerson;

import java.util.Comparator;

public class AgeComparator implements Comparator<APerson> {
    @Override
    public int compare(APerson left, APerson right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
