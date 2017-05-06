package com.company.Implement.Task_4;

import java.util.LinkedList;
import java.util.List;

public class MultiMapObject {

    private String key;
    private LinkedList<Integer> listValue=new LinkedList<Integer>();

    public MultiMapObject(String key, int value){
        this.key=key;
        listValue.add(value);
    }

    public void add(int value){
        listValue.add(value);
    }

    public String getKey(){
        return key;
    }

    public List getValue(){
        return listValue;
    }

    @Override
    public String toString() {
        return "[ Key:  '"+getKey()+"', Values: "+listValue.toString()+" ]";
    }
}
