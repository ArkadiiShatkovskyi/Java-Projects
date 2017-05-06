package com.company.InterfacesAndImplements;

import java.util.EmptyStackException;

public class ListStack implements Stack {

    private LinkedList list=new LinkedList();

    @Override
    public void push(Object value) {
    list.add(value);
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
         list.insert(0,value);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
