package com.company.Implement.other;

public interface Map {
    int get(String key );
    void put(String key , int value );
    boolean containsKey(String key );
    int remove(String key );
    void clear();
    int size();
    boolean isEmpty();
}
