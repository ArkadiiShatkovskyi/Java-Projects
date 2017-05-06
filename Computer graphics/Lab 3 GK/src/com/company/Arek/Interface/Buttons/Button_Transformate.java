package com.company.Arek.Interface.Buttons;

import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Interface.Panels.Right_Panel;
import com.company.Arek.Tools.ButtonsListeners.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Transformate extends MyButton{

    protected Left_Panel_Rastor left_panel_rastor;
    protected Left_Panel_Vector left_panel_vector;
    protected Right_Panel right_panel;

    public Button_Transformate(Left_Panel_Vector left_panel_vector,Left_Panel_Rastor left_panel_rastor,Right_Panel right_panel){
        this.setText("Transformuj");
        this.left_panel_vector=left_panel_vector;
        this.left_panel_rastor=left_panel_rastor;
        this.right_panel=right_panel;
    }
}
