package com.company.listy;

import com.company.tests.Car;

public class Zadanie1 implements List {

    private int size_array;
    private Element first;

    public Zadanie1(){
        clear();
    }

    public void setFirst(Element ob){
        first=ob;
    }

    public Element getFirst(){
        return first;
    }

    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(index==-1) {
            Element el =new Element(value);
            el.setNext(null);
            setFirst(el);
            ++size_array;
        }
        else{
                Element element=getFirst();
                boolean flag=false;
                while (!flag){
                    if(element.getNext()==null){
                        Element el=new Element(value);
                        element.setNext(el);
                        ++size_array;
                        flag=true;
                    }
                    element=element.getNext();
                }
            }
        }


    public void insert(int index,Object value,java.util.List list){  //wstawienie listy po elemetu o indeksie index (Zadanie 4: 1 metoda)
        Car[] table=new Car[size()+list.size()+1];
        if(index<0&&value==null||index>size()&&value==null){
            System.out.println("Indeks jest niepoprawny!");
        }
        else{
            Element elements=getFirst();
            boolean flag=false;
            int indexList=0;
            for(int i=0;i<table.length;i++){
                if(flag){
                    table[i]=(Car)list.get(indexList);
                    ++indexList;
                    flag=indexList<list.size()?true:false;
                    }
                else if(!flag){
                    if (value!=null&&elements.getValue()!=null&&elements.getValue()==value) {
                        flag=true;
                    }
                     table[i]=(Car)elements.getValue();
                     elements=elements.getNext();
                    if(i==index)
                        flag=true;
                }
            }

            Element first_element=null;
            Element previous_element=null;

            size_array=-1;
            for(int k=0;k<table.length;k++){
                Element addedElem=new Element(table[k]);
                if(k==0){
                    first_element=addedElem;
                    previous_element=addedElem;
                    addedElem.setNext(null);
                    ++size_array;
                }
                else{
                    previous_element.setNext(addedElem);
                    previous_element=addedElem;
                    ++size_array;
                }
            }
            setFirst(first_element);
            }
        }

    public  void  add(Object value,java.util.List list){
        insert(-1,value,list);
    }

    public void add(java.util.List list){
        insert(size(),null,list);
    }

    public void add(int index,java.util.List list){
        insert(index,null,list);
    }

    @Override
    public void add(Object value) {
         insert(size(),value);
    }

    @Override
    public boolean delete(Object value) {
        boolean flag=false;
        if(getFirst()!=null&&getFirst().getValue()==value) {
            if (getFirst().getNext() != null) {
                Element elem = getFirst().getNext();
                setFirst(elem);
                flag = true;
                --size_array;
            } else {
                setFirst(null);
                flag = true;
                --size_array;
            }
           }
            else{
            Element element=getFirst();
                Element prev=null;
            while(element!=null){
                if(element.getValue()==value){
                    if(element.getNext()==null){
                        prev.setNext(null);}
                    prev.setNext(element.getNext());
                    --size_array;
                    flag=true;
                }
                prev=element;
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
        if(index<0||index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=0;
            while(rozmiar<=size()&&el!=null&&ob==null){
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
        if(index<0 || index>size()){
            System.out.println("Nie ma elementu o takim indeksie!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=size();
            while(rozmiar!=-1&&el!=null&&ob==null){
                if(rozmiar==index){
                    ob=el;
                }
                el=el.getNext();
                rozmiar--;
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
        while(rozmiar<=size()&&indeks==-1){
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
        if (getFirst() != null&&!flag) {
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
