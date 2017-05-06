package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    StreamTokenizer st;

    public static void main(String[] args) throws IOException{
       Main mn=new Main();
        //mn.generWPlik();
        //mn.generWPlikRT();

        FCFS fcfs=new FCFS(mn.dane(),mn.daneRealTime(),200);
        fcfs.algorutm(50,false);
        System.out.println(fcfs.toString());
        FCFS fcfs1=new FCFS(mn.dane(),mn.daneRealTime(),200);
        fcfs1.algorutm(50,true);
        System.out.println(fcfs1.toString());

        SSTF sstf=new SSTF(mn.dane(),mn.daneRealTime(),200);
        sstf.algorutm(50,false);
        System.out.println(sstf.toString());
        SSTF sstf1=new SSTF(mn.dane(),mn.daneRealTime(),200);
        sstf1.algorutm(50,true);
        System.out.println(sstf1.toString());


        SCAN scan=new SCAN(mn.dane(),mn.daneRealTime(),200);
        scan.algorutm(50,false);
        System.out.println(scan.toString());
        SCAN scan1=new SCAN(mn.dane(),mn.daneRealTime(),200);
        scan1.algorutm(50,true);
        System.out.println(scan1.toString());

        C_SCAN c_scan=new C_SCAN(mn.dane(),mn.daneRealTime(),200);
        c_scan.algorutm(50,false);
        System.out.println(c_scan.toString());
        C_SCAN c_scan1=new C_SCAN(mn.dane(),mn.daneRealTime(),200);
        c_scan1.algorutm(50,true);
        System.out.println(c_scan1.toString());

    }

    public LinkedList dane(){
        LinkedList<Process> list=new LinkedList<Process>();
        list.add(new Process(1,0,95));
        list.add(new Process(2,0,180));
        list.add(new Process(3,0,34));
        list.add(new Process(4,0,119));
        list.add(new Process(5,0,11));
        list.add(new Process(6,0,123));
        list.add(new Process(7,0,62));
        list.add(new Process(8,0,64));
        return list;
    }

    public LinkedList daneRealTime(){
        LinkedList<Process> list=new LinkedList<Process>();
        list.add(new Process(9,2,23));
        list.add(new Process(10,9,170));
        list.add(new Process(11,80,64));
        list.add(new Process(12,5,5));
        list.add(new Process(13,70,29));
        list.add(new Process(14,30,100));
        list.add(new Process(15,50,70));
        list.add(new Process(16,78,199));
        return list;
    }

    public LinkedList czytaj() throws IOException {
        LinkedList list =new LinkedList();
        ArrayList array2=new ArrayList();
        String file_path ="D:\\programmer\\ItelliJ_IDEA_work_folder\\pliki\\dane_zadanie2.txt";
        try {
            st=new StreamTokenizer(new FileReader(file_path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int index=0;
        while (st.nextToken()!=st.TT_EOF){
            if(st.ttype==st.TT_NUMBER){
                int in= (int)st.nval;
                if(index==2){
                    array2.add(index,in);
                    Process tp=new Process(array2);
                    list.add(tp);
                    index=0;
                }
                else{
                    array2.add(index,in);
                    index++;
                }
            }
        }
        return list;
    }

    public void generWPlik() throws IOException{
        String file_path ="D:\\programmer\\ItelliJ_IDEA_work_folder\\pliki\\dane_zadanie2.txt";
        FileWriter fw=new FileWriter(file_path);
        String st="";
        for(int i=1;i<=10;i++){
            st=i+","+0+","+((int)(Math.random()*200))+";\n";
            fw.write(st);
        }
        fw.close();
    }

    public void generWPlikRT() throws IOException{
        String file_path ="D:\\programmer\\ItelliJ_IDEA_work_folder\\pliki\\dane_zadanie2_ProcRT.txt";
        FileWriter fw=new FileWriter(file_path);
        String st="";
        for(int i=10;i<=20;i++){
            st=i+","+((int)(Math.random()*200))+","+((int)(Math.random()*200))+";\n";
            fw.write(st);
        }
        fw.close();
    }
}
