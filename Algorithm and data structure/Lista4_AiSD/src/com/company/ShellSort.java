package com.company;

import java.util.List;

public class ShellSort implements ListSorted {

    // przyrost
    private int _h = 1;
    private int numberOfWrite=0;
    private int numberOfCompare=0;
    private int[] tab=new int[3];
    private List<Float> ls;

    public int getNumberOfWrite(){
        return numberOfWrite;
    }

    public int getNumberOfCompare(){
        return numberOfCompare;
    }

    public void reset(){
        numberOfCompare=0;
        numberOfWrite=0;
    }

    public ShellSort(int i1,int i2,int i3) {
        tab[0] = i1;
        tab[1] = i2;
        tab[2] = i3;
    }

    public List sort(List list) {
        for(int i=0;i<tab.length;i++) {
            _h = tab[i];
        int size=list.size();
            for(int j=_h;j<size;j++){ //wstawiaj kolejne elementy na podlistach
                insert(list,j);
            }
      }
        ls=list;
        return list;
    }

    private void insert( List list, int poz) {
        Object temp,value=list.get(poz);
        ++numberOfCompare;
        Comp comp =new Comp((Character)value);
        while( poz>=_h && comp.compareTo((Character)(temp=list.get(poz-_h))) < 0) {
            ++numberOfCompare;
            ++numberOfWrite;
            list.set(poz,temp); poz-=_h;
        }
        list.set(poz,value);
    }

    @Override
    public String toString() {
        String s="ShellSort: ";
        s+=ls.toString()+", Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
        return s;
    }
}
