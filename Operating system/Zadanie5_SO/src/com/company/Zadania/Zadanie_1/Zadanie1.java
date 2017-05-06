package com.company.Zadania.Zadanie_1;

import com.company.Zadania.ClasyPomocnicze.ClassPom;
import com.company.Zadania.ClasyPomocnicze.Proces;

import java.util.LinkedList;

public class Zadanie1 {

    private int prog;
    private int procesow;
    private int ileProb;
    private LinkedList<Proces> procesy=new LinkedList<Proces>();
    private LinkedList<int[]> zadania=new LinkedList<int[]>();

    public Zadanie1(int prog,int prob,int liczbaProc){
        this.prog=prog;
        this.procesow=liczbaProc;
        this.ileProb=prob;
        ClassPom classPom=new ClassPom();
        procesy=classPom.stworzProc(liczbaProc);
        zadania=classPom.stworzZadan();
    }

    public Zadanie1(int prog,int prob,int liczbaProc,LinkedList<Proces> procesy,LinkedList<int[]> zadania){
        this.prog=prog;
        this.procesow=liczbaProc;
        this.ileProb=prob;
        this.procesy=procesy;
        this.zadania=zadania;
    }

    public void algorytm(){
        int[] zad=null;
        if(!zadania.isEmpty()){
          zad=zadania.removeFirst();
        }
        int raz=0;
         while(!zadania.isEmpty()){
             wykonuj();
             raz=raz==ileProb?raz:++raz;
             int i=(int)(Math.random()*procesy.size()); //losujemy procesor
             int obciazenieProc=procesy.get(i).getObciazenie();
             if(obciazenieProc<prog && (obciazenieProc+zad[0])<=100){
                 procesy.get(i).setObciazenie(obciazenieProc+zad[0]); //zadajemy obciazenie
                 procesy.get(i).setZadanie(procesy.get(i).getZadanie()+zad[1]);    // ... zadanie
                 algorytm();
             }
             if(raz==ileProb){  // jezeli po 'raz' prob nie wylosowalismy potrzebny procesor
                 i=(int)(Math.random()*procesy.size());
                 if(obciazenieProc<100 && (obciazenieProc+zad[0])<=100){
                     procesy.get(i).setObciazenie(obciazenieProc+zad[0]); //zadajemy obciazenie
                     procesy.get(i).setZadanie(procesy.get(i).getZadanie()+zad[1]);    // ... zadanie
                     algorytm();
                 }
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
        return "Zadanie pierwsz: [procesow: "+procesow+", prób: "+ileProb+", próg: "+prog+"]\nWyniki: [ średnia obciążenia: "+clp.sredniaObcProc(procesy)+
                ", średnia odchyłenia: "+clp.sredniaOdczylenia(procesy)+", ilość migracji: "+clp.iloscZapytOObc(procesy)+"]";
    }
}
