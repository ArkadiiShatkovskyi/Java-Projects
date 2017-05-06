package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Interface.Buttons.Button_Rotate;
import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Rotate_action extends Button_Rotate implements ActionListener {

    private boolean flag;
    public Rotate_action(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, JTextField alpha) {
        super(left_panel_vector, left_panel_rastor, alpha);
        this.flag=flag;
        this.addActionListener(this);
    }

    public void setFlag(boolean flag){
        this.flag=flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(super.left_panel_vector.getPanel()==0){

            ArrayList<Polygon> elements = super.left_panel_vector.getLabel().getElements();
            toString(elements);
            double fi=0;
            if(!super.alpha.getText().equals("")){
                fi= Double.parseDouble(super.alpha.getText());
            }
            double radians=Math.toRadians(fi);

            double m[][]={{Math.cos(radians),-Math.sin(radians),0},{Math.sin(radians),Math.cos(radians),0},{0,0,1}};
            ArrayList<Point.Double> points=new ArrayList<>();
            ArrayList<Polygon> afterMultiplication =new ArrayList<>();

            for(int i = 0; i< elements.size(); i++) {
                for(int n = 0; n< elements.get(i).npoints; n++){
                    double p[]={elements.get(i).xpoints[n], elements.get(i).ypoints[n],1};
                    double res[]=super.multiplication(m,p);
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
            double fi=0;
            if(!super.alpha.getText().equals("")){
                fi= Double.parseDouble(super.alpha.getText());
            }
            double radians=Math.toRadians(fi);

            BufferedImage image=left_panel_rastor.getLabel().getImage();
            System.out.println("IX: "+image.getWidth()+"IY: "+image.getHeight());
            if(image!=null){
                double m[][]={{Math.cos(radians),-Math.sin(radians),0},{Math.sin(radians),Math.cos(radians),0},{0,0,1}};
                double[] p1=super.getP(0,0,m);                   // konty obraza
                double[] p2=super.getP(0,image.getHeight()-1,m);
                double[] p3=super.getP(image.getWidth()-1,0,m);
                double[] p4=super.getP(image.getWidth()-1,image.getHeight()-1,m);
                //double xs[]={Math.abs(p1[0]),Math.abs(p2[0]),Math.abs(p3[0]),Math.abs(p4[0])};
                double xs[]={p1[0],p2[0],p3[0],p4[0]};
                double ys[]={p1[1],p2[1],p3[1],p4[1]};
                System.out.println("p1: "+p1[0]+','+p1[1]+"; "+"p2: "+p2[0]+','+p2[1]+"; "+"p3: "+p3[0]+','+p3[1]+"; "+"p4: "+p4[0]+','+p4[1]+"; ");
                int w=(int)(max(xs)-min(xs));
                //int w=(int)max(xs);
                int h=(int)(max(ys)-min(ys));

                BufferedImage newImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

                double reverseM[][]=super.reverseMatrix(m);
                System.out.println("H:"+h+", w:"+w);
                for(int i=0;i<w;i++){
                    for (int j=0;j<h;j++){
                        double tepm[]={i,j,1};
                        double p[]=super.multiplication(reverseM,tepm);
                        int[] rgb;
                        rgb=color((int)p[0],(int)p[1],(int)p[0]+1,(int)p[1]+1,p[0],p[1],image,flag);

                        newImage.setRGB(i,j,super.int2RGB(rgb[0],rgb[1],rgb[2]));
                    }
                }
                Point2D.Double point=new Point2D.Double(super.left_panel_rastor.getLabel().getIx(),super.left_panel_rastor.getLabel().getIy());

                //double p[]={point.getX(),point.getY(),1};
                double p[]={min(xs),min(ys),1};
                //p=super.multiplication(m,p);
                super.left_panel_rastor.getLabel().setIXY((int)(p[0]),(int)(p[1]));
                super.left_panel_rastor.getLabel().changeImage(newImage);
            }
        }
    }
}
