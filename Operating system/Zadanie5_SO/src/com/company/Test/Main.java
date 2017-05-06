package com.company.Test;

import com.company.Zadania.ClasyPomocnicze.ClassPom;
import com.company.Zadania.ClasyPomocnicze.Proces;
import com.company.Zadania.Zadanie_1.Zadanie1;
import com.company.Zadania.Zadanie_2.Zadanie2;
import com.company.Zadania.Zadanie_3.Zadanie3;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int prog=50;
        int minimalnyProg=5;
        int prob=4;
        int procesow=15;
        //zadan od 50 do 100

        ClassPom cp=new ClassPom();
        LinkedList<Proces> procesy=cp.stworzProc(procesow);
        LinkedList<int[]> zadanie=cp.stworzZadan();

        Zadanie1 zad1 =new Zadanie1(prog,prob,procesow,(LinkedList<Proces>)procesy.clone(),(LinkedList<int[]>)zadanie.clone());
        zad1.algorytm();
        System.out.println(zad1.toString());

        Zadanie2 zad2=new Zadanie2(prog,procesow,(LinkedList<Proces>)procesy.clone(),(LinkedList<int[]>)zadanie.clone());
        zad2.algorytm();
        System.out.println(zad2.toString());

        Zadanie3 zad3=new Zadanie3(prog,minimalnyProg,procesow,(LinkedList<Proces>)procesy.clone(),(LinkedList<int[]>)zadanie.clone());
        zad3.algorytm();
        System.out.println(zad3.toString());
    }
}
