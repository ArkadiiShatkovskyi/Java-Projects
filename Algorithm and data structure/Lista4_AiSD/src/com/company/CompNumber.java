package com.company;


public class CompNumber implements Comparable<Integer> {
    Integer object;

    public CompNumber(Integer obj){
        this.object=obj;
    }

    @Override
    public int compareTo(Integer o) {
        CompNumber compbl=new CompNumber(o);
        return object.compareTo(compbl.object);
    }
}