package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Interface.Buttons.Button_Add_to_List;
import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Interface.Panels.Right_Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToListButton extends Button_Add_to_List implements ActionListener {

    public AddToListButton(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, Right_Panel right_panel, JTextField xmPoint, JTextField ymPoint, JTextField xsPoint, JTextField ysPoint, JTextField alpha) {
        super(left_panel_vector, left_panel_rastor, right_panel, xmPoint, ymPoint, xsPoint, ysPoint, alpha);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(super.xmPoint!=null){                         /****************************  Przesunięcie  ****************************/
            double x=0;
            if(!super.xmPoint.getText().equals("")){
                x=Double.parseDouble(super.xmPoint.getText());
            }
            double y=0;
            if(!super.ymPoint.getText().equals("")){
                y=Double.parseDouble(super.ymPoint.getText());
            }

            double m[][]={{1,0,x},{0,1,y},{0,0,1}};
            super.right_panel.getLelements().addElementToList("P("+x+";"+y+")",m);
            System.out.println("Dodane przesunięcia: size:"+super.right_panel.getLelements().getSizeOfList());
        }else if(super.xsPoint!=null){                  /****************************  SKALOWANIE  ****************************/
            double x=1;
            if(!super.xsPoint.getText().equals("")){
                x=Double.parseDouble(super.xsPoint.getText());
            }
            double y=1;
            if(!super.ysPoint.getText().equals("")){
                y=Double.parseDouble(super.ysPoint.getText());
            }

            double m[][]={{x,0,0},{0,y,0},{0,0,1}};
            super.right_panel.getLelements().addElementToList("S("+x+";"+y+")",m);
            System.out.println("Dodane skalowania: size:"+super.right_panel.getLelements().getSizeOfList());
        }else if(alpha!=null){                                          /****************************  OBRÓT  ****************************/
            double alpha=0;
            if(!super.alpha.getText().equals("")){
                alpha= Double.parseDouble(super.alpha.getText());
            }
            double radians=Math.toRadians(alpha);

            double m[][]={{Math.cos(radians),-Math.sin(radians),0},{Math.sin(radians),Math.cos(radians),0},{0,0,1}};
            super.right_panel.getLelements().addElementToList("O("+alpha+")",m);
        }
    }
}
