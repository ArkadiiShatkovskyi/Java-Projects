package com.company.InterfacesAndImplements;


import java.util.EmptyStackException;

public class ListLIFO implements Stack {

    private LinkedList list=new LinkedList();
    static int size_list;

    public ListLIFO(int size_list){
        this.size_list=size_list;
    }

    @Override
    public void push(Object value) {
        if(list.size()<size_list-1){
            list.add(value);}
        else{
            pop();
            list.add(value);}
    }

    @Override
    public Object pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list.delete(list.size());
    }

    @Override
    public Object peek() throws EmptyStackException {
        Object result=pop();
        push(result);
        return result;
    }

    @Override
    public void enqueue(Object value) {
        push(value);
    }

    @Override
    public Object dequeue() throws EmptyStackException {
        try {
            return pop();
        }
        catch (EmptyStackException e){
            throw new EmptyStackException();
        }
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
        return list .isEmpty();
    }

    @Override
    public Object shift() {
        return list.delete(0);
    }

    @Override
    public void unshift(Object value) {
        if(list.size()<size_list-1)
            list.insert(0,value);
        else{
            pop();
            list.insert(0,value);
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

