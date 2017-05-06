package com.company.Test;

import com.company.algorithms.HeapSort;
import com.company.algorithms.MergeSort;
import com.company.algorithms.QuickSort;
import com.company.implement.Letters;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Letters letters=new Letters();
          String s="gfcnaxrtyunp";
        String st="abcdefghijkl";
        String st2="lkjihgfedcba";
        String st3="abcdefrtyunp";

        LinkedList<Character> list=new LinkedList<Character>();

        MergeSort mergeSort=new MergeSort();
        QuickSort quickSort=new QuickSort();
        HeapSort heapSort=new HeapSort();

        mergeSort.sort(letters.letters(s));
        quickSort.sort(letters.letters(s));
        heapSort.sort(letters.letters(s));

        System.out.println("Losowy ciag: ");
        System.out.println(mergeSort.toString());
        System.out.println(quickSort.toString());
        System.out.println(heapSort.toString());

        mergeSort.reset();
        quickSort.reset();
        heapSort.reset();
        list.clear();

        mergeSort.sort(letters.letters(st));
        quickSort.sort(letters.letters(st));
        heapSort.sort(letters.letters(st));

        System.out.println("\nCiag uporzadkowany: ");
        System.out.println(mergeSort.toString());
        System.out.println(quickSort.toString());
        System.out.println(heapSort.toString());


        mergeSort.reset();
        quickSort.reset();
        heapSort.reset();
        list.clear();

        mergeSort.sort(letters.letters(st2));
        quickSort.sort(letters.letters(st2));
        heapSort.sort(letters.letters(st2));

        System.out.println("\nCiag odwrotny: ");
        System.out.println(mergeSort.toString());
        System.out.println(quickSort.toString());
        System.out.println(heapSort.toString());


        mergeSort.reset();
        quickSort.reset();
        heapSort.reset();
        list.clear();

        mergeSort.sort(letters.letters(st3));
        quickSort.sort(letters.letters(st3));
        heapSort.sort(letters.letters(st3));

        System.out.println("\nCzesciowo uporzadkowany ciag: ");
        System.out.println(mergeSort.toString());
        System.out.println(quickSort.toString());
        System.out.println(heapSort.toString());
    }
}
