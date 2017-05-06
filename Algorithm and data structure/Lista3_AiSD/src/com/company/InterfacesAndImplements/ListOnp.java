package com.company.InterfacesAndImplements;


public class ListOnp implements List {

    private int size_array;
    private Element last;//previous element
    private Element first;


    public ListOnp(){
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

    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if(size()==-1) {
            Element el =new Element(value);
            el.setNext(null);
            el.setPrevious(null);
            setFirst(el);
            setLast(el);
            ++size_array;
        }
        else{
            if(index==0){
                Element element=new Element(value);
                Element fr=getFirst();
                element.setPrevious(null);
                element.setNext(fr);
                fr.setPrevious(element);
                setFirst(element);
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
    }

    @Override
    public void add(Object value) {
      insert(size(), value);
    }

    @Override
    public boolean delete(Object value) {
        boolean flag=false;
        if(getFirst()!=null){
            if(getFirst().getValue().equals(value) && getFirst().getNext()!=null){
                Element elem=getFirst().getNext();
                elem.setPrevious(null);
                setFirst(elem);
            }
            else if(getFirst().getNext()==null){
                System.out.println("Nie ma elementu o takiej wartosci!");
            }
            else{
                Element element=getFirst();
                while(element.getValue()!=null){
                    if(element.getValue().equals(value)){
                        Element nastepny= element.getNext();
                        element.setNext(nastepny);
                        nastepny.setPrevious(element);
                        --size_array;
                        flag=true;
                    }
                    element=element.getNext();
                }
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
        else if(size()==-1){
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
        if(index<size()&&index>size()){
            System.out.println("Niepoprawny index!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=size();
            while(rozmiar!=-1&&el.getValue()!=null&&ob==null){
                if(rozmiar==index){
                    Element object=el;
                    object.getPrevious().setNext(el);
                    object.getNext().setPrevious(el);
                    ob=el.getValue();
                    el.setValue(value);
                }
                el=el.getNext();
                rozmiar--;
            }
        }
        return ob;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        Object ob=null;
        if(index<size() && index>size()){
            System.out.println("Nie ma elementu o takim indeksie!");
        }
        else if(size()==-1){
            System.out.println("Lista pusta!");
        }
        else {
            Element el=getFirst();
            int rozmiar=size();
            while(rozmiar!=-1&&el.getValue()!=null&&ob==null){
                if(rozmiar==index){
                    ob=el.getValue();
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
        int rozmiar=size();
        Element el=getFirst();
        while(rozmiar!=-1&&indeks==-1){
            if(el.getValue()==value){
                indeks=rozmiar;
            }
            el=el.getNext();
            rozmiar--;
        }
        return indeks;
    }

    @Override
    public boolean contains(Object value) {
        boolean flag=false;
        if (getFirst() != null) {
            Element ob=getFirst();
            while (ob.getNext()!=null){
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
            st+="lista zawiera jeden element: ["+getFirst().getValue()+"]";
        }
        else{
            Element el=getFirst();
            while (el!=null){
                st+="["+el.getValue()+"]";
                el=el.getNext();
            }
        }
        return st;
    }
}

