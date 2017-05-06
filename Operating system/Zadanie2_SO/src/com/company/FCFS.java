package com.company;
import java.util.LinkedList;

public class FCFS {

    private int[] cylinryDysku;
    private LinkedList<Process> listaOczekujacych=new LinkedList<Process>();
    private LinkedList<Process> skonczoneProcesy=new LinkedList<Process>();
    private LinkedList<Process> listaProcPrior=new LinkedList<Process>();

    public FCFS(LinkedList listOczek,LinkedList listaProcPrior,int rozmiar){
        listaOczekujacych=listOczek;
        this.listaProcPrior=listaProcPrior;
        cylinryDysku=new int[rozmiar];
    }

    public void algorutm(int gdzieGlowica,boolean edfOnOff){
        int przejsc=0;
        int gdzieN=gdzieGlowica;
        boolean flag=false;
        boolean koniec=false;
        LinkedList<Process> listaNieWyk=new LinkedList<Process>();
        while((!edfOnOff && !listaOczekujacych.isEmpty()) || (!koniec&&edfOnOff)){

            Process wykonywany=null;
            if(edfOnOff) {
                for(Process process:listaProcPrior){
                    process.sprawdz(gdzieN);
                }
                wykonywany=czyJestProcRT(gdzieN);
                if (wykonywany == null && !listaOczekujacych.isEmpty()) {
                    wykonywany = listaOczekujacych.removeFirst();
                    skonczoneProcesy.add(wykonywany);
                }
            }
            else if (!edfOnOff){
                wykonywany = listaOczekujacych.removeFirst();
                skonczoneProcesy.add(wykonywany);
            }
           if(wykonywany!=null){
            if(gdzieN<=wykonywany.getNumerCylindru()){
                for(int i=gdzieN;i<=wykonywany.getNumerCylindru();i++){
                    for(Process process:listaProcPrior){
                        process.sprawdz(i);
                    }
                    if(wykonywany.getNumerCylindru()==i){
                        gdzieN=i;
                        flag=true;
                    }
                    if (!flag){++przejsc;}
                }
                flag=false;
            }
            else if(gdzieN>wykonywany.getNumerCylindru()){
                for(int i=gdzieN;i>=wykonywany.getNumerCylindru();i--){
                    for(Process process:listaProcPrior){
                        process.sprawdz(i);
                    }
                    if(wykonywany.getNumerCylindru()==i){
                        gdzieN=i;
                        flag=true;
                    }
                    if(!flag){++przejsc;}
                }
                flag=false;
            }
        }
            if((listaOczekujacych.isEmpty()&&listaProcPrior.isEmpty())){
                koniec=true;
            }
            if (listaOczekujacych.isEmpty() && !listaProcPrior.isEmpty()){
                for (int k=0;k<listaProcPrior.size();k++){
                    if(listaProcPrior.get(k).czyWystapilPr()==false){
                        listaNieWyk.add(listaProcPrior.remove(k));
                    }
                }
            }
        }
        if(!edfOnOff){
        System.out.println("FCFS: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);}
        else {
            System.out.println("FCFS z EDF: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);
            System.out.println("Lista nie wykonanych: "+listaNieWyk.size());
            for(Process p:listaNieWyk){
                System.out.print(" [ id: "+p.getId()+", numer cylindru: "+p.getNumerCylindru()+" ] ");
            }
            System.out.println();
        }
    }

    public Process czyJestProcRT(int nrIglicy) {
        Process proces = null;
        for (int i = 0; i < listaProcPrior.size(); i++) {
            if (listaProcPrior.get(i).czyWystapilPr()) {
                proces = listaProcPrior.remove(i);
                skonczoneProcesy.add(proces);
            }
        }
        return proces;
    }

    @Override
    public String toString() {
        System.out.println("Wykonane procesy: ");
        String st="";
        for(Process e:skonczoneProcesy){
            st+="[ id: "+e.getId()+", numer cylindru: "+e.getNumerCylindru()+" ] ";
        }
        return st+"\n";
    }
}


