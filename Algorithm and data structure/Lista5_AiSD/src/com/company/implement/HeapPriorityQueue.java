package com.company.implement;

import java.util.*;

public class HeapPriorityQueue implements Queue {

    private final List _list;

    public HeapPriorityQueue() {
        _list = new LinkedList();
    }

    public void enqueue(Object value) {
        _list.add(value);
        swim(_list.size() - 1);
    }

    //wynoszenie elementu w górę
    private void swim(int index) {
        int parent;
        Comp comp=new Comp((Character)_list.get(index));
        while(index != 0 && comp.compareTo((Character)_list.get(parent= (index - 1) / 2)) > 0)
        { swap(index, parent);
            index=parent;
        }
    }

    private void swap(int index1, int index2) {
        Object temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        _list.set(index2, temp);
    }

    public Object dequeue()  {

        if (isEmpty()) {
            System.out.println("Lista pusta!");
            return null;
        }
        Object result = _list.get(0);
        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);
        }
        _list.remove(_list.size() - 1);
        return result;
    }

    // opuszczanie elementu w dół stogu
    private void sink(int index) {
        boolean isDone=false;
        int child;
        while(!isDone && (child=2*index+ 1 ) < _list.size()) {
            Comp comp=new Comp((Character)_list.get(index));
            if (child < _list.size()- 1 && comp.compareTo((Character)_list.get(child+1)) < 0){
                ++child;}
            if (comp.compareTo((Character)_list.get(child)) < 0){
                swap(index, child);}
            else{
                isDone=true;
            }
        }
    }

    public void clear() {
        _list.clear(); }

    public int size() {
        return _list.size(); }

    public boolean isEmpty() {
        return _list.isEmpty();}
}
