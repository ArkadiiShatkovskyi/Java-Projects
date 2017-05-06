package com.company.algorithms;

import com.company.implement.Comp;
import com.company.implement.ListSorted;

import java.util.List;

public class QuickSort implements ListSorted {

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

    // wynikiem jest posortowana oryginalna lista
        public List sort(List list) {
            quicksort(list, 0, list.size() - 1);
            ls=list;
            return list;
        }

        private void quicksort(List list, int startIndex, int endIndex) {
            if (endIndex > startIndex) {
                int partition = partition(list, startIndex, endIndex);
                quicksort(list, startIndex, partition );
                quicksort(list, partition + 1, endIndex);
            }
        }

        // podział według Lomuto
        private int partition(List list, int left, int right) {
        //jako element dzielący bierzemy ostatni
            Object value=list.get(right);
            int i=left-1;
            while (left <= right){
                Comp comp=new Comp((Character)list.get(left));
                ++numberOfCompare;
                if(comp.compareTo((Character)value) <= 0){
                    swap(list, ++i,left);
                }
                ++left;
            }
            return i<right ? i :i-1;
        }

        private void swap(List list, int left, int right) {
            if (left != right) {
                ++numberOfWrite;
                Object temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
        }

    @Override
    public String toString() {
        return "QuickSort: Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
    }
    }

