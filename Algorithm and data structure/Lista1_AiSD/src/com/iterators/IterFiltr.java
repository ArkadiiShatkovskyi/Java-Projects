package com.iterators;


import java.util.function.Predicate;

public class IterFiltr implements Iterator {


    Predicate pred;
    Iterator it;

    public IterFiltr(Iterator it, java.util.function.Predicate pr) {
        this.it=it; pred=pr;
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

    public Object current(){
        return it.current();
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