package com.company;

public class Comp implements Comparable<Character> {

    Character object;

    public Comp(Character obj){
        this.object=obj;
    }

    @Override
    public int compareTo(Character o) {
        Comp comp =new Comp(o);
        return object.compareTo(comp.object);
    }
}
