package com.company.Zadania.Zadanie_3;

import com.company.Zadania.ClasyPomocnicze.ClassPom;
import com.company.Zadania.ClasyPomocnicze.Proces;

import java.util.LinkedList;

public class Zadanie3 {

    private int prog;
    private int minProg;
    private int procesow;
    private LinkedList<Proces> procesy=new LinkedList<Proces>();
    private LinkedList<int[]> zadania=new LinkedList<int[]>();

    public Zadanie3(int prog,int minimalnyProg,int procesow){
        this.prog=prog;
        this.procesow=procesow;
        this.minProg=minimalnyProg;
        ClassPom cp=new ClassPom();
        procesy=cp.stworzProc(procesow);
        zadania=cp.stworzZadan();
    }

    public Zadanie3(int prog,int minimalnyProg,int procesow,LinkedList<Proces> procesy,LinkedList<int[]> zadania){
        this.prog=prog;
        this.minProg=minimalnyProg;
        this.procesow=procesow;
        this.procesy=procesy;
        this.zadania=zadania;
    }

    public void algorytm(){
        if(zadania.isEmpty()){
            return;
        }
        int[] zad=zadania.removeFirst();
        while(!zadania.isEmpty()){
            if(zad[0]<=0){
                algorytm();
            }
            wykonuj();
            int i=(int)(Math.random()*procesy.size()); //losujemy procesor
            int obciazenieProc=procesy.get(i).getObciazenie();
            if(obciazenieProc<prog && (obciazenieProc+zad[0])<=100){
                procesy.get(i).setObciazenie(obciazenieProc+zad[0]); //zadajemy obciazenie
                procesy.get(i).setZadanie(procesy.get(i).getZadanie()+zad[1]);    // ... zadanie
                algorytm();
            }
            else if(obciazenieProc>=prog && zad[0]<=minProg &&(obciazenieProc+(zad[0]/2))<=100){
                if(zad[0]==1 && obciazenieProc+zad[0]<=100){
                    procesy.get(i).obnowObciazenie(zad[0]); //zadajemy czesc obciazenie
                    procesy.get(i).setZadanie(procesy.get(i).getZadanie()+zad[1]);    // ... zadania
                }
                else{
                    if(zad[0]/2!=0){
                procesy.get(i).obnowObciazenie(zad[0]/2); //zadajemy czesc obciazenie
                procesy.get(i).setZadanie(procesy.get(i).getZadanie()+(zad[1]/2));    // ... zadania
                zad[0]-=zad[0]/2;
                zad[1]-=zad[1]/2;
                    }
                }
            }//else if
        }//while
    }

    private void wykonuj(){
        for(Proces p:procesy){
            p.wykonujZad();
        }
    }

    @Override
    public String toString() {
        ClassPom clp=new ClassPom();
        return "\nZadanie trzecie: [procesów: "+procesow+", próg: "+prog+", minimalny próg: "+minProg+"]\nWyniki: [ średnia obciążenia: "+clp.sredniaObcProc(procesy)+
                ", średnia odchyłenia: "+clp.sredniaOdczylenia(procesy)+", ilość migracji: "+clp.iloscZapytOObc(procesy)+"]";
    }
}
