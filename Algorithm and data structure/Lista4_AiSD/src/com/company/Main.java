package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Letters letters=new Letters();
        BubbleSort bubbleSort=new BubbleSort();
        InsertSort insertSort=new InsertSort();
        SelectSort selectSort=new SelectSort();
        ShellSort shellSort=new ShellSort(3,2,1);
        ShellSort shellSort1=new ShellSort(10,5,1);
        ShellSort shellSort2=new ShellSort(9,6,3);

        String letter="qwertyuiopas";
        System.out.println("Losowy ciag: "+letters.letters(letter).toString());
        bubbleSort.sort(letters.letters(letter));
        insertSort.sort(letters.letters(letter));
        selectSort.sort(letters.letters(letter));
        shellSort.sort(letters.letters(letter));
        System.out.println(bubbleSort.toString());
        System.out.println(insertSort.toString());
        System.out.println(selectSort.toString());
        System.out.println(shellSort.toString());
        shellSort1.sort(letters.letters(letter));
        System.out.println(shellSort1.toString());
        shellSort1.reset();
        shellSort2.sort(letters.letters(letter));
        System.out.println(shellSort2.toString());
        shellSort2.reset();

        String letter2="abcdefghijkl";
        System.out.println("\nCiag juz uporzadkowany: "+letters.letters(letter2).toString());
        bubbleSort.reset();
        insertSort.reset();
        selectSort.reset();
        shellSort.reset();
        bubbleSort.sort(letters.letters(letter2));
        insertSort.sort(letters.letters(letter2));
        selectSort.sort(letters.letters(letter2));
        shellSort.sort(letters.letters(letter2));
        System.out.println(bubbleSort.toString());
        System.out.println(insertSort.toString());
        System.out.println(selectSort.toString());
        System.out.println(shellSort.toString());
        shellSort1.sort(letters.letters(letter2));
        System.out.println(shellSort1.toString());
        shellSort1.reset();
        shellSort2.sort(letters.letters(letter2));
        System.out.println(shellSort2.toString());
        shellSort2.reset();

        String letter5="abcdeflfvbgy";
        System.out.println("\nCiag czesciowo uporzadkowany: "+letters.letters(letter5).toString());
        bubbleSort.reset();
        insertSort.reset();
        selectSort.reset();
        shellSort.reset();
        bubbleSort.sort(letters.letters(letter5));
        insertSort.sort(letters.letters(letter5));
        selectSort.sort(letters.letters(letter5));
        shellSort.sort(letters.letters(letter5));
        System.out.println(bubbleSort.toString());
        System.out.println(insertSort.toString());
        System.out.println(selectSort.toString());
        System.out.println(shellSort.toString());
        shellSort1.sort(letters.letters(letter5));
        System.out.println(shellSort1.toString());
        shellSort1.reset();
        shellSort2.sort(letters.letters(letter5));
        System.out.println(shellSort2.toString());
        shellSort2.reset();

        String letter3="lkjihgfedcba";
        System.out.println("\nCiag w odwrotnej kolejnosci: "+letters.letters(letter3).toString());
        bubbleSort.reset();
        insertSort.reset();
        selectSort.reset();
        shellSort.reset();
        bubbleSort.sort(letters.letters(letter3));
        insertSort.sort(letters.letters(letter3));
        selectSort.sort(letters.letters(letter3));
        shellSort.sort(letters.letters(letter3));
        System.out.println(bubbleSort.toString());
        System.out.println(insertSort.toString());
        System.out.println(selectSort.toString());
        System.out.println(shellSort.toString());
        shellSort1.sort(letters.letters(letter3));
        System.out.println(shellSort1.toString());
        shellSort1.reset();
        shellSort2.sort(letters.letters(letter3));
        System.out.println(shellSort2.toString());
        shellSort2.reset();

        String letter4="aaaaaaaaaaaa";
        System.out.println("\nCiag o jednakowych danych: "+letters.letters(letter4).toString());
        bubbleSort.reset();
        insertSort.reset();
        selectSort.reset();
        shellSort.reset();
        bubbleSort.sort(letters.letters(letter4));
        insertSort.sort(letters.letters(letter4));
        selectSort.sort(letters.letters(letter4));
        shellSort.sort(letters.letters(letter4));
        System.out.println(bubbleSort.toString());
        System.out.println(insertSort.toString());
        System.out.println(selectSort.toString());
        System.out.println(shellSort.toString());
        shellSort1.sort(letters.letters(letter4));
        System.out.println(shellSort1.toString());
        shellSort2.sort(letters.letters(letter4));
        System.out.println(shellSort2.toString());

        String s="\n Losowy ciag: [";
        ArrayList<Integer> list2=new ArrayList<Integer>();
        for(int i=0;i<12;i++){
            int z=(int)(Math.random()*18);
            s+=z;
            list2.add(z);
            if(i==11){
                s+="]";
            }
            else{
                s+=", ";
            }
        }
        System.out.println(s);
        ShakerSort shakerSort=new ShakerSort();
        shakerSort.sort(list2);
        System.out.println(shakerSort.toString());

        String st="\n Ciag juz uporzadkowany: [";
        list2=new ArrayList<Integer>();
        for(int i=1;i<=12;i++){
            st+=i;
            list2.add(i);
            if(i==12){
                st+="]";
            }
            else{
                st+=", ";
            }
        }
        System.out.println(st);
        shakerSort.reset();
        shakerSort.sort(list2);
        System.out.println(shakerSort.toString());

        String st6="\n Ciag czesciowo uporzadkowany: [";
        list2=new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(9);
        list2.add(12);
        list2.add(11);
        list2.add(10);
        list2.add(7);
        list2.add(8);
        System.out.println(st6);
        shakerSort.reset();
        shakerSort.sort(list2);
        System.out.println(shakerSort.toString());

        String str="\nCiag w odwrotnej kolejnosci: [";
        list2=new ArrayList<Integer>();
        for(int i=12;i>=1;i--){
            str+=i;
            list2.add(i);
            if(i==1){
                str+="]";
            }
            else{
                str+=", ";
            }
        }
        System.out.println(str);
        shakerSort.reset();
        shakerSort.sort(list2);
        System.out.println(shakerSort.toString());

        String string="\nCiag o jednakowych danych: [";
        list2=new ArrayList<Integer>();
        int j=1;
        for(int i=12;i>=1;i--){
            string+=j;
            list2.add(j);
            if(i==1){
                str+="]";
            }
            else{
                string+=", ";
            }
        }
        System.out.println(string);
        shakerSort.reset();
        shakerSort.sort(list2);
        System.out.println(shakerSort.toString());
    }
}