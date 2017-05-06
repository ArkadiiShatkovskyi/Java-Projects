package com.company.Test;

import com.company.Tasks.*;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Main mn =new Main();
        int procesow=10;
        int ramek=50;
        int minRamek=3;
        int minZgloszen=10;
        int maxZgloszen=200;
        int zakresLiczb=100;
        int powtarzaj =5;

        GenerList generList=new GenerList();
        LinkedList<LRU> list=generList.createProc(procesow,ramek,minRamek,minZgloszen,maxZgloszen,zakresLiczb,false);

        Rowny rowny=new Rowny();
        rowny.algorytm(procesow,ramek,(LinkedList<LRU>)list.clone());
        System.out.println(rowny.toString());

        Proporcjonalny proporcjonalny=new Proporcjonalny();
        proporcjonalny.algorytm(procesow,ramek,minRamek,(LinkedList<LRU>)list.clone());
        System.out.println(proporcjonalny.toString());

        System.out.println("\nAlgorytm sterowania bladami stron:");
        SterowanieCBS sterowanieCBS=new SterowanieCBS();
        sterowanieCBS.algorytm(procesow,ramek,minRamek,powtarzaj,(LinkedList<LRU>) list.clone());
        System.out.println(sterowanieCBS.toString());
    }
}
