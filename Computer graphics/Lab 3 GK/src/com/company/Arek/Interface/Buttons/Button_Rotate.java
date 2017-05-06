package com.company.Arek.Interface.Buttons;

import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Tools.ButtonsListeners.MyButton;

import javax.swing.*;

public class Button_Rotate extends MyButton {

    protected Left_Panel_Rastor left_panel_rastor;
    protected Left_Panel_Vector left_panel_vector;
    protected JTextField alpha;

    public Button_Rotate(Left_Panel_Vector left_panel_vector,Left_Panel_Rastor left_panel_rastor,JTextField alpha){
        this.setText("Obróc");
        this.left_panel_vector=left_panel_vector;
        //System.out.println("left panel vector: "+left_panel_vector);
        this.left_panel_rastor=left_panel_rastor;
        this.alpha=alpha;
    }
}
