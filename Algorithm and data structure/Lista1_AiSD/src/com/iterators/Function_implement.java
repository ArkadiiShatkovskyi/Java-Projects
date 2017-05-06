package com.iterators;

import java.util.function.Function;

public class Function_implement implements Function {

    @Override
    public Object apply(Object obj) {
        return (Integer)obj*2;
    }
}
