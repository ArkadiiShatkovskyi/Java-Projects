package com.company.Zadania.ClasyPomocnicze;

import java.util.LinkedList;

public class Proces {

    private int obciazenie;
    private int zapytanOObciazenie;
    private LinkedList<Integer> listaObciazen;
    private int zadanie;

    public Proces(){
        obciazenie=0;
        zapytanOObciazenie=0;
        listaObciazen=new LinkedList<Integer>();
    }

    public void wykonujZad(){
        if(zadanie>0){
            --zadanie;
        }
        else{
            obciazenie=0;
        }
    }

    public void setZadanie(int zadanie){
        this.zadanie=zadanie;
    }

    public void obnowObciazenie(int obciazenie){
        this.obciazenie+=obciazenie;
        listaObciazen.add(obciazenie);
    }

    public int getZadanie(){
        return zadanie;
    }

    public void setObciazenie(int obciazenie){
        this.obciazenie=obciazenie;
        listaObciazen.add(obciazenie);
    }

    public int getObciazenie(){
        ++zapytanOObciazenie;
        return obciazenie;
    }

    public double sredniaObcProc(){
        int x=0;
        for(Integer i:listaObciazen){
            x+=i;
        }
        return x/listaObciazen.size();
    }

    public int srednieOdczylenie(){
        int x=0;
        for(Integer i:listaObciazen){
            x+=Math.abs(i-sredniaObcProc());
        }
        return x/listaObciazen.size();
    }

    public int getZapytanOObciazenie(){
        return zapytanOObciazenie;
    }
}
