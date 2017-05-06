package com.company.Tasks;

import java.util.LinkedList;

public class GenerList {

    public LinkedList<Integer> gener(int size,int max){
        LinkedList<Integer> list =new LinkedList<Integer>();
        int minN=0;
        int toNum=max;
        for(int i=0; i<size;i++){
            list.add(((int)(Math.random()*(toNum-minN))+minN));
            if(list.get(i)>9){
                minN=list.get(i)-7;
            }
            if(list.get(i)<max){
                toNum=list.get(i)+7;
            }
        }
        return list;
    }

    public LinkedList<LRU> createProc(int procesow,int ramek,int minRamek,int minZgloszen,int maxZgloszen,int zakres,boolean flag){
        LinkedList<LRU> process=new LinkedList<LRU>();
        int ram=ramek/procesow;
        for(int i=0;i<procesow;i++){
            if(ramek>0){
                if(flag){
                    process.add(new LRU(ram));
                }
                else{
                     process.add(new LRU(minRamek));}
                     process.get(i).setMinRamek(minRamek);
                     process.get(i).setZgloszenia(gener((int) ((Math.random() * (maxZgloszen - minZgloszen)) + minZgloszen), zakres));
                     ramek-=minRamek;
            }
        }
        return process;
    }

    public LinkedList<LRU> createProc(int procesow,int minRamek){
        LinkedList<LRU> process=new LinkedList<LRU>();
        for(int i=0;i<procesow;i++){
                process.add(new LRU(minRamek));
                process.get(i).setMinRamek(minRamek);
        }
        return process;
    }

    //dla algorytmu proporcjonalnego
    public LinkedList<LRU> createProc(int procesow,int ramek,int minRamek,int odwolan, LinkedList<LRU> list){
        LinkedList<LRU> process=new LinkedList<LRU>();
        int zostalo=ramek;
        for(int i=0;zostalo>0;i++){
            if(i==procesow){
                i=0;
            }
           // System.out.println("ramek: "+zostalo);
            int ramekWProc=(ramek*list.get(i).getListZgloszenia().size())/odwolan;
            if(minRamek<minRamek || ramekWProc>zostalo){
                process.add(new LRU(minRamek));
                process.get(i).setMinRamek(minRamek);
                zostalo-=minRamek;
            }
            else{
                process.add(new LRU(ramekWProc));
                process.get(i).setMinRamek(ramekWProc);
                zostalo-=ramekWProc;
            }
            process.get(i).setZgloszenia(list.get(i).getListZgloszenia());
            }
        return process;
    }

    public LinkedList<LRU> przepisz(LinkedList<LRU> process,LinkedList<LRU> list){
        for(int i=0;i<process.size();i++){
            process.get(i).setZgloszenia(list.get(i).getListZgloszenia());
        }
        return process;
    }
}
