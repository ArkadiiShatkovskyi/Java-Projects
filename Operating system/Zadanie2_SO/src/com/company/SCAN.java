package com.company;

import java.util.LinkedList;

public class SCAN {

    private int[] cylinryDysku;
    private LinkedList<Process> listaOczekujacych=new LinkedList<Process>();
    private LinkedList<Process> skonczoneProcesy=new LinkedList<Process>();
    private LinkedList<Process> listaProcPrior=new LinkedList<Process>();

    public SCAN(LinkedList list,LinkedList listaProcPrior,int rozmiar){
        listaOczekujacych=list;
        this.listaProcPrior=listaProcPrior;
        cylinryDysku=new int[rozmiar];
    }

    public void algorutm(int gdzieGlowica,boolean edfOnOff){

        int przejsc=0;
        int gdzieN=gdzieGlowica;
        boolean flag;
        LinkedList<Process> listaNieWyk=new LinkedList<Process>();
        if ((cylinryDysku.length-gdzieN)>(gdzieN)){
            flag=true;
        }
        else {
            flag=false;
        }

        boolean koniec=false;
        while((!edfOnOff && !listaOczekujacych.isEmpty()) || (!koniec && edfOnOff)){
            Process wykonywany=null;
            if(!flag){
                if(gdzieN==cylinryDysku.length-1){ flag=true;}
                else{
                    for(Process process:listaProcPrior){
                        process.sprawdz(gdzieN);
                    }
                    ++gdzieN;
                    ++przejsc;
                }
                if(edfOnOff){
                    wykonywany=czyJestProcRT(gdzieN);
                    if(wykonywany==null){
                        for (int k=0;k<listaOczekujacych.size();k++) {
                            if (listaOczekujacych.get(k).getNumerCylindru() == gdzieN) {
                                wykonywany = listaOczekujacych.remove(k);
                                skonczoneProcesy.add(wykonywany);
                            }
                        }
                    }
                }
                else if(!edfOnOff){
                    for (int k=0;k<listaOczekujacych.size();k++) {
                        if (listaOczekujacych.get(k).getNumerCylindru() == gdzieN) {
                            wykonywany = listaOczekujacych.remove(k);
                            skonczoneProcesy.add(wykonywany);
                        }
                    }
                }//else if !edf
            }//if !flag
            else if(flag) {

                if(gdzieN==0){flag=false;}
                else{
                    for(Process process:listaProcPrior){
                        process.sprawdz(gdzieN);
                    }
                    --gdzieN;
                    ++przejsc;
                }
                if(edfOnOff){
                    wykonywany=czyJestProcRT(gdzieN);
                    if(wykonywany==null){
                        for (int k=0;k<listaOczekujacych.size();k++) {
                            if (listaOczekujacych.get(k).getNumerCylindru() == gdzieN) {
                                wykonywany = listaOczekujacych.remove(k);
                                skonczoneProcesy.add(wykonywany);
                            }
                        }
                    }
                }
                else if(!edfOnOff){
                    for (int k=0;k<listaOczekujacych.size();k++) {
                        if (listaOczekujacych.get(k).getNumerCylindru() == gdzieN) {
                            wykonywany = listaOczekujacych.remove(k);
                            skonczoneProcesy.add(wykonywany);
                        }
                    }
                }//else if !edf
            }//if flag
            if((listaOczekujacych.isEmpty() && listaProcPrior.isEmpty())){
                koniec=true;
            }
            if (listaOczekujacych.isEmpty() && !listaProcPrior.isEmpty()){
                for (int k=0;k<listaProcPrior.size();k++){
                    if(listaProcPrior.get(k).czyWystapilPr()==false){
                        listaNieWyk.add(listaProcPrior.remove(k));
                    }
                }
            }
        }//while
        if(!edfOnOff){
        System.out.println("SCAN: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);}
        else {
            System.out.println("SCAN z EDF: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);
            System.out.println("Lista nie wykonanych: "+listaNieWyk.size());
            for(Process p:listaNieWyk){
                System.out.print(" [ id: "+p.getId()+", numer cylindru: "+p.getNumerCylindru()+" ] ");
            }
            System.out.println();
        }
       }

    public Process czyJestProcRT(int nrIglicy){
        Process proces=null;
        for(int i=0;i<listaProcPrior.size();i++){
            if((listaProcPrior.get(i).getNumerCylindru()==nrIglicy) && listaProcPrior.get(i).czyWystapilPr()){
                proces=listaProcPrior.remove(i);
                skonczoneProcesy.add(proces);
            }
        }
        return proces;
    }

    @Override
    public String toString() {
        String st="";
        for(Process e:skonczoneProcesy){
            st+="[ id: "+e.getId()+", numer cylindru: "+e.getNumerCylindru()+" ] ";
        }
        return st+"\n";
    }
}
