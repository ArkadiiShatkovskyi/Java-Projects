package com.company.InterfacesAndImplements;

import java.util.EmptyStackException;

public interface Stack extends Queue {

    public void push(Object value);
    public Object pop()throws EmptyStackException;
    public Object peek()throws EmptyStackException;
    public void clear();
    public int size();
    public boolean isEmpty();
    public Object shift();
    public void unshift(Object value);

}
