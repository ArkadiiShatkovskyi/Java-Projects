package com.company.Task_4;


import com.company.Task_3.Compar;
import com.company.Task_3.Element;

import java.util.LinkedList;

public class TreeDescription {

    private Element tree;
    private int leaves;
    private int internalNodes;
    private int smallerValues;
    private LinkedList<Integer> list=new LinkedList<Integer>();
    private Compar comp=new Compar();

    public TreeDescription(Element tree){
        this.tree=tree;
        leaves=0;
        internalNodes=0;
        smallerValues=0;
    }

    public int smallerValue(){
        count(tree,true,(Integer)tree.getValue());
        int result=smallerValues;
        smallerValues=0;
        return result;
    }

    public int countLeaves(){
        int result=count(tree, true,null);
        leaves=0;
        return result;
    }

    public int countInternalNodes(){
        int result=count(tree,false,null);
        internalNodes=0;
        return result;
    }

    public int countNodes(){
        int result=count(tree,true,null)+count(tree,false,null);
        internalNodes=0;
        leaves=0;
        return result;
    }

    public int countHeight(){
        countHeight(tree);
        int result=list.get(0);
        for(int i=0;i<list.size();i++){
            if(result<list.get(i)){
                result=list.get(i);
            }
        }
        list.clear();
        return result;
    }

    private void countHeight(Element element){
        if(element.getLeft()==null && element.getRight()==null){
            list.add(height(element));
        }
        if(element.getLeft()!=null){
            countHeight(element.getLeft());
        }
        if (element.getRight()!=null){
            countHeight(element.getRight());
        }
    }

    private int height(Element element){
        int result=1;
        while (element.getParent()!=null){
            ++result;
            element.getParent();
            element=element.getParent();
        }
        return result;
    }


    private int count(Element tree, boolean leavesOrNodes,Integer value){
        if(value!=null && comp.compare((Integer)tree.getValue(),value)==-1){
            ++smallerValues;
        }
        if(leavesOrNodes && tree.getLeft()==null && tree.getRight()==null){
            ++leaves;
        }
        else if(!leavesOrNodes && (tree.getLeft()!=null || tree.getRight()!=null)){
            ++internalNodes;
        }
        if(tree.getLeft()!=null){
            count(tree.getLeft(),leavesOrNodes,value);
        }
        if (tree.getRight()!=null){
            count(tree.getRight(),leavesOrNodes,value);
        }
        if(leavesOrNodes){
            return leaves;
        }
        else{
            return internalNodes;
        }
    }
}

