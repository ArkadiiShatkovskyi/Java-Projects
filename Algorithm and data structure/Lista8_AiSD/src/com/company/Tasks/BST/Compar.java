package com.company.Tasks.BST;

import java.util.Comparator;

public class Compar implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}