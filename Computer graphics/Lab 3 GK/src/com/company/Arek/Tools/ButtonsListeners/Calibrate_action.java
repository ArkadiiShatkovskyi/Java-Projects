package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Interface.Buttons.Button_Calibrate;
import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Calibrate_action extends Button_Calibrate implements ActionListener {


    public Calibrate_action(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, JTextField xPoint, JTextField yPoint) {
        super(left_panel_vector, left_panel_rastor, xPoint, yPoint);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(super.left_panel_vector.getPanel()==0){

            ArrayList<Polygon> elements = super.left_panel_vector.getLabel().getElements();
            toString(elements);
            double x=1;
            if(!super.xPoint.getText().equals("")){
                x=Double.parseDouble(super.xPoint.getText());
            }
            double y=1;
            if(!super.yPoint.getText().equals("")){
                y=Double.parseDouble(super.yPoint.getText());
            }

            double m[][]={{x,0,0},{0,y,0},{0,0,1}};
            ArrayList<Point.Double> points=new ArrayList<>();
            ArrayList<Polygon> afterMultiplication =new ArrayList<>();

            for(int i = 0; i< elements.size(); i++) {
                for(int n = 0; n< elements.get(i).npoints; n++){
                    double p[]={elements.get(i).xpoints[n], elements.get(i).ypoints[n],1};
                    double[] res=super.multiplication(m,p);
                    points.add(new Point.Double(res[0],res[1]));
                }
                afterMultiplication.add(createPolygon(points));
                points.clear();
            }
            toString(afterMultiplication);
            super.left_panel_vector.getLabel().setElements(afterMultiplication);
            super.left_panel_vector.getLabel().revalidate();
            super.left_panel_vector.getLabel().repaint();
        }else{

            double x=1;
            if(!super.xPoint.getText().equals("")){
                x=Double.parseDouble(super.xPoint.getText());
            }
            double y=1;
            if(!super.yPoint.getText().equals("")){
                y=Double.parseDouble(super.yPoint.getText());
            }

            BufferedImage image=left_panel_rastor.getLabel().getImage();
            if(image!=null){
                double x_t=Math.abs(x);
                double y_t=Math.abs(y);
                    double m[][]={{x_t,0,0},{0,y_t,0},{0,0,1}};
                    //double[] p4=super.getP(image.getWidth()-1,image.getHeight()-1,m);
                    double[] p1=super.getP(0,0,m);                   // konty obraza
                    double[] p2=super.getP(0,image.getHeight()-1,m);
                    double[] p3=super.getP(image.getWidth()-1,0,m);
                    double[] p4=super.getP(image.getWidth()-1,image.getHeight()-1,m);
                    double xs[]={Math.abs(p1[0]),Math.abs(p2[0]),Math.abs(p3[0]),Math.abs(p4[0])};
                    double ys[]={Math.abs(p1[1]),Math.abs(p2[1]),Math.abs(p3[1]),Math.abs(p4[1])};
                    int w=(int)(max(xs)-min(xs));
                    int h=(int)(max(ys)-min(ys));
                    BufferedImage newImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

                    double reverseM[][]=super.reverseMatrix(m);
                    for(int i=0;i<w;i++){
                        for (int j=0;j<h;j++){
                            double tepm[]={i,j,1};
                            double p[]=super.multiplication(reverseM,tepm);
                            int[] rgb;
                            boolean flag=super.left_panel_rastor.getLabel().isFlagNN();
                            if(flag){
                                rgb=color((int)p[0],(int)p[1],(int)p[0]+1,(int)p[1]+1,p[0],p[1],image,true);
                                newImage.setRGB(i,j,super.int2RGB(rgb[0],rgb[1],rgb[2]));}
                            else{
                                rgb=color((int)p[0],(int)p[1],(int)p[0]+1,(int)p[1]+1,p[0],p[1],image,false);
                                newImage.setRGB(i,j,super.int2RGB(rgb[0],rgb[1],rgb[2]));}
                            }
                        }
                    if(x<0 && y<0){super.left_panel_rastor.getLabel().changeImage(convertImage(newImage,super.left_panel_rastor.getLabel()));}
                    else if(x<0){super.left_panel_rastor.getLabel().changeImage(convertOne(newImage,true,super.left_panel_rastor.getLabel()));}
                    else if(y<0){super.left_panel_rastor.getLabel().changeImage(convertOne(newImage,false,super.left_panel_rastor.getLabel()));}
                    else{ super.left_panel_rastor.getLabel().changeImage(newImage);}
            }
        }

    }
}
