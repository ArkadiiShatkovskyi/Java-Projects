package com.company.tests;

import com.company.listy.Zadanie1;
import com.company.listy.Zadanie2;
import com.company.listy.Zadanie3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Car car1=new Car("Honda",300,"CV-R");
        Car car2=new Car("Mazda",200,"RX-7");
        Car car3=new Car("BMW",500,"X5");
        Car car4=new Car("Toyota",250,"Supra");
        Car car5=new Car("Acura",400,"ASX");
        Car car6=new Car("Lada",150,"Kalina");
        Car car7=new Car("Fiat",300,"Punto");
        Car car8=new Car("Volvo",400,"V30");
        Car car9=new Car("Audi",550,"A8");
        Car car10=new Car("Honda",450,"S200");
        Car car11=new Car("BMW",600,"320i");

        ArrayList<Car> arrayList=new ArrayList<Car>();
        arrayList.add(car5);
        arrayList.add(car6);
        arrayList.add(car7);
        ArrayList<Car> arrayList2=new ArrayList<Car>();
        arrayList2.add(car8);
        ArrayList<Car> arrayList13=new ArrayList<Car>();
        arrayList13.add(car9);
        arrayList13.add(car10);

        Zadanie1 zad1=new Zadanie1();
        zad1.add(car1);
        zad1.add(car2);
        zad1.add(car3);
        zad1.add(car4);
        System.out.println("Zadanie 1: rozmiar: " + ((int) (zad1.size())));
        System.out.println(zad1.toString() + "\n --------------------------------------");
        zad1.add(1, arrayList);
        System.out.println("Zadanie 4: metoda 1: rozmiar: "+((int)(zad1.size())));
        System.out.println(zad1.toString()+"\n --------------------------------------");
        zad1.add(car5,arrayList2);
        System.out.println("Zadanie 4: metoda 2: rozmiar: "+((int)(zad1.size())));
        System.out.println(zad1.toString()+"\n --------------------------------------");
        zad1.add(arrayList13);
        System.out.println("Zadanie 4: metoda 3: rozmiar: "+((int)(zad1.size())));
        System.out.println(zad1.toString()+"\n --------------------------------------");

        Zadanie2 zad2=new Zadanie2();
        zad2.add(car1);
        zad2.add(car2);
        zad2.add(car3);
        zad2.add(car4);
        System.out.println("Zadanie 2: rozmiar: " + ((int) (zad2.size())));
        System.out.println(zad2.toString()+"\n --------------------------------------");

        Zadanie3 zad3=new Zadanie3();
        zad3.add(car1);
        zad3.add(car2);
        zad3.add(car3);
        zad3.add(car4);
        System.out.println("Zadanie 3: rozmiar: " + ((int) (zad3.size())));
        System.out.println(zad3.toString());
    }
}
