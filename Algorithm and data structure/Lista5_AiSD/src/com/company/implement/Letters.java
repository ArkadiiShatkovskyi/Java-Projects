package com.company.implement;

import java.util.LinkedList;
import java.util.List;

public class Letters {

    public List letters(String s){
        LinkedList<Character> list=new LinkedList<Character>();
        char[] table=s.toCharArray();
        for(int i=0;i<table.length;i++){
            list.add(table[i]);
        }
        return list;
    }


}
