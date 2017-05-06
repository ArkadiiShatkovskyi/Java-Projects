package com.company.Zadania.Zadanie_2;

import com.company.Zadania.ClasyPomocnicze.ClassPom;
import com.company.Zadania.ClasyPomocnicze.Proces;

import java.util.LinkedList;

public class Zadanie2 {

    private int prog;
    private int procesow;
    private LinkedList<Proces> procesy=new LinkedList<Proces>();
    private LinkedList<int[]> zadania=new LinkedList<int[]>();

    public Zadanie2(int prog,int procesow){
        this.prog=prog;
        this.procesow=procesow;
        ClassPom cp=new ClassPom();
        procesy=cp.stworzProc(procesow);
        zadania=cp.stworzZadan();
    }

    public Zadanie2(int prog,int procesow,LinkedList<Proces> procesy,LinkedList<int[]> zadania){
        this.prog=prog;
        this.procesow=procesow;
        this.procesy=procesy;
        this.zadania=zadania;
    }

    public void algorytm(){
        int[] zad=null;
        if(!zadania.isEmpty()){
        zad=zadania.removeFirst();
        }
        while(!zadania.isEmpty()){
            wykonuj();
            int i=(int)(Math.random()*procesy.size()); //losujemy procesor
            int obciazeniaProc=procesy.get(i).getObciazenie();
            if(obciazeniaProc<prog && (obciazeniaProc+zad[0])<=100){
                procesy.get(i).setObciazenie(obciazeniaProc+zad[0]); //zadajemy obciazenie
                procesy.get(i).setZadanie(procesy.get(i).getZadanie()+zad[1]);    // ... zadanie
                algorytm();
            }
        }
    }

    private void wykonuj(){
        for(Proces p:procesy){
            p.wykonujZad();
        }
    }

    @Override
    public String toString() {
        ClassPom clp=new ClassPom();
        return "\nZadanie drugie: [procesów: "+procesow+", próg: "+prog+"]\nWyniki: [ średnia obciążenia: "+clp.sredniaObcProc(procesy)+
                ", średnia odchyłenia: "+clp.sredniaOdczylenia(procesy)+", ilość migracji: "+clp.iloscZapytOObc(procesy)+"]";
    }
}
