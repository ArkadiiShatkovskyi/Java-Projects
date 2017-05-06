package com.company.listy;

public class ValueIterator implements Iterator {

    private Element current1=null;
    private Element first;
    private Element last;

    public ValueIterator(Element first,Element last){
        this.first=first;
        this.last=last;
    }

    @Override
    public void previous() {
        if(current1.getPrevious()!=null)
          current1=current1.getPrevious();
        else
            System.out.println("Koniec listy!");
    }

    @Override
    public void next() {
        if(current1!=null&&current1.getNext()!=null)
            current1=current1.getNext();
        else
            System.out.println("Koniec listy");
    }

    @Override
    public void first() {
        current1=first;
    }

    @Override
    public void last() {
        current1=last;
    }

    @Override
    public boolean isDone() {
        return current1==null||current1.getNext()==null;
    }

    @Override
    public Object current() {
        return current1;
    }
}
