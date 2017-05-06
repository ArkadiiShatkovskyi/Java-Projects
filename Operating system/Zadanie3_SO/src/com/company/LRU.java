package com.company;

import java.util.LinkedList;

public class LRU {

private int[] ramki;
private int bladow=0;
private LinkedList<Integer> zgloszenia=new LinkedList<Integer>();

    public LRU(int ramek, LinkedList<Integer> list){
        ramki=new int[ramek];
        zgloszenia=list;
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public void lru(){
        LinkedList<Integer> usuniete =new LinkedList<Integer>();
        int i=0;
        while (!zgloszenia.isEmpty()){
            if(ramki[ramki.length-1]==-1){
                if(!sprawdz(zgloszenia.getFirst())){
                   int d= ramki[i]=zgloszenia.removeFirst();
                    usuniete.add(d);
                }
                else {
                    usuniete.add(zgloszenia.removeFirst());
                }
            }
            else{
                if(!sprawdz(zgloszenia.getFirst())){
                       int d= ramki[indexPage(usuniete)]=zgloszenia.removeFirst();
                        usuniete.add(d);
                        ++bladow;
                }
                else {
                    usuniete.add(zgloszenia.removeFirst());
                }
            }
            i=i==ramki.length-1?0:++i;
        }
    }

    private int indexPage(LinkedList<Integer> list){
        int page=0;
        int[] ind=new int[ramki.length];
        for(int k=0;k<ramki.length;k++){
            for(int i=0;i<list.size();i++){
                if(list.get(i)==ramki[k]){
                    ind[k]=i;
                }
            }
        }
        int z=ind[0];
        for(int i=0;i<ind.length;i++){
            if(z>ind[i]){
                z=ind[i];
                page=i;
            }
        }
        return page;
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
        return "LRU: \n bladow: [ "+bladow+" ]";
    }
}
