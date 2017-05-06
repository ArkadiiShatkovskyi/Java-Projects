package com.company.Arek.Interface.Panels;

import com.company.Arek.Tools.Rastor_label;
import com.company.Arek.Tools.Vector_label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Left_Panel extends JPanel implements ItemListener {

    private final static String vector = "Wektorowe";
    private final static String rastor = "Rastrowe";
    private int size_x;
    private int size_y;
    private Left_Panel_Vector left_panel_vector;
    private Left_Panel_Rastor left_panel_rastor;
    protected int panel;

    public Left_Panel(int size_x,int size_y){
        this.size_x=size_x;
        this.size_y=size_y;
        this.setSize(size_x,size_y);
        this.panel=0;
    }

    public void addComponentToPane() {

        Left_Panel_Vector panel_vector=new Left_Panel_Vector(size_x,size_y,this);
        this.left_panel_vector=panel_vector;

        Left_Panel_Rastor panel_rastor = new Left_Panel_Rastor(size_x,size_y, this);
        this.left_panel_rastor=panel_rastor;

        this.setLayout(new CardLayout());
        this.add(panel_vector,vector);
        this.add(panel_rastor,rastor);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, (String)e.getItem());
        if(e.getItem().equals(vector)){
            panel=0;
            System.out.println("Vector panel 1235432: " + left_panel_vector.getLabel());
        }else{
            panel=1;

            System.out.println("Rastor panel 1235432: " + left_panel_rastor.getLabel());
        }
    }

    public Left_Panel_Vector getLeft_panel_vector() {
        return left_panel_vector;
    }

    public Left_Panel_Rastor getLeft_panel_rastor() {
        return left_panel_rastor;
    }

    public int getPanel(){
        return panel;
    }
}
