package com.company.Arek.Tools.MenuOptionsListeners;

import com.company.Arek.Interface.Panels.Left_Panel_Rastor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class OpenRastorImageListener implements ActionListener {


        private Left_Panel_Rastor panel;
        private String path;

        public OpenRastorImageListener(Left_Panel_Rastor panel){
            this.panel=panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FileFilter filter=new FileNameExtensionFilter("Image jpg","jpg","jpeg");

            JFileChooser chooser=new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            chooser.addChoosableFileFilter(filter);
            int r=chooser.showDialog(panel,"chooice dialog");

            if(r==JFileChooser.APPROVE_OPTION){
                String name=chooser.getSelectedFile().getPath();
                path=name;
                //label.setIcon(new ImageIcon(name));
                try {
                    BufferedImage bi=ImageIO.read(chooser.getSelectedFile());
                    panel.getLabel().addImage(bi);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }


