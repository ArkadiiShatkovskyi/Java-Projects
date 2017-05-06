package com.company.Task1.GraphList;

import java.util.ArrayList;

public class GraphListIn {

    private ArrayList<Element> graphList=new ArrayList<Element>();
    private Comp comp=new Comp();  //Comparator
    private String s;
    private ArrayList<Character> views=new ArrayList<Character>();

    public ArrayList<Element> getGraphList(){
        return graphList;
    }

    public void add(char element){
        if(!onList(element)){
            graphList.add(new Element(element));
        }
    }

    public void addWay(String st){
        char[] ch=st.toCharArray();
        char value=ch[0];
        char way=ch[1];
        for(Element el:graphList){
            if(comp.compare(el.getValue(), way)==0){
                el.addWay(value);
            }
        }
    }

    private boolean onList(char value){
        boolean result=false;
        for(Element el:graphList){
            if (comp.compare(el.getValue(),value)==0){
                result=true;
            }
        }
        return result;
    }

    public int indexOnList(char value){
        int result=-1;
        for(int i=0;i<graphList.size();i++){
            if(comp.compare(graphList.get(i).getValue(),value)==0){
                result=i;
            }
        }
        return result;
    }

    public void deleteWay(char value,char way){
        for(Element el:graphList){
            if(comp.compare(el.getValue(),value)==0){
                el.deleteWay(way);
            }
        }
    }

    @Override
    public String toString() {
        String s="Graf listy sasiedstwa: [ ";
        for(Element el:graphList){
            s+=el.getValue()+el.getWays().toString()+"; ";
        }
        return s.substring(0,s.length()-2)+" ]";
    }
}
