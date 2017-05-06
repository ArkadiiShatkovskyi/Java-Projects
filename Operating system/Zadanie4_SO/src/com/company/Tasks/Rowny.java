package com.company.Tasks;

import java.util.LinkedList;

public class Rowny {

    private LinkedList<LRU> procesy=new LinkedList<LRU>();
    private int bladow;

    public Rowny(){
        bladow=0;
    }

    public void algorytm(int procesow, int ramek,LinkedList<LRU> list){
        GenerList generList=new GenerList();
        procesy=generList.createProc(procesow,ramek/procesow);
        procesy=generList.przepisz(procesy,list);
        for(int j=0;j<procesy.size();j++){
            procesy.get(j).lru();
            bladow+=procesy.get(j).getBladow();
        }
    }

    @Override
    public String toString() {
        return "Rowny: ["+" procesow: "+procesy.size()+", bladow: "+bladow+" ]";
    }
}
