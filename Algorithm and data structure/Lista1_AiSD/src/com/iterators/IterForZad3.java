package com.iterators;

import java.util.function.Function;
import java.util.function.Predicate;

public class IterForZad3 {

    Function func;
    Predicate pred;
    Iterator it;

    public IterForZad3(Iterator it,Predicate pr, Function func) {
        this.it=it;
        this.pred=pr;
        this.func=func;
    }

    public void filterForwards()
    { while( !it.isDone() && !pred.test(it.current()))
        it.next();
    }

    public void filterBackwards()
    { while( !it.isDone() && !pred.test(it.current()))
        it.previous();
    }

    public void first(){
        it.first();
        filterForwards();
    }

    public void previous(){
        it.previous();
        filterBackwards();
    }

    public void next(){
        it.next();
        filterForwards();
    }

    public void last(){
        it.last();
        filterBackwards();
    }

    public boolean isDone(){
        return it.isDone();
    }


    public Object current() {
        return func.apply(it.current());
    }

    @Override
    public String toString() {
        String st="";
        first();
        while (!isDone()){
            st+="["+ current()+"]";
            next();
        }
        return st;
    }
}