package com.company;

import java.util.ArrayList;
import java.util.List;

public class Letters {

    public List letters(String s){
        ArrayList<Character> list=new ArrayList<Character>();
        char[] table=s.toCharArray();
        for(int i=0;i<table.length;i++){
            list.add(table[i]);
        }
        return list;
    }
}
