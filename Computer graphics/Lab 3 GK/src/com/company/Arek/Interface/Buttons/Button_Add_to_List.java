package com.company.Arek.Interface.Buttons;

import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Interface.Panels.Right_Panel;
import com.company.Arek.Tools.ButtonsListeners.MyButton;

import javax.swing.*;

public class Button_Add_to_List extends MyButton{

    protected Left_Panel_Rastor left_panel_rastor;
    protected Left_Panel_Vector left_panel_vector;
    protected Right_Panel right_panel;
    protected JTextField xmPoint;
    protected JTextField ymPoint;
    protected JTextField xsPoint;
    protected JTextField ysPoint;
    protected JTextField alpha;

    public Button_Add_to_List(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, Right_Panel right_panel, JTextField xmPoint, JTextField ymPoint, JTextField xsPoint, JTextField ysPoint, JTextField alpha){
        this.setText("+");
        this.left_panel_vector=left_panel_vector;
        this.left_panel_rastor=left_panel_rastor;
        this.right_panel=right_panel;
        this.xmPoint=xmPoint;
        this.ymPoint=ymPoint;
        this.xsPoint=xsPoint;
        this.ysPoint=ysPoint;
        this.alpha=alpha;
    }
}
