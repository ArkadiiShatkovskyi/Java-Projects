package com.iterators;

import java.util.function.Predicate;

public class IterForZad4 implements Iterator {

    final private Integer[] array1;
    final private int first1;
    private int current1=-1;
    private int N;
    private boolean flag=false;
    private Predicate pred;

    public IterForZad4(Integer[] array2,int toNumber,Predicate pr){
        array1=array2;
        first1=0;
        N=toNumber;
        pred=pr;
    }

    public void filterForwards()
    { while( !isDone() && !pred.test((Integer)current()))
        next();
    }

    public void filterBackwards()
    { while( !isDone() && !pred.test((Integer)current()))
        previous();
    }

    public void first(){
        current1=findFirst();
        filterForwards();
    }

    public void previous(){
        current1--;
        filterBackwards();}

    public void next(){
        current1++;
    filterForwards();}

    public void last(){current1=findLast();
    filterBackwards();}

    public boolean isDone(){return current1<first1||current1>array1.length-1||flag; }

    public Object current(){
        Function_implement fi=new Function_implement();
        return fi.apply(array1[current1]);}


    public int findFirst(){
        if((array1[first1] % 3 == 0) || (array1[first1] % 5 == 0)){
            return first1;
        }
        else{
            current1=0;
            next();
            return current1;
        }
    }

    public int findLast(){
        if((array1[array1.length-1] % 3 == 0) || (array1[array1.length-1] % 5 == 0)){
            return array1.length-1;
        }
        else{
            current1=array1.length-1;
            previous();
            return current1;
        }
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