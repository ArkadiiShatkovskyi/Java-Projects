package com.company.Tasks;

import java.util.LinkedList;

public class LRU {

    private int[] ramki;
    private int bladow=0;
    private int maxBladow=0;
    private int minRamek=0;
    private LinkedList<Integer> zgloszenia=new LinkedList<Integer>();

    public LRU(int ramek){
        ramki=new int[ramek];
        this.minRamek=ramek;
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public LRU(){}

    public LRU(int ramek,LinkedList<Integer> zgloszenia){
        this.zgloszenia=zgloszenia;
        this.minRamek=ramek;
        ramki=new int[ramek];
        for(int i=0;i<ramki.length;i++){
            ramki[i]=-1;
        }
    }

    public void setMinRamek(int minRamek){
        this.minRamek=minRamek;
    }

    public int getMinRamek(){
        return minRamek;
    }

    public int getZgloszenia(){
        return zgloszenia.size();
    }

    public LinkedList<Integer> getListZgloszenia(){
        return zgloszenia;
    }

    public void setZgloszenia(LinkedList<Integer> list){
        zgloszenia=list;
    }

    public int getRamki(){
        return ramki.length;
    }

    public void setRamki(int ramek){
        ramki=new int[ramek];
    }

    public int getBladow(){
        return bladow;
    }

    public void resetBlady(){
        bladow=0;
    }

    public void setMaxBladow(int max){
        maxBladow=max;
    }

    public void lru(){
        LinkedList<Integer> usuniete =new LinkedList<Integer>();
        LinkedList<Integer> zgloszenia2=(LinkedList<Integer>)zgloszenia.clone();
        int i=0;
        while (!zgloszenia2.isEmpty()){
           // System.out.println("1: "+ramki.length);
            if(ramki.length>0){
            if(ramki[ramki.length-1]==-1){
                if(!sprawdz(zgloszenia2.getFirst())){
                    int d= ramki[i]=zgloszenia2.removeFirst();
                    usuniete.add(d);
                }
                else {
                    usuniete.add(zgloszenia2.removeFirst());
                }
            }
            else{
                if(!sprawdz(zgloszenia2.getFirst())){
                    int d= ramki[indexPage(usuniete)]=zgloszenia2.removeFirst();
                    usuniete.add(d);
                    ++bladow;
                }
                else {
                    usuniete.add(zgloszenia2.removeFirst());
                }
            }
            }
            else{
                zgloszenia2.removeFirst();
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
        return "LRU: \n bladow: [ "+bladow+", odwolan: "+getZgloszenia()+" ]";
    }
}
