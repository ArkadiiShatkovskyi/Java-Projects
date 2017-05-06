package com.company.algorithms;

import com.company.implement.Comp;
import com.company.implement.ListSorted;

import java.util.LinkedList;
import java.util.List;

public class MergeSort implements ListSorted {

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

    // wynikiem jest nowa lista
    public List sort(List list)
    { return mergesort(list, 0, list.size() - 1); }

    private List mergesort(List list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            //++numberOfWrite;
            List result = new LinkedList();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge((LinkedList)mergesort(list, startIndex, splitIndex),
                (LinkedList)mergesort(list, splitIndex + 1, endIndex));
    }

    private List merge(LinkedList left, LinkedList right) {
        List result = new LinkedList();
        int i=0;
        int j=0;
        while(i<left.size()&&j<right.size()){
            Comp comp=new Comp((Character)left.get(i));
            ++numberOfCompare;
            if(comp.compareTo((Character)right.get(j))<=0){
               ++numberOfWrite;
                result.add(left.get(i));++i;
            }
            else {
               ++numberOfWrite;
                result.add(right.get(j));++j;
            }
        }

        while (i<left.size()){
             ++numberOfWrite;
            result.add(left.get(i));++i;
        }
        while (j<right.size()){
             ++numberOfWrite;
                result.add(right.get(j));++j;
        }
        ls=result;
        return result;
    }

    @Override
    public String toString() {
        return "MergeSort: Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
    }
}