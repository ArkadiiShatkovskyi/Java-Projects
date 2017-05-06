package com.company.Task1;

public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int value;
    private int balance;

    public Node(int k) {
        left = right = parent = null;
        balance = 0;
        value = k;
    }

    public int getValue(){
        return value;
    }

    public int getBalance(){
        return balance;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public Node getParent(){
        return parent;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public void setRight(Node right){
        this.right=right;
    }

    public void setParent(Node parent){
        this.parent=parent;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setBalance(int balance){
        this.balance=balance;
    }

    @Override
    public String toString() {
        return "" + getValue();
    }
}