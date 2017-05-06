package com.company.InterfacesAndImplements;

public interface List{

    public void insert(int index, Object value) throws IndexOutOfBoundsException;
    public void add(Object value);
    public boolean delete(Object value);
    public Object delete(int index);
    public void clear();
    public Object set(int index,Object value);
    public Object get(int index)throws IndexOutOfBoundsException;
    public int indexOf(Object value);
    public boolean contains(Object value);
    public int size();
    public boolean isEmpty();
    public Iterator iterator();
}
