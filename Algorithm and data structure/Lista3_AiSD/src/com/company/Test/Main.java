package com.company.Test;

import com.company.InterfacesAndImplements.ListLIFO;
import com.company.InterfacesAndImplements.ListSinking;
import com.company.InterfacesAndImplements.ListStack;
import com.company.InterfacesAndImplements.Zadanie1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 1: ");
        Zadanie1 zad1=new Zadanie1();
        System.out.println("\n -----------------------------------");

        //Zadanie2
        System.out.println("Zadanie 2: ");
        ListStack list=new ListStack();
        for(int i=0;i<25;i++)
        list.push((int)(Math.random()*50));
        System.out.println("Wynegerowana lista: "+list.toString());
        System.out.println("pierwszy element: " + list.shift());
        list.unshift(170);
        System.out.println(list.toString());
        System.out.println("\n -----------------------------------");

        //Zadanie 3
        System.out.println("Zadanie 3: ");
        ListSinking listSinking=new ListSinking(17);
        for(int k=0;k<17;k++)
            listSinking.push((int)(Math.random()*50));
        System.out.println(listSinking.toString()+"\n"+(int)(listSinking.size()+1));
        listSinking.push(170);
        listSinking.push(90);
        System.out.println(listSinking.toString()+"\n"+(int)(listSinking.size()+1));
        System.out.println("\n -----------------------------------");

        //Zadanie 4
        System.out.println("Zadanie 4: ");
        ListLIFO listLIFO =new ListLIFO(17);
        for(int i=0;i<17;i++){
            listLIFO.push((int)(Math.random()*50));}
        System.out.println(listLIFO.toString());
        listLIFO.push(17);
        System.out.println("dodajemy element 17."+listLIFO.toString()+"\n Otrzymujemy element: "+listLIFO.pop()+";"+"\n"+listLIFO.toString());
    }
}
