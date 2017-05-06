package com.company.Task1.GraphMatrix;

import com.company.Task1.GraphList.Comp;
import com.company.Task1.GraphList.Element;
import java.util.ArrayList;

public class GraphM {

    private boolean[][] matrix;
    private ArrayList<Element> graphList=new ArrayList<Element>();
    private Comp comp=new Comp();  //Comparator

    public GraphM(){
    matrix=new boolean[1][1];
    }

    public void add(char element){
        if(!onList(element)){
            graphList.add(new Element(element));
            boolean[][] matr=new boolean[graphList.size()][graphList.size()];
            updateMat(matr);
        }
    }

    private void updateMat(boolean[][] matr){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matr[i][j]=matrix[i][j];
            }
        }
        matrix=matr;
    }

    public void addWay(String s){
        char[] ch=s.toCharArray();
        char value=ch[0];
        char way=ch[1];
        addWayMat(value,way);
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

    private int indexOnList(char value){
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
                matrix[graphList.indexOf(value)][graphList.indexOf(way)]=false;
            }
        }
    }

    private void addWayMat(char value,char way){
        if(indexOnList(value)!=-1 && indexOnList(way)!=-1) {
            matrix[indexOnList(value)][indexOnList(way)] = true;
        }
        else{
            System.out.println("Nie ma takiego elementu!");
        }
    }

    @Override
    public String toString() {
        int index=0;
        String z;
        String s="Graf macierzy sasiedstwa:\n";
        for(Element el:graphList){
            s+="   "+el.getValue()+"  ";
        }
        s+="\n";
        for(int i=0;i<matrix.length;i++){
            s+=graphList.get(index).getValue()+" ";
            ++index;
            for(int j=0;j<matrix[0].length;j++){
                z=matrix[i][j]+" ";
                if(z.length()<6){
                    z+=" ";
                }
                s+=z;
            }
            s=s.substring(0,s.length()-2)+"\n";
        }
        return s;
    }
}