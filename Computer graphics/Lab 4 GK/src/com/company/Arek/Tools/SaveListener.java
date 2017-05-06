package com.company.Arek.Tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveListener implements ActionListener {

    private PerspectiveGLEventListener glEventListener;

    public SaveListener(PerspectiveGLEventListener glEventListener){
        this.glEventListener=glEventListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<Triangle> triangles=glEventListener.getTriangles();
        double[] perspective=glEventListener.getPerspective();
        float[] lefttop=glEventListener.getLeftTop();
        float[] righttop=glEventListener.getRightTop();
        float[] rightbottom=glEventListener.getRightBottom();
        float ambient[]=glEventListener.getAmbient();
        float diffuse[]=glEventListener.getDiffuse();
        float position[]=glEventListener.getPossition();
        float lmodel_ambient[]=glEventListener.getLmodelAmbient();
        float local_view[]=glEventListener.getLocalView();
        float no_mat[]=glEventListener.getNoMat();
        float mat_specular[]=glEventListener.getMatSpecular();
        float hight_shininess[]=glEventListener.getShininess();

        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("H:\\Work spaces\\IdeaProjects\\Lab 4 GK\\save.txt"));

            for(double d:perspective){
                bufferedWriter.write(d+System.lineSeparator());
            }
            String result=createS("","lefttop",lefttop);
            result=createS(result,"rightbottom",rightbottom);
            result=createS(result,"righttop",righttop);
            result=createS(result,"ambient",ambient);
            result=createS(result,"diffuse",diffuse);
            result=createS(result,"position",position);
            result=createS(result,"lmodel_ambient",lmodel_ambient);
            result=createS(result,"local_view",local_view);
            result=createS(result,"nomat",no_mat);
            result=createS(result,"mat_specular",mat_specular);
            result=createS(result,"hight_shininess",hight_shininess);
            result+="triangles"+System.lineSeparator();

            for(Triangle t:triangles){
                result+=t.toString()+System.lineSeparator()+System.lineSeparator();
            }
            bufferedWriter.write(result);

            bufferedWriter.close();
            System.out.println("SAVED!");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private String createS(String result,String name, float[] elements){
        result+=name+System.lineSeparator();
        for(float f: elements){
            result+=f+System.lineSeparator();
        }
        return result;
    }
}
