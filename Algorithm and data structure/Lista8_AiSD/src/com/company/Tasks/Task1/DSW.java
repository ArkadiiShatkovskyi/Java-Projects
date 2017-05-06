package com.company.Tasks.Task1;

import com.company.Tasks.BST.Element;

import java.util.LinkedList;
import java.util.Queue;

public class DSW {

    private String s="";
    private Element root;

    public DSW(Element root){
        this.root=root;
    }

    public void DSW() {
        if (null != root) {
            createBackbone();// effectively: createBackbone( root)
            createPerfectBST();//effectively: createPerfectBST( root)
        }
    }


    private void createBackbone() {
        Element grandParent = null;
        Element parent = root;
        Element leftChild;

        while (null != parent) {
            leftChild = parent.getLeft();
            if (null != leftChild) {
                grandParent = rotateRight(grandParent, parent, leftChild);
                parent = leftChild;
            } else {
                grandParent = parent;
                parent = parent.getRight();
            }
        }
    }

    private Element rotateRight(Element grandParent, Element parent, Element leftChild) {
        if (null != grandParent) {
            grandParent.setRight(leftChild);
        } else {
            root = leftChild;
        }
        parent.setLeft(leftChild.getRight());
        leftChild.setRight(parent);
        return grandParent;
    }

    private void createPerfectBST() {
        int n = 0;
        for (Element tmp = root; null != tmp; tmp = tmp.getRight()) {
            n++;
        }
        //m = 2^floor[lg(n+1)]-1, ie the greatest power of 2 less than n: minus 1
        int m = greatestPowerOf2LessThanN(n + 1) - 1;
        //System.out.println("n: "+n+", m: "+m);
        makeRotations(n - m);

        while (m > 1) {
            makeRotations(m /= 2);
        }
    }

    private int greatestPowerOf2LessThanN(int n) {
        int ndx = 0;
        while (1 < n) {
            n = (n >> 1);
            //System.out.println("n: "+n);
            ndx++;
        }
        int x = ndx;
        return (1 << x);//2^x
    }

    private void makeRotations(int bound) {
        Element grandParent = null;
        Element parent = root;
        Element child = root.getRight();
        for (; bound > 0; bound--) {
            try {
                if (null != child) {
                    rotateLeft(grandParent, parent, child);
                    grandParent = child;
                    parent = grandParent.getRight();
                    child = parent.getRight();
                } else {
                    break;
                }
            } catch (NullPointerException convenient) {
                break;
            }
        }
    }

    private void rotateLeft(Element grandParent, Element parent, Element rightChild) {
        if (null != grandParent) {
            grandParent.setRight(rightChild);
        } else {
            root = rightChild;
        }
        parent.setRight(rightChild.getLeft());
        rightChild.setLeft(parent);
    }

    /*****   Level Order  *****/
    public void printLevelOrder() {
        System.out.print("LevelOrder: [ ");
        printLevelOrder(root);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]\n");
        s = "";
    }

    private void printLevelOrder(Element root) {
        Queue<Element> queue = new LinkedList<Element>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Element tempNode = queue.poll();
            s+=tempNode.getValue()+", ";
            if (tempNode.getLeft() != null)
                queue.add(tempNode.getLeft());
            if (tempNode.getRight() != null)
                queue.add(tempNode.getRight());
        }
    }
}
