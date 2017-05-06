package com.company.Arek.Interface.Panels;

import com.company.Arek.Interface.OtherElements.List_of_Transformations;
import com.company.Arek.Tools.ButtonsListeners.*;

import javax.swing.*;
import java.awt.*;

public class Right_Panel extends JPanel {

    private List_of_Transformations lelements;

    public Right_Panel(int size_x,int size_y, Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor){
        this.setSize(size_x,size_y);
        this.setLayout(new BorderLayout());
        lelements=new List_of_Transformations(new DefaultListModel<>());

        JPanel panel1=new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=10;
        panel1.add(new JLabel("Transformacje obiektu"),c);

        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=10;
        panel1.add(new JLabel("\n"),c);

        /********** Button move **********/


        JPanel pp=new JPanel(new GridBagLayout());
        GridBagConstraints cbc=new GridBagConstraints();

        JLabel xl=new JLabel("x:");
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=0;
        cbc.gridy=0;
        pp.add(xl,cbc);
        JTextField xpText=new JTextField(5);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=1;
        cbc.gridy=0;
        pp.add(xpText,cbc);
        JLabel yl=new JLabel("y:");
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=2;
        cbc.gridy=0;
        pp.add(yl,cbc);
        JTextField ypText=new JTextField(5);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=3;
        cbc.gridy=0;
        pp.add(ypText,cbc);
        AddToListButton addMove=new AddToListButton(left_panel_vector,left_panel_rastor,this,xpText,ypText,null,null,null);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=4;
        cbc.gridy=0;
        pp.add(addMove,cbc);
        Move_action bm=new Move_action(left_panel_vector,left_panel_rastor,xpText,ypText);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridwidth=10;
        cbc.gridx=0;
        cbc.gridy=1;
        pp.add(bm,cbc);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=2;
        panel1.add(pp,c);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=10;
        panel1.add(new JLabel("\n"),c);

        /********** Button calibrate **********/

        JPanel ps=new JPanel(new GridBagLayout());
        GridBagConstraints cbc2=new GridBagConstraints();

        JLabel xs=new JLabel("x:");
        cbc2.fill=GridBagConstraints.HORIZONTAL;
        cbc2.gridx=0;
        cbc2.gridy=0;
        ps.add(xs,cbc2);
        JTextField xsText=new JTextField(5);
        cbc2.fill=GridBagConstraints.HORIZONTAL;
        cbc2.gridx=1;
        cbc2.gridy=0;
        ps.add(xsText,cbc2);
        JLabel ys=new JLabel("y:");
        cbc2.fill=GridBagConstraints.HORIZONTAL;
        cbc2.gridx=2;
        cbc2.gridy=0;
        ps.add(ys,cbc2);
        JTextField ysText=new JTextField(5);
        cbc2.fill=GridBagConstraints.HORIZONTAL;
        cbc2.gridx=3;
        cbc2.gridy=0;
        ps.add(ysText,cbc2);
        AddToListButton addCalibrate=new AddToListButton(left_panel_vector,left_panel_rastor,this,null,null,xsText,ysText,null);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=4;
        cbc.gridy=0;
        ps.add(addCalibrate,cbc);
        Calibrate_action bs=new Calibrate_action(left_panel_vector,left_panel_rastor,xsText,ysText);
        cbc2.fill=GridBagConstraints.HORIZONTAL;
        cbc2.gridwidth=10;
        cbc2.gridx=0;
        cbc2.gridy=1;
        ps.add(bs,cbc2);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=4;
        panel1.add(ps,c);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=10;

        panel1.add(new JLabel("\n"),c);

        /********** Button rotate **********/

        JPanel po=new JPanel(new GridBagLayout());
        GridBagConstraints cbc3=new GridBagConstraints();

        JLabel fi=new JLabel("φ:");
        cbc3.fill=GridBagConstraints.HORIZONTAL;
        cbc3.gridx=0;
        cbc3.gridy=0;
        po.add(fi,cbc3);
        JTextField fiText=new JTextField(5);
        cbc3.fill=GridBagConstraints.HORIZONTAL;
        cbc3.gridx=1;
        cbc3.gridy=0;
        po.add(fiText,cbc3);
        AddToListButton addRotate=new AddToListButton(left_panel_vector,left_panel_rastor,this,null,null,null,null,fiText);
        cbc.fill=GridBagConstraints.HORIZONTAL;
        cbc.gridx=2;
        cbc.gridy=0;
        po.add(addRotate,cbc);
        Rotate_action br=new Rotate_action(left_panel_vector,left_panel_rastor,fiText);
        cbc3.gridwidth=10;
        cbc3.fill=GridBagConstraints.HORIZONTAL;
        cbc3.gridx=0;
        cbc3.gridy=1;
        po.add(br,cbc3);

        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=6;

        panel1.add(po,c);

        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=7;
        c.gridwidth=10;

        panel1.add(new JLabel("\n"),c);

        /********** Button transformate **********/

        JPanel pt=new JPanel(new GridBagLayout());
        GridBagConstraints cbc4=new GridBagConstraints();

        JLabel t=new JLabel("Transformacja zlożona");
        cbc4.fill=GridBagConstraints.HORIZONTAL;
        cbc4.gridx=0;
        cbc4.gridy=0;
        cbc4.gridwidth=10;
        pt.add(t,cbc4);
        cbc4.fill=GridBagConstraints.HORIZONTAL;
        cbc4.gridx=0;
        cbc4.gridy=1;
        cbc4.gridwidth=10;
        pt.add(new JLabel("\n"),cbc4);
        Transformate_Action bt=new Transformate_Action(left_panel_vector,left_panel_rastor,this);
        cbc4.fill=GridBagConstraints.HORIZONTAL;
        cbc4.gridx=0;
        cbc4.gridy=2;
        cbc4.gridwidth=10;
        pt.add(bt,cbc4);
        cbc4.fill=GridBagConstraints.HORIZONTAL;
        cbc4.gridx=0;
        cbc4.gridy=3;
        cbc4.gridwidth=10;
        pt.add(new JLabel("\n"),cbc4);
        /// add list to panel
        cbc4.fill=GridBagConstraints.HORIZONTAL;
        cbc4.gridx=0;
        cbc4.gridy=4;
        cbc4.gridwidth=10;
        cbc4.gridheight=20;
        pt.add(lelements,cbc4);

        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=8;

        panel1.add(pt,c);

        this.add(panel1,BorderLayout.NORTH);
    }

    public List_of_Transformations getLelements(){
        return lelements;
    }
}
