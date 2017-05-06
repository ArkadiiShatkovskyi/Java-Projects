package com.company.Tasks;

import java.util.LinkedList;

public class Proporcjonalny {

    private LinkedList<LRU> procesy=new LinkedList<LRU>();
    private int bladow;

    public Proporcjonalny(){
        bladow=0;
    }

    public void algorytm(int procesow, int ramek,int minRamek,LinkedList<LRU> list){
        GenerList generList=new GenerList();
        int dlugoscOdwolan=0;
        for(int i=0;i<list.size();i++){
            dlugoscOdwolan+=list.get(i).getListZgloszenia().size();
        }
        procesy=generList.createProc(procesow,ramek,minRamek,dlugoscOdwolan,list);
        for(int j=0;j<procesy.size();j++){
            procesy.get(j).lru();
            bladow+=procesy.get(j).getBladow();
        }
    }

    @Override
    public String toString() {
        return "Proporcjonalny: ["+" procesow: "+procesy.size()+", bladow: "+bladow+" ]";
    }
}