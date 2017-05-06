package com.iterators;


public class IterOnTable implements Iterator {

    final private Integer[] array1;
    final private int first1;
    private int current1=-1;
    private int N;
    private boolean flag=false;

    public IterOnTable(Integer[] array2,int toNumber){
        array1=array2;
        first1=0;
        N=toNumber;
    }

    public void first(){
        current1=findFirst();
    }

    public void previous(){ current1-=toIndTrueBack(current1);}

    public void next(){
        current1 +=toIndTrue(current1);}

    public void last(){current1=findLast();}

    public boolean isDone(){return current1<first1||current1>array1.length-1||flag; }

    public Object current(){return array1[current1];}

    public int toIndTrue(int indexNow){
        int i=indexNow;
        while(i<=array1.length-1){
            if(i==array1.length-1){
                flag=true;
                return 0;
            }
            else{i++;}
            if (((array1[i] % 3 == 0) || (array1[i] % 5 == 0)) && (array1[i] <= N)) {
                return (i - indexNow);
            }
        }
        return array1.length-1-i;
    }

    public int findFirst(){
        if((array1[first1] % 3 == 0) || (array1[first1] % 5 == 0)){
            return first1;
        }
        else{
            current1=0;
            next();
            return current1;
        }
    }

    public int findLast(){
        if((array1[array1.length-1] % 3 == 0) || (array1[array1.length-1] % 5 == 0)){
            return array1.length-1;
        }
        else{
            current1=array1.length-1;
            previous();
            return current1;
        }
    }

    public int toIndTrueBack(int indexNow){
        int i=indexNow;
        while(i>=0) {
            if(i==0){flag=true; return 0;}
            i--;
            if (((array1[i] % 3 == 0) || (array1[i] % 5 == 0)) && (array1[i] <= N)) {
                return (indexNow-i);
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        String st="";
        first();
        while (!isDone()){
            st+="["+ current()+"]";
            next();
        }
        return st;
    }
}