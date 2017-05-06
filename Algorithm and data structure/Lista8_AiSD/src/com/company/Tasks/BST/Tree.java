package com.company.Tasks.BST;

import com.sun.xml.internal.ws.client.SenderException;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Element tree = new Element();
    private Comparator comp = new Compar();
    private String s = "";

    public void add(Object value) {
        insert(value);
    }

    private void insert(Object value) {
        if (tree.getValue() == null) {
            tree.setValue(value);
        } else {
            boolean flag = false;
            Element current = tree;
            while (!flag) {

                if (!current.equals(value) && current.getLeft() == null) {
                    current.setLeft(new Element(value, current));
                    flag = true;
                } else if (current.equals(value) && current.getRight() == null) {
                    current.setRight(new Element(value, current));
                    flag = true;
                }

                if (!current.equals(value)) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            //System.out.println("Element dodano!");
        }
    }

    public Element getTree() {
        return tree;
    }

    public boolean find(Object value) {
        return find(tree, value);
    }

    private boolean find(Element element, Object value) {
        boolean result = false;
        boolean flag = false;
        while (!flag) {
            if (comp.compare(element.getValue(), value) == 0) {
                result = true;
                //System.out.println("Znaleziono element!");
            } else {
                if (element.getLeft() != null) {
                    result = find(element.getLeft(), value);
                }
                if (result == false && element.getRight() != null) {
                    result = find(element.getRight(), value);
                }
            }
            flag = true;
        }
        return result;
    }

    public void delete(Object x) {
        tree = delete(x, tree);
    }

    protected Element delete(Object x, Element t) {
        if (t == null) {
            throw new SenderException(x.toString());
        } else {
            int cmp = comp.compare(x, t.getValue());
            if (cmp < 0) {
                t.setLeft(delete(x, t.getLeft()));
            } else if (cmp > 0) {
                t.setRight(delete(x, t.getRight()));
            } else if (t.getLeft() != null && t.getRight() != null) {
                t.setRight(detachMin(t.getRight(), t));
            } else {
                t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
            }
        }
        return t;
    }

    //zastąp usuwany element jego następnikiem i usuń następnik
    protected Element detachMin(Element t, Element del) {
        if (t.getLeft() != null) {
            t.setLeft(detachMin(t.getLeft(), del));
        } else {
            del.setValue(t.getValue());
            t = t.getRight();
        }
        return t;
    }

    private String writeElements(Element element) {
        boolean flag = false;
        String s = "";
        while (!flag) {
            s += element.getValue() + ",";
            if (element.getLeft() != null) {
                s += writeElements(element.getLeft());
            }
            if (element.getRight() != null) {
                s += writeElements(element.getRight());
            }
            flag = true;
        }
        return s;
    }

    @Override
    public String toString() {
        String s = writeElements(tree);
        String result = "Drzewo: [ " + s.substring(0, s.length() - 1) + " ]";
        return result;
    }

    /**
     * Zadanie 2, lista 8        *
     */
    public void printInorderPrint() {
        System.out.print("InOrder: [ ");
        InOrderTraverse(tree);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]");
        s = "";
    }

    private void InOrderTraverse(Element root) {
        if (root == null) {
            return;
        }
        InOrderTraverse(root.getLeft());
        s += root.getValue() + ", ";
        InOrderTraverse(root.getRight());
    }

    public void printPreorder() {
        System.out.print("\nPreOrder: [ ");
        PreOrderTraverse(tree);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]");
        s = "";
    }

    private void PreOrderTraverse(Element root) {
        if (root == null) {
            return;
        }
        s += root.getValue() + ", ";
        PreOrderTraverse(root.getLeft());
        PreOrderTraverse(root.getRight());
    }

    public void printPostorder() {
        System.out.print("\nPostOrder: [ ");
        printPostOrder(tree);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]");
        s = "";
    }

    private void printPostOrder(Element root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.getLeft());
        printPostOrder(root.getRight());
        s += root.getValue() + ", ";
    }

    public void printLevelOrder() {
        System.out.print("\nLevelOrder: [ ");
        printLevelOrder(tree);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]");
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