package com.company;

import java.util.ArrayList;

public class Process implements Cloneable {

    private int id;
    private int numerCylindru;
    private int gdziePojawia;
    private boolean czyWystapil;

    public Process (int id,int gdziePojawia,int numerCylindru) {
        this.id = id;
        this.numerCylindru=numerCylindru;
        this.gdziePojawia=gdziePojawia;
        czyWystapil=false;
    }

    public Process(ArrayList arr){
        this.id=(Integer)arr.get(0);
        gdziePojawia =(Integer)arr.get(1);
        numerCylindru =(Integer)arr.get(2);
        czyWystapil=false;
    }

    public boolean czyWystapilPr(){
        return czyWystapil;
    }

    public void sprawdz(int n){
        if(n==getGdziePojawia()){
            czyWystapil=true;
        }
    }

   // public boolean czyProcRT(){

  //  }

    public int getGdziePojawia(){
        return gdziePojawia;
    }

    public int getId() {
        return id;
    }

    public int getNumerCylindru() {
        return numerCylindru;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("com.Process nie moze  skopiowac sie");
        }
        return o;
    }
}