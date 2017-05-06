package com.company.Test;

import com.company.Tasks.BST.Tree;
import com.company.Tasks.Task1.DSW;

public class Main {

    public static void main(String[] args) {

        Main mn=new Main();
        Tree tree=new Tree();
        tree.add(40);
        tree.add(25);
        tree.add(78);
        tree.add(10);
        tree.add(3);
        tree.add(17);
        tree.add(32);
        tree.add(30);
        tree.add(38);
        tree.add(50);
        tree.add(93);
        tree.add(2);
        tree.add(1);
        tree.add(45);
        tree.add(43);
        System.out.println("Task 2:");
        tree.printInorderPrint();
        tree.printPreorder();
        tree.printPostorder();
        tree.printLevelOrder();

        System.out.println("\n\nTask 1:");
        DSW dsw=new DSW(tree.getTree());
        dsw.printLevelOrder();
        dsw.DSW();
        dsw.printLevelOrder();


    }
}
