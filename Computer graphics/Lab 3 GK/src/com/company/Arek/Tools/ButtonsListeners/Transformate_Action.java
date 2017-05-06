package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Interface.Buttons.Button_Transformate;
import com.company.Arek.Interface.Panels.Left_Panel_Rastor;
import com.company.Arek.Interface.Panels.Left_Panel_Vector;
import com.company.Arek.Interface.Panels.Right_Panel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Transformate_Action extends Button_Transformate implements ActionListener {

    public Transformate_Action(Left_Panel_Vector left_panel_vector, Left_Panel_Rastor left_panel_rastor, Right_Panel right_panel) {
        super(left_panel_vector, left_panel_rastor,right_panel);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(super.left_panel_vector.getPanel()==0){
        int size=super.right_panel.getLelements().getSizeOfList();
            double result[][]= super.multiplicationMatrix(super.right_panel.getLelements().getElement(0),super.right_panel.getLelements().getElement(1));

            if(size>2){
                for(int i=2;i<size;i++){
                    result=super.multiplicationMatrix(result,super.right_panel.getLelements().getElement(i));
                }
            }

            ArrayList<Polygon> elements=super.left_panel_vector.getLabel().getElements();
            ArrayList<Point.Double> points=new ArrayList<>();
            ArrayList<Polygon> afterMultiplication =new ArrayList<>();

            for(int i=0;i<elements.size();i++) {
                for(int n=0;n<elements.get(i).npoints;n++){
                    double p[]={elements.get(i).xpoints[n],elements.get(i).ypoints[n],1};
                    double[] res=super.multiplication(result,p);
                    points.add(new Point.Double(res[0],res[1]));
                }
                toString(afterMultiplication);
                afterMultiplication.add(createPolygon(points));
                points.clear();
            }

            super.right_panel.getLelements().clearList();
            super.left_panel_vector.getLabel().setElements(afterMultiplication);
            super.left_panel_vector.getLabel().revalidate();
            super.left_panel_vector.getLabel().repaint();
        }else{
            int size=super.right_panel.getLelements().getSizeOfList();

            /*double result[][]= super.multiplicationMatrix(super.right_panel.getLelements().getElement(0),super.right_panel.getLelements().getElement(1));

            if(size>2){
                for(int i=2;i<size;i++){
                    result=super.multiplicationMatrix(result,super.right_panel.getLelements().getElement(i));
                }
            }*/

            ArrayList<double[][]> el=new ArrayList<>();
            for(int i=0;i<size;i++){
                double[][] t=super.right_panel.getLelements().getElement(i);
                if(t[0][0]==1 && t[1][0]==0 &&t[2][0]>0){
                    int xp=super.left_panel_rastor.getLabel().getIx();
                    int yp=super.left_panel_rastor.getLabel().getIy();

                    double temp[]={xp,yp,1};

                    temp=super.multiplication(t,temp);
                    super.left_panel_rastor.getLabel().setIXY((int)temp[0],(int)temp[1]);
                    super.right_panel.getLelements().deleteElement(i);
                }else{
                    el.add(t);
                }
            }
            double result[][]= super.right_panel.getLelements().getElement(0);
            for(int i=1;i<el.size();i++){
                result=super.multiplicationMatrix(result,super.right_panel.getLelements().getElement(i));
            }
            double x=result[0][0];
            double y=result[1][1];

            result[0][0]=Math.abs(x);
            System.out.println("R[0][0]: "+result[0][0]);
            result[1][1]=Math.abs(y);
            System.out.println("R[1][1]: "+result[1][1]);

            BufferedImage image=left_panel_rastor.getLabel().getImage();

            double[] p1=super.getP(0,0,result);                   // konty obraza
            double[] p2=super.getP(0,image.getHeight()-1,result);
            double[] p3=super.getP(image.getWidth()-1,0,result);
            double[] p4=super.getP(image.getWidth()-1,image.getHeight()-1,result);
            double xs[]={Math.abs(p1[0]),Math.abs(p2[0]),Math.abs(p3[0]),Math.abs(p4[0])};
            double ys[]={Math.abs(p1[1]),Math.abs(p2[1]),Math.abs(p3[1]),Math.abs(p4[1])};
            int w=(int)(max(xs)-min(xs));
            int h=(int)(max(ys)-min(ys));
            BufferedImage newImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

            double reverseM[][]=super.reverseMatrix(result);
            for(int i=0;i<w;i++){
                for (int j=0;j<h;j++){
                    double tepm[]={i,j,1};
                    double p[]=super.multiplication(reverseM,tepm);
                    int[] rgb=color((int)p[0],(int)p[1],(int)p[0]+1,(int)p[1]+1,p[0],p[1],image,true);
                    newImage.setRGB(i,j,super.int2RGB(rgb[0],rgb[1],rgb[2]));
                }
            }
            if(x<0 && y<0){super.left_panel_rastor.getLabel().changeImage(convertImage(newImage,super.left_panel_rastor.getLabel()));}
            else if(x<0){super.left_panel_rastor.getLabel().changeImage(convertOne(newImage,true,super.left_panel_rastor.getLabel()));}
            else if(y<0){super.left_panel_rastor.getLabel().changeImage(convertOne(newImage,false,super.left_panel_rastor.getLabel()));}
            else{ super.left_panel_rastor.getLabel().changeImage(newImage);}
            super.right_panel.getLelements().clearList();
        }
    }
}
