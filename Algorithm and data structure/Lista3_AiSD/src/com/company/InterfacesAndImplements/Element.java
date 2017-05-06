package com.company.InterfacesAndImplements;

public class Element {

    private Object value;
    private Element previous;
    private Element next;
    private int howManyUseElem;

    public Element(Object value){
        setValue(value);
        howManyUseElem=0;
    }

    public void setNum(int num){
        howManyUseElem=num;
    }

    public int getNumOfUse(){
        return howManyUseElem;
    }

    public void addElem(Element next){
        Element prev=next.getPrevious();
        setNext(next);
        setPrevious(prev);
        next.setPrevious(this);
        prev.setNext(this);
    }

    public void deleteElem(){
        previous.setNext(next);
        next.setPrevious(previous);
    }

    public void setValue(Object value){
        this.value=value;
    }

    public Object getValue(){
        return value;
    }

    public void setPrevious(Element ob){
        previous=ob;
    }

    public Element getPrevious(){
        return previous;
    }

    public void setNext(Element nx){
        next=nx;
    }

    public Element getNext(){
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        Element element=(Element)obj;
        return this.getValue().equals(element.getValue()) && this.getNext().equals(element.getNext()) && this.getPrevious().equals(element.getPrevious());
    }
}
