package com.company.Task1.GraphList;

import java.util.ArrayList;

public class Element {

    private ArrayList<Character> ways=new ArrayList<Character>(); // lista sasiedstwa
    private char value;
    private boolean views;
    private String color;


    public Element(char value){
        this.value=value;
        views=false;
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return color;
    }

    public void addWay(char way){
        if(!wayOnList(way)){
           ways.add(way);
        }
    }

    public void deleteWay(char way){
        ways.remove(way);
    }

    private boolean wayOnList(char way){
        boolean result=false;
        for(Character ch:ways){
            if(ch==way){
                result=true;
            }
        }
        return result;
    }

    public ArrayList<Character> getWays(){
        return ways;
    }

    public boolean getViews(){
        return views;
    }

    public void setViews(boolean views){
        this.views=views;
    }

    public char getValue(){
        return value;
    }
}
