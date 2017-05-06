package com.company;

import java.util.LinkedList;

public class Apr {
    private int[] ramki;
    private int[] bit;
    private int bladow=0;
    private LinkedList<Integer> zgloszenia=new LinkedList<Integer>();

    public Apr(int ramek, LinkedList<Integer> list){
        ramki=new int[ramek];
        zgloszenia=list;
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public void apr(){
        LinkedList<Integer> usuniete =new LinkedList<Integer>();
        bit=new int[ramki.length];
        int i=0;
        while (!zgloszenia.isEmpty()){
            if(ramki[ramki.length-1]==-1){
                if(!sprawdz(zgloszenia.getFirst())){
                    ramki[i]=zgloszenia.removeFirst();
                    usuniete.add(ramki[i]);
                    bit[i]=0;
                }
                else {
                    boolean flag=false;
                        if(!zgloszenia.isEmpty() && bit[i]==0){
                            bit[i]=1;
                            zgloszenia.removeFirst();
                            flag=true;
                        }
                        if(!flag){zgloszenia.removeFirst();}
                    }
            }
            else{
                if(!sprawdz(zgloszenia.getFirst())){
                    if( sprawdzBit()==1){
                        zmienBit(usuniete.getFirst());
                    }
                    if(bit[i]==0){
                            ramki[i]=zgloszenia.removeFirst();
                            bit[i]=0;
                            usuniete.removeFirst();
                            usuniete.add(ramki[i]);
                            ++bladow;
                        }
                }
                else {
                    if(!zgloszenia.isEmpty()){
                    boolean flag=false;
                            if(!zgloszenia.isEmpty()&& bit[i]==0){
                                bit[i]=1;
                                zgloszenia.removeFirst();
                                flag=true;
                            }
                    if(!flag){zgloszenia.removeFirst();}
                  }
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

    private int sprawdzBit(){
       int wynik=1;
        for(int i=0;i<bit.length;i++){
            if(bit[i]==0){
                wynik=0;
            }
        }
        return wynik;
    }

    public void zmienBit(int ob){
        for(int i=0;i<ramki.length;i++){
            if(ramki[i]==ob){
                bit[i]=0;
            }
        }
    }

    @Override
    public String toString() {
        return "Aproksymowany LRU: \n bladow: [ "+bladow+" ]";
    }
}