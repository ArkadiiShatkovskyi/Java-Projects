package com.company.Test;

import com.company.Task_1.Comp;
import com.company.Task_1.IterativeBinaryListSearcher;
import com.company.Task_3.Tree;
import com.company.Task_4.TreeDescription;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<String>();
        list.add("Arek");
        list.add("Batman");
        list.add("Ciocia");
        list.add("Donald");

        IterativeBinaryListSearcher iterativeBinaryListSearcher=new IterativeBinaryListSearcher(new Comp());
        if(iterativeBinaryListSearcher.search(list,"Arek")!=-1){
        System.out.println("Znaleziono obiekt: "+list.get(iterativeBinaryListSearcher.search(list,"Arek"))+", o indexsie: "+iterativeBinaryListSearcher.search(list,"Arek"));
        }
        else {
            System.out.println("Element nie znaleziono!");
        }

        System.out.println("Zadanie 3:");
        Tree tree=new Tree();
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(10);
        tree.add(2);
        tree.add(8);
        tree.add(6);
        tree.add(11);
        tree.add(1);
        tree.add(3);
        tree.add(12);
        tree.add(14);
        tree.add(9);
        tree.add(13);
        System.out.println(tree.toString());
        System.out.println("Szukamy element: '3' : Znaleziono? "+tree.find(3));
       // tree.delete(4);
        tree.delete(7);
       // tree.delete(5);
        System.out.println("Usuwamy element: \n"+tree.toString());

        TreeDescription treeDescription=new TreeDescription(tree.getTree());
        System.out.println("Wezlow w drzewie: "+treeDescription.countNodes());
        System.out.println("Lisci w drzewie: "+treeDescription.countLeaves());
        System.out.println("Wezly wewnetrzne: "+treeDescription.countInternalNodes());
        System.out.println("Wysokosc drzewa: "+treeDescription.countHeight());
        System.out.println("Mniejszysh wartosci od korzenia: "+treeDescription.smallerValue());
    }
}
