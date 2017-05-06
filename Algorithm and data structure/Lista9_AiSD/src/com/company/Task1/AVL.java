package com.company.Task1;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    private Node root;
    private String s="";

    public void add(int k) {
        Node n = new Node(k);
        insert(this.root, n);
    }

    private void insert(Node tree, Node newObj) {
        if(tree==null) {
            this.root=newObj;
        }
        else {//1
            if(newObj.getValue()<tree.getValue()) {
                if(tree.getLeft()==null) {
                    tree.setLeft(newObj);
                    newObj.setParent(tree);
                    recursiveBalance(tree);
                }
                else {
                    insert(tree.getLeft(), newObj);
                }
            }
            else if(newObj.getValue()>tree.getValue()) {
                if(tree.getRight()==null) {
                    tree.setRight(newObj);
                    newObj.setParent(tree);
                    recursiveBalance(tree);
                }
                else {
                    insert(tree.getRight(), newObj);
                }
            }// else if
        }// 1
    }


    private void recursiveBalance(Node cur) {
        setBalance(cur);
        int balance = cur.getBalance();
        if(balance==-2) {
            if(height(cur.getLeft().getLeft())>=height(cur.getLeft().getRight())) {
                cur = rotateRight(cur);
            } else {
                cur.setLeft(rotateLeft(cur.getLeft()));
                cur=rotateRight(cur);
            }
        } else if(balance==2) {
            if(height(cur.getRight().getRight())>=height(cur.getRight().getLeft())) {
                cur = rotateLeft(cur);
            } else {
                cur.setRight(rotateRight(cur.getRight()));
                cur=rotateLeft(cur);
            }
        }
        if(cur.getParent()!=null) {
            recursiveBalance(cur.getParent());
        } else {
            this.root = cur;
        }
    }

    public void delete(int x)
    {
        root=delete(x,root);
    }

    protected Node delete(int value, Node t) {
        if(t==null){
            return null;
        }
        else {
            if(t.getValue()>value){
                t.setLeft(delete(value, t.getLeft()));
            }
            else if(t.getValue()<value){
                t.setRight(delete(value, t.getRight()));
            }
            else if(t.getLeft()!=null && t.getRight()!=null) {
                t.setRight(detachMin(t.getRight(),t));
            }
            else {
                t = (t.getLeft() != null) ? t.getLeft() : t.getRight();
            }
            recursiveBalance(t);
        }
        return t;
    }

    //zastąp usuwany element jego następnikiem i usuń następnik
    protected Node detachMin(Node t, Node del) {
        if(t.getLeft()!=null){
            t.setLeft(detachMin(t.getLeft(),del));
        }
        else {
            del.setValue(t.getValue()); t=t.getRight();
        }
        return t;
    }

    private Node rotateLeft(Node n) {

        Node v = n.getRight();
        v.setParent(n.getParent());

        n.setRight(v.getLeft());

        if(n.getRight()!=null) {
            n.getRight().setParent(n);
        }

        v.setLeft(n);
        n.setParent(v);

        if(v.getParent()!=null) {
            if(v.getParent().getRight()==n) {
                v.getParent().setRight(v);
            } else if(v.getParent().getLeft()==n) {
                v.getParent().setLeft(v);
            }
        }

        setBalance(n);
        setBalance(v);

        return v;
    }

    private Node rotateRight(Node n) {

        Node v = n.getLeft();
        v.setParent(n.getParent());

        n.setLeft(v.getRight());

        if(n.getLeft()!=null) {
            n.getLeft().setParent(n);
        }

        v.setRight(n);
        n.setParent(v);


        if(v.getParent()!=null) {
            if(v.getParent().getRight()==n) {
                v.getParent().setRight(v);
            } else if(v.getParent().getLeft()==n) {
                v.getParent().setLeft(v);
            }
        }

        setBalance(n);
        setBalance(v);

        return v;
    }

    private int height(Node cur) {
        if(cur==null) {
            return -1;
        }
        if(cur.getLeft()==null && cur.getRight()==null) {
            return 0;
        } else if(cur.getLeft()==null) {
            return 1+height(cur.getRight());
        } else if(cur.getRight()==null) {
            return 1+height(cur.getLeft());
        } else {
            return 1+Math.max(height(cur.getLeft()), height(cur.getRight()));
        }
    }

    private void setBalance(Node cur) {
        cur.setBalance(height(cur.getRight()) - height(cur.getLeft()));
    }

    /*****   Level Order  *****/
    public void printLevelOrder() {
        System.out.print("LevelOrder: [ ");
        printLevelOrder(root);
        System.out.print(s.substring(0, s.length() - 2));
        System.out.print(" ]\n");
        s = "";
    }

    private void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            s+=tempNode.getValue()+", ";
            if (tempNode.getLeft() != null){
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null){
                queue.add(tempNode.getRight());
            }
        }
    }
}

