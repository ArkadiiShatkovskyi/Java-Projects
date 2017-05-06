package com.company.Arek.Interface.Panels;

import com.company.Arek.Tools.Vector_label;

import javax.swing.*;
import java.awt.*;

public class Left_Panel_Vector extends JPanel {

    private Vector_label label;
    private Left_Panel left_panel;

    public Left_Panel_Vector(int size_x, int size_y,Left_Panel left_panel){
        this.left_panel=left_panel;
        System.out.println("vector label construktor: "+label);
        this.setLayout(new GridBagLayout());
        this.setSize(size_x,size_y);

        Vector_label vl=new Vector_label(size_x,size_y);
        this.add(vl);
        this.label = vl;

        JScrollPane scroll=new JScrollPane(this);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public Vector_label getLabel() {
        return label;
    }

    public int getPanel() {
        return left_panel.getPanel();
    }
}
