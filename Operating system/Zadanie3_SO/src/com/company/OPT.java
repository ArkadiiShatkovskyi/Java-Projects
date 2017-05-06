package com.company;

import java.util.LinkedList;

public class OPT {
    private int[] ramki;
    private int bladow=0;
    private LinkedList<Integer> zgloszenia=new LinkedList<Integer>();

    public OPT(int ramek, LinkedList<Integer> list){
        ramki=new int[ramek];
        zgloszenia=list;
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public void opt(){
        int i=0;
        while (!zgloszenia.isEmpty()){
            if(ramki[ramki.length-1]==-1){
                if(!sprawdz(zgloszenia.getFirst())){
                    ramki[i]=zgloszenia.removeFirst();
                }
                else {
                    zgloszenia.removeFirst();
                }
            }
            else{
                if(!sprawdz(zgloszenia.getFirst())){
                        ramki[indexPage()]=zgloszenia.removeFirst();
                        ++bladow;
                }
                else {
                    zgloszenia.removeFirst();
                }
            }
            i=i==ramki.length-1?0:++i;
        }
    }

    private boolean sprawdz(int strona){
        boolean wynik=false;
        for (int k=0;k<ramki.length;k++) {
            if (ramki[k] != -1 && ramki[k] == strona) {
                wynik = true;
            }
        }
        return wynik;
    }

    private int indexPage(){
        int page=0;
        int[] licznik=new int[ramki.length];
        for(int i=0;i<ramki.length;i++){
            for(int j=0;j<zgloszenia.size();j++){
                if(zgloszenia.get(j)==ramki[i]){
                    licznik[i]=licznik[i]+1;
                }
            }
        }
        int g=licznik[0];
        for (int i=0;i<licznik.length;i++){
            if(g>licznik[i]){
                page=i;
                g=licznik[i];
            }
        }
        return page;
    }

    @Override
    public String toString() {
        return "OPT: \n bladow: [ "+bladow+" ]";
    }
}