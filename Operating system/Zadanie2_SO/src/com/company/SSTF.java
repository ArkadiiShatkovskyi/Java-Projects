package com.company;

import java.util.LinkedList;

public class SSTF {

    private int[] cylinryDysku;
    private LinkedList<Process> listaOczekujacych=new LinkedList<Process>();
    private LinkedList<Process> skonczoneProcesy=new LinkedList<Process>();
    private LinkedList<Process> listaProcPrior=new LinkedList<Process>();

    public SSTF(LinkedList list,LinkedList listaProcPrior,int rozmiar){
        listaOczekujacych=list;
        this.listaProcPrior=listaProcPrior;
        cylinryDysku=new int[rozmiar];
    }

    public void algorutm(int gdzieGlowica,boolean edfOnOff){
        int przejsc=0;
        int gdzieN=gdzieGlowica;
        int roznica=0;
        boolean flag=false;
        boolean koniec=false;
        LinkedList<Process> listaNieWyk=new LinkedList<Process>();

        while((!edfOnOff && !listaOczekujacych.isEmpty()) || (!koniec && edfOnOff)){
            Process wykonywany=null;

            if(!edfOnOff){
            while (wykonywany==null&&!flag){
                for(int z=0;z<listaOczekujacych.size();z++){
                    if(Math.abs(listaOczekujacych.get(z).getNumerCylindru() - gdzieN)==roznica){
                        wykonywany=listaOczekujacych.remove(z);
                        skonczoneProcesy.add(wykonywany);
                        gdzieN=wykonywany.getNumerCylindru();
                        roznica=0;
                        flag=true;
                    }
                }
                if(!flag){
                    ++przejsc;
                    ++roznica;
                }
            }
            flag=false;
           }//if !edf
            else if(edfOnOff){
                if(czyJestProcRT()){
                while (wykonywany==null&&!flag) {
                    for (int i = 0; i < listaProcPrior.size(); i++) {
                        if (listaProcPrior.get(i).czyWystapilPr()) {
                            if (Math.abs(listaProcPrior.get(i).getNumerCylindru() - gdzieN) == roznica) {
                                wykonywany = listaProcPrior.remove(i);
                                if(gdzieN>=wykonywany.getNumerCylindru()){
                                    for(int j=gdzieN;j>=wykonywany.getNumerCylindru();j--){
                                        for(Process process:listaProcPrior){
                                            process.sprawdz(j);
                                        }
                                    }
                                }
                                else if(gdzieN<wykonywany.getNumerCylindru()){
                                    for(int j=gdzieN;j<=wykonywany.getNumerCylindru();j++){
                                        for(Process process:listaProcPrior){
                                            process.sprawdz(j);
                                        }
                                    }
                                }
                                gdzieN=wykonywany.getNumerCylindru();
                                skonczoneProcesy.add(wykonywany);
                                roznica=0;
                                flag=true;
                            }
                        }
                    }
                    if (!flag) {
                        ++przejsc;
                        ++roznica;
                    }
                }
                    flag=false;
                }
                else{
                while (wykonywany==null&&!flag){
                    for(int z=0;z<listaOczekujacych.size();z++){
                        if(Math.abs(listaOczekujacych.get(z).getNumerCylindru() - gdzieN)==roznica){
                            wykonywany=listaOczekujacych.remove(z);
                            skonczoneProcesy.add(wykonywany);
                            if(gdzieN>=wykonywany.getNumerCylindru()){
                                for(int j=gdzieN;j>=wykonywany.getNumerCylindru();j--){
                                    for(Process process:listaProcPrior){
                                        process.sprawdz(j);
                                    }
                                }
                            }
                            else if(gdzieN<wykonywany.getNumerCylindru()){
                                for(int j=gdzieN;j<=wykonywany.getNumerCylindru();j++){
                                    for(Process process:listaProcPrior){
                                        process.sprawdz(j);
                                    }
                                }
                            }
                            gdzieN=wykonywany.getNumerCylindru();
                            roznica=0;
                            flag=true;
                        }
                    }
                    if(!flag){
                        ++roznica;
                        ++przejsc;
                    }
                    if(listaOczekujacych.isEmpty()){flag=true;}
                }
                flag=false;
            }
                }// else if edf
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
            System.out.println("SSTF: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);}
        else {
            System.out.println("SSTF z EDF: \n Rozmiar:"+skonczoneProcesy.size()+", Poczatek: "+gdzieGlowica+"\n Bylo przejsc: "+przejsc);
            System.out.println("Lista nie wykonanych: "+listaNieWyk.size());
            for(Process p:listaNieWyk){
                System.out.print(" [ id: "+p.getId()+", numer cylindru: "+p.getNumerCylindru()+" ] ");
            }
            System.out.println();
        }
    }

    public boolean czyJestProcRT(){
        boolean wynik=false;
         for(int i=0;i<listaProcPrior.size();i++){
            if(listaProcPrior.get(i).czyWystapilPr()){
                wynik=true;
           }
          }
        return wynik;
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
