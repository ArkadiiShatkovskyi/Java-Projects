package com.company.listy;

import com.company.tests.Car;

public class Zadanie3 implements List {

    private int size_array;
    private Element first;

    public void setFirst(Element ob){
        first=ob;
    }

    public Element getFirst(){
        return first;
    }

    public Zadanie3(){
        clear();
    }

    public void sorting(){
        Element first_sort=null;
        Element previous_sort=null;
        Element[] table=new Element[size()+1];
        int index=0;
        for(int i=0;i<100;i++){
            Element element=getFirst();
            while (element!=null) {//while
                if(element.getNumOfUse()==i){//if1
                    table[index]=element;
                    index++;
                }//if1
                element = element.getNext();
            }//while
        }

        for(int j=0;j<table.length;j++){
            if(table[j]!=null){
                if(j==0){
                    first_sort=table[j];
                    first_sort.setNext(null);
                    previous_sort=first_sort;
                }
                else{
                    Element next=table[j];
                    previous_sort.setNext(next);
                    next.setNext(null);
                    previous_sort=previous_sort.getNext();
                }
            }
            else
                continue;
        }
        setFirst(first_sort);
    }

    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index==-1) {
            Element el =new Element(value);
            el.setNum(el.getNumOfUse()+1);
            el.setNext(null);
            setFirst(el);
            ++size_array;
        }
        else{
            Element element=getFirst();
            boolean flag=false;
            while (!flag&&element!=null){
                element.setNum(element.getNumOfUse()+1);
                if(element.getNext()==null){
                    Element el=new Element(value);
                   el.setNum(el.getNumOfUse()+1);
                    element.setNext(el);
                    ++size_array;
                    flag=true;
                }
                element=element.getNext();
            }
        }
    }


    @Override
    public void add(Object value) {
        if(size()>=1){
            insert(size(), value);
            sorting();
        }
        else
            insert(size(), value);
    }

    public boolean delete(Object value) {
        boolean flag=false;
        if(getFirst()!=null && getFirst().getValue()==value){
            if(getFirst().getNext()!=null){
                Element elem=getFirst().getNext();
                elem.setPrevious(null);
                setFirst(elem);
                flag=true;
                --size_array;}
            else{
                setFirst(null);
                flag=true;
                --size_array;
            }
        }
        else{
            Element element=getFirst();
            Element prev=null;
            while(element!=null){
                if(element.getValue()==value && element.getNext()==null){
                    prev.setNext(null);
                    --size_array;
                    flag=true;
                }
                else if(element.getValue()==value){
                    prev.setNext(element.getNext());
                    --size_array;
                    flag=true;
                }
                prev=element;
                element.setNum(element.getNumOfUse()+1);
                element=element.getNext();
            }
        }
        return flag;
    }

    @Override
    public Object delete(int index) {
        Object del=null;
        Element previous=null;
        if(index<0||index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1||getFirst()==null){
            System.out.println("Lista pusta!");
        }
        else{
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size()&&el!=null&&del==null){
                if(rozmiar==0&&rozmiar==index){
                    setFirst(el.getNext());
                    --size_array;
                }
                else if(rozmiar==index&&el.getNext()==null){
                    previous.setNext(null);
                    --size_array;
                }
                else if(rozmiar==index){
                    del=el.getValue();
                    previous.setNext(el.getNext());
                    --size_array;
                }
                previous=el;
                el.setNum(el.getNumOfUse()+1);
                el=el.getNext();
                rozmiar++;
            }
        }
        return del;
    }

    @Override
    public void clear() {
        setFirst(null);
        size_array=-1;
    }

    @Override
    public Object set(int index, Object value) {
        Object ob=null;
        if(index<0&&index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size() && el!=null&&ob==null){
                if(rozmiar==index){
                    ob=el.getValue();
                    el.setNum(el.getNumOfUse()+1);
                    el.setValue(value);
                }
                el.setNum(el.getNumOfUse()+1);
                el=el.getNext();
                rozmiar++;
            }
        }
        sorting();
        return ob;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        Object ob=null;
        if(index<0 && index>size()){
            System.out.println("Nie ma elementu o takim indeksie!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size()&&el!=null&&ob==null){
                el.setNum(el.getNumOfUse()+1);
                if(rozmiar==index){
                    ob=el.getValue();
                    el.setNum(el.getNumOfUse()+1);
                }
                el=el.getNext();
                rozmiar++;
            }
        }
        sorting();
        return ob;
    }

    @Override
    public int indexOf(Object value) {
        int indeks=-1;
        if(size()==-1){
            System.out.println("Lista pusta!");
        }
        int rozmiar=0;
        Element el=getFirst();
        while(rozmiar<=size()&&indeks==-1){
            el.setNum(el.getNumOfUse()+1);
            if(el.getValue()==value) {
                indeks = rozmiar;
            }
            el=el.getNext();
            rozmiar++;
        }
        sorting();
        return indeks;
    }

    @Override
    public boolean contains(Object value) {
        boolean flag=false;
        if (getFirst() != null) {
            Element ob=getFirst();
            while (ob!=null){
                ob.setNum(ob.getNumOfUse()+1);
                if(ob.getValue()==value)
                    flag=true;
                ob=ob.getNext();
            }
        }
        return flag;
    }

    @Override
    public int size() {
        return size_array;
    }

    @Override
    public boolean isEmpty() {
        return size_array==-1;
    }

    @Override
    public Iterator iterator() {
        return new ValueIterator(getFirst(),null);
    }

    @Override
    public String toString() {
        String st="";
        st+="\n";
        if(getFirst()==null){
            st+="lista pusta!";
        }
        else if(getFirst()!=null&&getFirst().getNext()==null){
            Car car=(Car)getFirst().getValue();
            getFirst().setNum(getFirst().getNumOfUse()+1);
            st+="lista zawiera jeden element: [ Firma: "+car.getFirm()+", silnik: "+car.getSilnik()+", rok: "+car.getModel()+"]";
        }
        else{
            Element el=getFirst();
            while (el!=null){
                el.setNum(el.getNumOfUse()+1);
                Car car=(Car)el.getValue();
                st+="[ Wykorzystano element: "+el.getNumOfUse()+",  Firma: "+car.getFirm()+", silnik: "+car.getSilnik()+", model: "+car.getModel()+"]\n";
                el=el.getNext();
            }
        }
        return st;
    }
}
