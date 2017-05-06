package com.company.Arek.Interface;

import com.company.Arek.Interface.Panels.Left_Panel;
import com.company.Arek.Interface.Panels.Right_Panel;
import com.company.Arek.Tools.MenuOptionsListeners.OpenRastorImageListener;
import com.company.Arek.Tools.MenuOptionsListeners.OpenVectorImageListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame(int size_X, int size_Y){
        this.setMinimumSize(new Dimension(size_X,size_Y));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { "Wektorowe", "Rastrowe" };
        Left_Panel left_panel = new Left_Panel(1000,800);
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(left_panel);
        comboBoxPane.add(cb);
        left_panel.addComponentToPane();

        System.out.println("left panel frame: "+left_panel);
        Right_Panel right_panel=new Right_Panel(50,800,left_panel.getLeft_panel_vector(),left_panel.getLeft_panel_rastor());
        this.add(right_panel,BorderLayout.EAST);
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(left_panel,BorderLayout.CENTER);

        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Menu");

        //saveImage.addActionListener(sbl);

        JMenuItem openImage=new JMenuItem("Załaduj wektorowy obraz");
        menu.add(openImage);
        OpenVectorImageListener op=new OpenVectorImageListener(left_panel.getLeft_panel_vector());
        openImage.addActionListener(op);

        JMenuItem loadElements=new JMenuItem("Załąduj rastrowy obraz");
        menu.add(loadElements);
        OpenRastorImageListener or=new OpenRastorImageListener(left_panel.getLeft_panel_rastor());
        loadElements.addActionListener(or);

        JMenuItem algorytm1=new JMenuItem("Algorytm1");
        algorytm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left_panel.getLeft_panel_rastor().getLabel().setFlagNN(true);
                System.out.println("Zminiono na algorytm 1");
            }
        });

        menu.add(algorytm1);

        JMenuItem algorytm2=new JMenuItem("Algorytm NN");
        algorytm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left_panel.getLeft_panel_rastor().getLabel().setFlagNN(false);
                System.out.println("Zminiono na algorytm NN");
            }
        });

        menu.add(algorytm2);

        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }


}
