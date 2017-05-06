package com.company.Task_1;

import java.util.Comparator;
import java.util.List;

public class IterativeBinaryListSearcher {

    private final Comparator _comparator;

    public IterativeBinaryListSearcher(Comparator comparator) {
        _comparator = comparator; }

    public int search(List list, Object value) {
        int lower = 0;
        int upper = list.size() - 1;
        int index=0,cmp=0;
       int z= Integer.MAX_VALUE/2;
        while (lower <= upper && (cmp = _comparator.compare(value, list.get(index=(lower/2 + upper/2))))!=0){
            if (cmp < 0){
                upper = index - 1;
            }
            else {
                lower = index + 1;
            }
        }
        return lower<=upper && cmp==0 ? index : -(lower+1);
    }
}
