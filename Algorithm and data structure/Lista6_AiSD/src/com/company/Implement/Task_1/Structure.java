package com.company.Implement.Task_1;


import com.company.Implement.other.Iterator;

public class Structure implements Set {

    private Map_1 map=new Map_1();
    private int key;

    public Structure(){
        key=-1;
    }

    @Override
    public void add(String value) {
     map.put(value,++key);
    }

    @Override
    public boolean contains(String value) {
        return map.containsKey(value);
    }

    @Override
    public void remove(String value) {
        map.remove(value);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        String s="";
        Iterator it= map.keyIterator();
        for(it.first();!it.isDone();it.next()){
            s+="[ "+it.current()+" ] ";
        }
        return "Task 5: \n Structure: "+s;
    }
}
