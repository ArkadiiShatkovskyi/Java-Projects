package com.iterators;


import java.util.function.Predicate;

public class Predicate_implement implements Predicate {

    @Override
    public boolean test(Object o) {
        return (Integer)o%3==0;
    }


}
