package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Interface.Buttons.Button_Move;
import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Move_action extends Button_Move implements ActionListener{

    private ArrayList<Polygon> elements;
    //private ArrayList<Rastor_Image> rastor_images;

    public Move_action(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, JTextField xPoint, JTextField yPoint) {
        super(left_panel_vector, left_panel_rastor, xPoint, yPoint);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(super.left_panel_vector.getPanel()==0){

            elements=super.left_panel_vector.getLabel().getElements();
            toString(elements);
            double x=0;
            if(!super.xPoint.getText().equals("")){
                x= Double.parseDouble(super.xPoint.getText());
            }
            double y=0;
            if(!super.yPoint.getText().equals("")){
                y=Double.parseDouble(super.yPoint.getText());
            }

            double m[][]={{1,0,x},{0,1,y},{0,0,1}};
            ArrayList<Point.Double> points=new ArrayList<>();
            ArrayList<Polygon> afterMultiplication =new ArrayList<>();

            for(int i=0;i<elements.size();i++) {
                for(int n=0;n<elements.get(i).npoints;n++){
                    double p[]={elements.get(i).xpoints[n],elements.get(i).ypoints[n],1};
                    double[] res=super.multiplication(m,p);
                    points.add(new Point.Double(res[0],res[1]));
            }
            toString(afterMultiplication);
            afterMultiplication.add(createPolygon(points));
            points.clear();
        }
            super.left_panel_vector.getLabel().setElements(afterMultiplication);
            super.left_panel_vector.getLabel().revalidate();
            super.left_panel_vector.getLabel().repaint();
        }else{


            double x=0;
            if(!super.xPoint.getText().equals("")){
                x=Double.parseDouble(super.xPoint.getText());
            }
            double y=0;
            if(!super.yPoint.getText().equals("")){
                y=Double.parseDouble(super.yPoint.getText());
            }
            double m[][]={{1,0,x},{0,1,y},{0,0,1}};

            int xp=super.left_panel_rastor.getLabel().getIx();
            int yp=super.left_panel_rastor.getLabel().getIy();

            double temp[]={xp,yp,1};

            temp=super.multiplication(m,temp);
            super.left_panel_rastor.getLabel().setIXY((int)temp[0],(int)temp[1]);
        }
    }
}
