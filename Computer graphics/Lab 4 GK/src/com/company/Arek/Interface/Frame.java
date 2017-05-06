package com.company.Arek.Interface;

import com.company.Arek.Tools.ModeListener;
import com.company.Arek.Tools.SaveListener;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private boolean flag;

    public Frame(int size_X, int size_Y){
        this.setMinimumSize(new Dimension(size_X,size_Y));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.flag=true;



        GridBagConstraints c = new GridBagConstraints();

        LeftBottomPanel leftBottom=new LeftBottomPanel(600,400);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=1;

        this.add(leftBottom,c);

        LeftTopPanel leftUpper=new LeftTopPanel(600,400,leftBottom.getGlEventListener());
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        c.insets=new Insets(0,3,0,3);

        this.add(leftUpper,c);

        RightTopPanel rightUpper=new RightTopPanel(600,400,leftBottom.getGlEventListener());
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=0;

        this.add(rightUpper,c);

        RightBottomPanel rightBottom=new RightBottomPanel(600,400,leftBottom.getGlEventListener());
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=1;
        this.add(rightBottom,c);

        /************/
        leftUpper.setPanel1(rightBottom.getPanel());
        leftUpper.setPanel2(rightUpper.getPanel());

        rightUpper.setPanel1(leftUpper.getPanel());
        rightUpper.setPanel2(rightBottom.getPanel());

        rightBottom.setPanel1(leftUpper.getPanel());
        rightBottom.setPanel2(rightUpper.getPanel());
        /************/

        InfoPanel bottomPanel=new InfoPanel(100,50);
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=2;
        this.add(bottomPanel,c);

        leftBottom.getGlEventListener().setInfoPanel(bottomPanel);

        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Menu");

        JMenuItem openImage=new JMenuItem("Save");
        openImage.addActionListener(new SaveListener(leftBottom.getGlEventListener()));
        menu.add(openImage);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void setFlag(boolean flag){
        this.flag=flag;
    }
}
