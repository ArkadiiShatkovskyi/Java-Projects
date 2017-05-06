package com.company;

import java.util.Comparator;
import java.util.List;

public class ShakerSort implements ListSorted {

    private int numberOfWrite=0;
    private int numberOfCompare=0;
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

    @Override
    public List sort(List list) {
        for (int i = 0; i < list.size()/2; i++) {
            boolean swapped = false;
            for (int j = i; j < list.size() - i - 1; j++) {
                ++numberOfCompare;
                CompNumber compbl=new CompNumber((Integer)list.get(j));
                if (compbl.compareTo((Integer)list.get(j+1))>0) {
                    ++numberOfWrite;
                    int tmp = (Integer) list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                    swapped = true;
                }
            }
            for (int j = list.size() - 2 - i; j > i; j--) {
                ++numberOfCompare;
                CompNumber compbl=new CompNumber((Integer)list.get(j));
                if (compbl.compareTo((Integer)list.get(j-1))<0) {
                    ++numberOfWrite;
                    int tmp = (Integer)list.get(j);
                    list.set(j,list.get(j-1));
                    list.set(j-1,tmp);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        ls=list;
        return list;
    }

    @Override
    public String toString() {
        String s="ShakerSort: ";
        s+=ls.toString()+", Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
        return s;
    }
}
