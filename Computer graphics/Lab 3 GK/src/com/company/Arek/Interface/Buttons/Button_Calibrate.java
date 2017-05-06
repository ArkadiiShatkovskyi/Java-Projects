package com.company.Arek.Interface.Buttons;

import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Tools.ButtonsListeners.MyButton;

import javax.swing.*;

public class Button_Calibrate extends MyButton {

    protected Left_Panel_Rastor left_panel_rastor;
    protected Left_Panel_Vector left_panel_vector;
    protected JTextField xPoint;
    protected JTextField yPoint;

    public Button_Calibrate(Left_Panel_Vector left_panel_vector,Left_Panel_Rastor left_panel_rastor,JTextField xPoint,JTextField yPoint){
        this.setText("Skaluj");
        this.left_panel_vector=left_panel_vector;
        //System.out.println("left panel vector: "+left_panel_vector);
        this.left_panel_rastor=left_panel_rastor;
        this.xPoint=xPoint;
        this.yPoint=yPoint;
    }
}
