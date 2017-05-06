package com.company.Task2;

import java.util.LinkedList;

public class Node {

    private Character value;
    private LinkedList<Node> children=new LinkedList<Node>();

    public Node(Character value){
        this.value=value;
    }

    public int isOnNextElements(Character value){
        CharacterComparator comp=new CharacterComparator();
        int result=-1;
        for(int i=0;i<children.size();i++){
            if(comp.compare(children.get(i).getValue(),value)==0){
                result=i;
            }
        }
        return result;
    }

    public void removeChild(int index){
        children.remove(index);
    }

    public Character getValue() {
        return value;
    }

    public boolean isHasAChild(){
        boolean result=false;
        for(Node p:children){
            if(p.getValue()!=null){
                result=true;
            }
        }
        return result;
    }

    public LinkedList<Node> getChildren(){
        return children;
    }

    public Node getChildren(Character value){
        return children.get(isOnNextElements(value));
    }

    public void addChildren(Character value){
        children.add(new Node(value));
    }

    @Override
    public String toString() {
        String s="[";
        for (Node aChildren : children) {
            if (aChildren.getValue() != null) {
                s += aChildren.getValue() + ",";
            }
        }
        s=s.substring(0,s.length()-1)+"]";
        return s;
    }
}
