package com.company.listy;

import com.company.tests.Car;

public class Zadanie2 implements List {

    private int size_array;
    private Element last;//previous element
    private Element first;


    public Zadanie2(){
        clear();
    }

    public void setLast(Element ob){
        last =ob;
    }

    public Element getLast(){
        return last;
    }

    public void setFirst(Element ob){
        first=ob;
    }

    public Element getFirst(){
        return first;
    }

    public void sorting(){
        Element first_sort=null;
        Element previous_sort=null;
        Element[] table=new Element[size()+1];
        int index=0;
        for(int i=0;i<600;i+=25){
            Element element=getFirst();
            while (element!=null) {//while
              Car car_element=(Car)element.getValue();
              if(car_element.equals(i)){//if1
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
                first_sort.setPrevious(null);
                first_sort.setNext(null);
                previous_sort=first_sort;
            }
            else{
                Element next=table[j];
                previous_sort.setNext(next);
                next.setPrevious(previous_sort);
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
            el.setNext(null);
            el.setPrevious(null);
            setFirst(el);
            setLast(el);
            ++size_array;
        }
        else{
            Element el1=new Element(value);
            el1.setPrevious(getLast());
            el1.setNext(null);
            getLast().setNext(el1);
            setLast(el1);
            ++size_array;
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

    @Override
    public boolean delete(Object value) {
        boolean flag=false;
        if(getFirst()!=null&&getFirst().getValue()==value){
                if(getFirst().getNext()!=null){
                Element elem=getFirst().getNext();
                elem.setPrevious(null);
                setFirst(elem);
                flag=true;
                --size_array;}
                else{
                    setFirst(null);
                    setLast(null);
                    flag=true;
                    --size_array;
                }
            }
            else{
                Element element=getFirst();
                while(element!=null){
                    if(element.getValue()==value && element.getNext()==null){
                        element.getPrevious().setNext(null);
                        setLast(element.getPrevious());
                        --size_array;
                        flag=true;
                    }
                    else if(element.getValue()==value){
                        element.getPrevious().setNext(element.getNext());
                        element.getNext().setPrevious(element.getPrevious());
                        --size_array;
                        flag=true;
                    }
                    element=element.getNext();
                }
            }
        return flag;
    }

    @Override
    public Object delete(int index) {
        Object del=null;
        if(index<0||index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1||getFirst()==null){
            System.out.println("Lista pusta!");
        }
        else{
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size()&&el.getValue()!=null&&del==null){
                if(rozmiar==index){
                    if(el.getNext()!=null&&el.getPrevious()!=null){
                        del=el.getValue();
                        el.getNext().setPrevious(el.getPrevious());
                        el.getPrevious().setNext(el.getNext());
                    }
                    else if(el.getPrevious()==null&&el.getNext()!=null){
                        del=el.getValue();
                        el.getNext().setPrevious(null);
                        setFirst(el.getNext());
                    }
                    else if(el.getNext()==null&&el.getPrevious()!=null){
                        del=el.getValue();
                        el.getPrevious().setNext(null);
                        setLast(el.getPrevious());
                    }
                    else{
                        del=el.getValue();
                        setFirst(null);
                    }
                }
                el=el.getNext();
                rozmiar++;
            }
        }
        --size_array;
        return del;
    }

    @Override
    public void clear() {
        setFirst(null);
        setLast(null);
        size_array=-1;
    }

    @Override
    public Object set(int index, Object value) {
        Object ob=null;
        if(index<0||index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size() && el!=null && ob==null){
                if(rozmiar==index){
                    ob=el.getValue();
                    el.setValue(value);
                }
                el=el.getNext();
                rozmiar++;
            }
        }
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
            while(rozmiar<=size() && el.getValue()!=null && ob==null){
                if(rozmiar==index){
                    ob=el.getValue();
                }
                el=el.getNext();
                rozmiar++;
            }
        }
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
        while(rozmiar<=size() && indeks==-1){
            if(el.getValue()==value){
                indeks=rozmiar;
            }
            el=el.getNext();
            rozmiar++;
        }
        return indeks;
    }

    @Override
    public boolean contains(Object value) {
        boolean flag=false;
        if (getFirst() != null) {
            Element ob=getFirst();
            while (ob!=null){
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
        return new ValueIterator(getFirst(),getLast());
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
            st+="lista zawiera jeden element: [ Firma: "+car.getFirm()+", silnik: "+car.getSilnik()+", model: "+car.getModel()+"]";
        }
        else{
            Element el=getFirst();
            while (el!=null){
                Car car=(Car)el.getValue();
                st+="[ Firma: "+car.getFirm()+", silnik: "+car.getSilnik()+", rok: "+car.getModel()+"]\n";
                el=el.getNext();
            }
        }
        return st;
    }
}

