package com.company.Arek.Interface.OtherElements;

import javax.swing.*;
import java.util.ArrayList;

public class List_of_Transformations extends JList {

    private DefaultListModel listModel;
    private ArrayList<String> lelements;
    private ArrayList<double[][]> listOfMatrix;

    public List_of_Transformations(ListModel dataModel) {
        super(dataModel);
        lelements=new ArrayList<>();
        listOfMatrix=new ArrayList<>();
        this.listModel= (DefaultListModel) dataModel;
        JScrollPane scroll=new JScrollPane(this);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        for(int i=0;i<lelements.size();i++){
            listModel.addElement(lelements.get(i));
        }
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addElementToList(String s,double[][] matrix){
        lelements.add(s);
        listOfMatrix.add(matrix);
        listModel.addElement(s);
    }

    public void clearList(){
        lelements.clear();
        listOfMatrix.clear();
        listModel.clear();
    }

    public void deleteElement(int i){
        lelements.remove(i);
        listOfMatrix.remove(i);
        listModel.remove(i);
    }

    public int getSizeOfList(){
        return listOfMatrix.size();
    }

    public double[][] getElement(int i){
        return listOfMatrix.get(i);
    }
}
