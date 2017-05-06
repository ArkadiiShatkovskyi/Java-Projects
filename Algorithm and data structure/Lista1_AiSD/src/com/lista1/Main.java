package com.lista1;


import com.iterators.*;

public class Main {

    private Integer[] table;

    public static void main(String[] args){
        Main mn=new Main();
        mn.table=new Integer[30];
        int j=1;
        for(int i=0;i<mn.table.length;i++){
            mn.table[i]=j;
            System.out.print("["+mn.table[i]+"]");
            j++;
        }
        System.out.println();

        IterOnTable zad1=new IterOnTable(mn.table,100);
        System.out.println("Zadanie 1: ");
        System.out.println(zad1.toString());
        IterFiltr zad2=new IterFiltr(new IterOnTable(mn.table,100),new Predicate_implement());
        System.out.println("Zadanie 2: ");
        System.out.println(zad2.toString());
        IterForZad3 zad3=new IterForZad3(new IterOnTable(mn.table,100),new Predicate_implement(),new Function_implement());
        System.out.println("Zadanie 3: ");
        System.out.println(zad3.toString());
        IterForZad4 zad4=new IterForZad4(mn.table,100,new Predicate_implement());
        System.out.println("Zadanie 4: ");
        System.out.println(zad4.toString());
    }
}
