package com.company.Implement.Task_4;

import java.util.LinkedList;
import java.util.List;

public class MultiMap implements MultiMap1 {

    private LinkedList<MultiMapObject> list=new LinkedList<MultiMapObject>();

    @Override
    public List get(String key) {
        List val=null;
        for(int i=0;i<list.size();i++){
               if(list.get(i).getKey()==key){
                val=list.get(i).getValue();
               }
        }
        return val;
    }

    @Override
    public void put(String key, int value) {
        boolean flag=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey()==key){
                list.get(i).add(value);
                flag=true;
            }
        }
        if(!flag){
            list.add(new MultiMapObject(key,value));
        }
    }

    @Override
    public List remove(String key) {
        List val=null;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getKey()==key){
                val=list.get(i).getValue();
                list.remove(i);
            }
        }
        return val;
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

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<list.size();i++){
            s+=list.get(i).toString();
        }
        return "Task 4: \n MultiMap: "+s;
    }
}