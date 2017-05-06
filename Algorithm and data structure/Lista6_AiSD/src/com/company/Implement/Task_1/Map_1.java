package com.company.Implement.Task_1;

import com.company.Implement.other.Iterator;
import com.company.Implement.other.Map;

import java.util.LinkedList;

public class Map_1 implements Map {

    private LinkedList<MapObject> list=new LinkedList<MapObject>();

    @Override
    public int get(String key) {
        int val=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey()==key){
                val=list.get(i).getValue();
            }
        }
        return val;
    }

    @Override
    public void put(String key, int value) {
        if(!containsKey(key)){
        list.add(new MapObject(key,value));
        }
        else {
            System.out.println("The map has the key!");
        }
    }

    @Override
    public boolean containsKey(String key) {
        boolean wynik=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey()==key){
                wynik=true;
            }
        }
        return wynik;
    }

    @Override
    public int remove(String key) {
        int val=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey()==key){
                val=list.get(i).getValue();
                list.remove(i);
            }
        }
        return val;
    }

    public void fuck(){
        System.out.println("hi");
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator keyIterator(){
        return new KeyIterator(list);
    }

    public Iterator valueIterator(){
        return new ValueIterator(list);
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<list.size();i++){
            s+=list.get(i).toString();
        }
        return "Task 1: \n Map: "+s;
    }
}
