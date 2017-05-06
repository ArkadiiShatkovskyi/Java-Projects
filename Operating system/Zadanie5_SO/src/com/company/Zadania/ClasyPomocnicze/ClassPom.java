package com.company.Zadania.ClasyPomocnicze;

import java.util.LinkedList;

public class ClassPom {  //klasa pomocnicza

    public LinkedList<Proces> stworzProc(int liczbaProc){
        LinkedList<Proces> procesy=new LinkedList<Proces>();
        for(int i=0;i<liczbaProc;i++){
            procesy.add(new Proces());
        }
        return procesy;
    }

    public LinkedList<int[]> stworzZadan(){
        LinkedList<int[]> zadania=new LinkedList<int[]>();
        //int zadan=(int)((Math.random()*50)+50);
        int zadan=10000;
        for(int i=0;i<zadan;i++){
            int x=(int)((Math.random()*100)+1);
            int y=(int)((Math.random()*30)+1);
            int[] tab=new int[2];
            tab[0]=x;  // obciazenie
            tab[1]=y;  // zadanie do wykonania
            zadania.add(tab);
        }
        return zadania;
    }

    public int sredniaObcProc(LinkedList<Proces> procesy){
        int x=0;
        for (Proces aProcesy : procesy) {
            x += aProcesy.sredniaObcProc();
        }
        return x/procesy.size();
    }

    public int sredniaOdczylenia(LinkedList<Proces> procesy){
        int x=0;
        for (Proces aProcesy : procesy) {
            x += aProcesy.srednieOdczylenie();
        }
        return x/procesy.size();
    }

    public int iloscZapytOObc(LinkedList<Proces> procesy){
        int x=0;
        for (Proces aProcesy : procesy) {
            x += aProcesy.getZapytanOObciazenie();
        }
        return x;
    }
}
