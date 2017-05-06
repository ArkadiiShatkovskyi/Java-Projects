package com.company.Test;

import com.company.Task1.AVL;
import com.company.Task2.TrieTree;

public class Main {

    public static void main(String[] args) {

        AVL avl =new AVL();
        System.out.println("AVL drzewo:");
        avl.add(5);
        avl.add(6);
        avl.add(7);
        avl.add(1);
        avl.add(4);
        avl.add(8);
        avl.add(9);
        avl.printLevelOrder();
        System.out.println("Usuwamy element: '6'");
        avl.delete(6);
        avl.printLevelOrder();
        System.out.println("Dodajemy element '12'");
        avl.add(12);
        avl.printLevelOrder();


        System.out.println("\nTrie Tree:");
        TrieTree trieTree=new TrieTree();
        trieTree.add("samochód");
        trieTree.add("cześć");
        trieTree.add("on");
        trieTree.add("ona");
        trieTree.add("chłopaki");
        System.out.println("Czy jest slowo: 'cześć'? : " + trieTree.contains("cześć"));
        System.out.println("Czy jest slowo: 'chłopaki'? : "+trieTree.contains("chłopaki"));
        System.out.println("Czy jest slowo: 'on'? : "+trieTree.contains("on"));
        System.out.println("Usuwamy element: 'on'");
        trieTree.delete("on");
        System.out.println("Czy jest slowo: 'ona'? : " + trieTree.contains("ona"));
        System.out.println("Czy jest slowo: 'on'? : " + trieTree.contains("on"));
        System.out.println("Drzewo: "+trieTree.toString());
       // System.out.println("Find by prefix: 'o': "+trieTree.findByPrefix("o"));
    }
}
