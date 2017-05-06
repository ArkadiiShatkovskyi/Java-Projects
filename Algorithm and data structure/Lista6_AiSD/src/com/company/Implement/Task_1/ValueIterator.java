package com.company.Implement.Task_1;

import com.company.Implement.other.Iterator;

import java.util.List;

public class ValueIterator implements Iterator {

    private List<MapObject> list;
    private int current;

    public ValueIterator(List list){
        this.list=list;
        current=-1;
    }

    @Override
    public void first(){
        current=0;
    }

    @Override
    public void last() {
        current=list.size()-1;
    }

    @Override
    public void previous() {
        --current;
    }

    @Override
    public void next() {
        ++current;
    }

    @Override
    public Integer current(){
        return list.get(current).getValue();
    }

    @Override
    public boolean isDone(){
        return current<0 || current>list.size()-1;
    }

    @Override
    public String toString() {
        String s="ValueIterator: \n";
        for(this.first();!this.isDone();this.next()){
            s+="[ "+this.current()+" ]";
        }
        return s;
    }
}
