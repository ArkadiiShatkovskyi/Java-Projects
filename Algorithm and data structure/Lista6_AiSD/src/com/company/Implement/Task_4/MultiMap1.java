package com.company.Implement.Task_4;

import java.util.List;

public interface MultiMap1 {

    List get(String key );
    void put(String key , int value );
    List remove(String key );
    void clear();
    int size();
    boolean isEmpty();
}
