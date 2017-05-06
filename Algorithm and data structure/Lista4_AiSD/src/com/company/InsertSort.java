package com.company;

import java.util.List;

public class InsertSort implements ListSorted {

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
        boolean flag=false;
        int z=0;
        for (int i = 1; i < list.size(); ++i) {
            Object value = list.get(i),temp;
            int j;
            Comp comp =new Comp((Character)value);
            if(!flag){
                ++z;
            }
            for (j = i; j > 0&& comp.compareTo((Character)(temp=list.get(j - 1)))< 0; --j){
                list.set(j,temp);
                ++numberOfCompare;
                flag=true;
            }
            ++numberOfWrite;
            list.set(j, value);
        }
        if(!flag){
            numberOfCompare+=z;
        }
        ls=list;
        return list;
    }

    @Override
    public String toString() {
        String s="InsertSort: ";
        s+=ls.toString()+", Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
        return s;
    }
}
