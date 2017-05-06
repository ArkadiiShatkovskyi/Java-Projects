package com.company;

import java.util.LinkedList;

public class RAND {

    private int[] ramki;
    private int bladow=0;
    private LinkedList<Integer> zgloszenia=new LinkedList<Integer>();

    public RAND(int ramek, LinkedList<Integer> list){
        ramki=new int[ramek];
        zgloszenia=list;
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public void rand(){
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
                        int j=(int)(Math.random()*ramki.length-1);
                        ramki[j]=zgloszenia.removeFirst();
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

    @Override
    public String toString() {
        return "RAND: \n bladow: [ "+bladow+" ]";
    }
}

