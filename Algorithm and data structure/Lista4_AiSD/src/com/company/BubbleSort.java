package com.company;

import java.util.List;

public class BubbleSort implements ListSorted {

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

    public List sort(List list) {
        int size = list.size();
        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;
                ++numberOfCompare;
                Comp comp =new Comp((Character)list.get(left));
                if (comp.compareTo((Character)list.get(right))>0) {
                  //  System.out.println("left: "+list.get(left)+", right: "+list.get(right));
                    swap(list, left, right);
                }
            }
        }
        ls=list;
        return list;
    }

    private void swap(List list, int left, int right) {
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
        ++numberOfWrite;
    }

    @Override
    public String toString() {
        String s="BubbleSort: ";
        s+=ls.toString()+", Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
        return s;
    }
}