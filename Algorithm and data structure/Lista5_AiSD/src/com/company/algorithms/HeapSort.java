package com.company.algorithms;

import com.company.implement.*;
import com.company.implement.Queue;
import java.util.*;


public class HeapSort implements ListSorted {

    private int numberOfWrite=0;
    private int numberOfCompare=0;
    private List<Character> ls =new LinkedList<Character>();

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

    private Queue createPriorityQueue(LinkedList list) {
        Queue queue = new HeapPriorityQueue();
        while (!list.isEmpty()) {
            queue.enqueue(list.removeFirst());
        }
        return queue;
    }

    @Override
    public java.util.List sort(java.util.List list) {
        Queue queue = createPriorityQueue((LinkedList)list);
        while (!queue.isEmpty()) {
            ls.add((Character) queue.dequeue());
        }
        int child;
        int size=ls.size();
        while (size>0){
            for(int i=0;i<size;i++){
                Comp compInt=new Comp(ls.get(i));
                ++numberOfCompare;
                if((2*i+1)<size && (2*(i+1))<size && ls.get(2*i+1)!=null && ls.get(2*i+1)>=ls.get(2*(i+1)) && compInt.compareTo(ls.get(child = (2 * i + 1)))<0){
                    ++numberOfWrite;
                    swap(i,child);
                }
                else if((2*(i+1))<size && (2*i+1)<size &&  ls.get(2*(i+1))!=null&& ls.get(2*i+1)<=ls.get(2*(i+1)) && compInt.compareTo(ls.get(child=(2*(i+1))))<0){
                    ++numberOfWrite;
                    swap(i,child);
                }
            }
            ++numberOfWrite;
            swap(0,size-1);
            size--;
        }
        return ls;
    }

    private void swap(int index1, int index2) {
        Object temp = ls.get(index1);
        ls.set(index1, ls.get(index2));
        ls.set(index2, (Character) temp);
    }

    @Override
    public String toString() {
        return "HeapSort: Porownan: "+getNumberOfCompare()+", Przepisan: "+getNumberOfWrite();
    }
}