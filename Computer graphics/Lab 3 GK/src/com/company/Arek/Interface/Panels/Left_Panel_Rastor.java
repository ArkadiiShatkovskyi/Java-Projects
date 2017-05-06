package com.company.Arek.Interface.Panels;

import com.company.Arek.Interface.OtherElements.ImageW;
import com.company.Arek.Tools.Rastor_label;
import com.company.Arek.Tools.Vector_label;

import javax.swing.*;
import java.awt.*;

public class Left_Panel_Rastor extends JPanel{

    private Left_Panel left_panel;
    private Rastor_label rastor_label;

    public Left_Panel_Rastor(int size_x, int size_y,Left_Panel left_panel){
        this.setLayout(new GridBagLayout());
        this.setSize(size_x,size_y);
        this.left_panel=left_panel;
        Rastor_label rl=new Rastor_label(size_x,size_y);
        this.add(rl);
        this.rastor_label=rl;
    }

    public void setImage(ImageW image){
        this.add(image);
        JScrollPane scroll=new JScrollPane(image);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public Rastor_label getLabel() {
        return rastor_label;
    }

    /*public Vector_label getV_label(){
        return rastor_label;
    }*/
}
