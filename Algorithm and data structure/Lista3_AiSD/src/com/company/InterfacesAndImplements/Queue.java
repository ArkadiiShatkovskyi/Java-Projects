package com.company.InterfacesAndImplements;

import java.util.EmptyStackException;

public interface Queue {

    public void enqueue(Object value);
    public Object dequeue() throws EmptyStackException;
    public void clear();
    public int size();
    public boolean isEmpty();

}
