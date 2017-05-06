package com.company.Task_3;

public class Element {

    private Element left;
    private Element right;
    private Element parent;
    private Object value;

    public Element(Object value,Element left, Element right,Element parent){
        this.left=left;
        this.right=right;
        this.value=value;
        this.parent=parent;
    }

    public Element(Object value,Element parent){
        this.left=null;
        this.right=null;
        this.value=value;
        this.parent=parent;
    }

    public Element(){
        left=null;
        right=null;
        value=null;
        parent=null;
    }

    public void setValue(Object value){
        this.value=value;
    }

    public void setLeft(Element left){
        this.left=left;
    }

    public void setRight(Element right){
        this.right=right;
    }

    public void setParent(Element parent){this.parent=parent;}

    public Object getValue(){
        return value;
    }

    public Element getLeft(){
        return left;
    }

    public Element getRight(){
        return right;
    }

    public Element getParent(){return parent;}

    @Override
    public boolean equals(Object obj) {
        return (Integer)value < (Integer)obj;
    }
}
