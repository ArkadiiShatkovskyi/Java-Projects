package com.company.Tasks;

import java.util.LinkedList;

public class SterowanieCBS {

    private LinkedList<LRU> procesy=new LinkedList<LRU>();
    private int bladow;

    public SterowanieCBS(){
        bladow=0;
    }

    public void algorytm(int procesow, int ramek,int minRamek,int ileRazPowtarzac,LinkedList<LRU> list){
        GenerList generList=new GenerList();
        LinkedList<Integer> blady=new LinkedList<Integer>();
        procesy=generList.createProc(procesow,minRamek);
        procesy=generList.przepisz(procesy,list);
        int zajete=0;
        int errors=0;
        int min=6;
        int z=2;
        for(int k=1;k<=ileRazPowtarzac;k++){
            for(int j=0;j<procesy.size();j++){
                procesy.get(j).lru();
                blady.add(j, procesy.get(j).getBladow());
                zajete+=procesy.get(j).getRamki();
                errors+=procesy.get(j).getBladow();
            }
            procesy=sterowanieBladami(procesy,blady,ramek-zajete,minRamek,min);
            System.out.println("Bladow dla: " + k + " razu: " + errors);
            if(z==k){
                z+=2;
               min = min==2?min:--min;
            }
            bladow=errors;
            blady.clear();
            errors=0;
            procesy=resetErr(procesy);
        }
    }

    private LinkedList<LRU> resetErr(LinkedList<LRU> list){
        for(int i=0;i<list.size();i++){
            list.get(i).resetBlady();
        }
        return list;
    }

/**
    private LinkedList<LRU> sterowanieBladami(LinkedList<LRU> procesy,LinkedList<Integer> blady,int wolnychRamek,int minRamek) {
        if (wolnychRamek <= 0) {
            int index=searchMin(procesy);
                if (procesy.get(index).getRamki() > minRamek) {
                    ++wolnychRamek;
                    procesy.get(index).setRamki(procesy.get(index).getRamki() - 1);
                }
          }
        if (wolnychRamek > 0) {
            int ind=searchMax(procesy);
                    procesy.get(ind).setRamki(procesy.get(ind).getRamki() + 1);
                    --wolnychRamek;
        }
        return procesy;
    }
**/

    private LinkedList<LRU> sterowanieBladami(LinkedList<LRU> procesy,LinkedList<Integer> blady,int wolnychRamek,int minRamek,int min){
    boolean flagMax=false;
    if(wolnychRamek<=0){
        for(int z=0;z<procesy.size();z++) {
            if (procesy.get(z).getRamki() > minRamek && (blady.get(z)<procesy.get(z).getZgloszenia()/min)) {
                ++wolnychRamek;
                procesy.get(z).setRamki(procesy.get(z).getRamki()-1);
            }
        }
    }
    if(wolnychRamek>0){
        for(int ind=0;ind<procesy.size();ind++){
            if(blady.get(ind)>(procesy.get(ind).getZgloszenia()/procesy.get(ind).getZgloszenia()/4)){
                procesy.get(ind).setRamki(procesy.get(ind).getRamki()+2);
                wolnychRamek-=2;
                flagMax=true;
            }
            else if(blady.get(ind)>(procesy.get(ind).getZgloszenia()/2)){
                procesy.get(ind).setRamki(procesy.get(ind).getRamki()+1);
                --wolnychRamek;
                flagMax=true;
            }
        }
        if(!flagMax){
            int index=searchMax(procesy);
            if(wolnychRamek>0){
                procesy.get(index).setRamki(procesy.get(index).getRamki()+1);
                --wolnychRamek;
            }
        }
    }
    return procesy;
    }

    private int searchMin(LinkedList<LRU> list){
        int index=0;
        double min=(list.get(0).getBladow()/list.get(0).getZgloszenia());
        double z;
        for(int i=0;i<list.size();i++){
            if((z=(list.get(i).getBladow()/list.get(i).getZgloszenia()))<min){
                min=z;
                index=i;
            }
        }
        return index;
    }

    private int searchMax(LinkedList<LRU> list){
        int index=0;
        double max=(list.get(0).getBladow()/list.get(0).getZgloszenia());
        double z;
        for(int i=0;i<list.size();i++){
            if((z=(list.get(i).getBladow()/list.get(i).getZgloszenia()))>max){
                max=z;
                index=i;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return "Sterowania bladami stron: ["+" procesow: "+procesy.size()+", bladow: "+bladow+" ]";
    }
}

