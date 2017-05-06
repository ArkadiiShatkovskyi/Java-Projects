package com.company;

import java.util.List;

public class SelectSort implements ListSorted {

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
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check){
                ++numberOfCompare;
                Comp comp =new Comp((Character)list.get(check));
                if (comp.compareTo((Character)list.get(smallest)) < 0){
                    smallest = check;
                }
            }
            swap(list, smallest, slot);
        }
        ls=list;
        return list;
    }

    private void swap(List list, int left, int right) {
        if (left != right) { // podejście optymisty
            ++numberOfWrite;
            Object temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    @Override
    public String toString() {
        String s="SelectSort: ";
        s+=ls.toString()+", Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
        return s;
    }
}