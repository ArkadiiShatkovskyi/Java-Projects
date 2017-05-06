package com.company;


// Created by user on 2015-01-14.

public class Student extends Osoba
{
    int semestr;
    double srednia;
    Student[] st=new Student[100];
    int i=0;
    Student(String nazwisko,String imie,int wiek,int semestr,double srednia){
        super(nazwisko,imie,wiek);
        this.semestr=semestr;
        this.srednia=srednia;
        //Student stud=new Student(nazwisko,imie,wiek,semestr,srednia);
    }

    void wpiszStud(String nazwisko,String imie,int wiek,int semestr,double srednia){
        Student st1=new Student(nazwisko,imie,wiek,semestr,srednia);
        st[i]=st1; i++;
    }

    void WyswStud(double sred){
        for(int j=0;j<st.length;j++){
            if(st[j]!=null){
                if(st[j].getSred()>=sred){
                    System.out.println("Numer: "+j+",nazwisko: "+st[j].getNaz()+", imie: "+st[j].getIm()+", semestr: "+st[j].getSem()+", srednia: "+st[j].getSred()+";");
                }}
        }
    }

    double getSred(){
        return srednia;
    }

    String getNaz(){
        return nazwisko;
    }

    String getIm(){
        return imie;
    }
    int getWie(){
        return wiek;
    }

    int getSem(){
        return semestr;
    }
}
