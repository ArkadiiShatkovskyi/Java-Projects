package com.company.Arek.Tools;

import com.jogamp.opengl.awt.GLCanvas;

import javax.vecmath.Point3f;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyGLEventListener extends GLCanvas {

    protected ArrayList<Triangle> triangles;
    protected float[] perspective;
    protected float[] lefttop;
    protected float[] righttop;
    protected float[] rightbottom;
    protected float ambient[];
    protected float diffuse[];
    protected float position[];
    protected float lmodel_ambient[];
    protected float local_view[];
    protected float no_mat[];
    protected float mat_specular[];
    protected float hight_shininess[];
    private boolean flag;

    public MyGLEventListener(){
        triangles=new ArrayList<>();
        perspective=new float[9];
        lefttop=new float[6];
        righttop=new float[6];
        rightbottom=new float[6];
        ambient=new float[4];
        diffuse=new float[4];
        position=new float[4];
        lmodel_ambient=new float[4];
        local_view=new float[1];
        no_mat=new float[4];
        mat_specular=new float[4];
        hight_shininess=new float[1];
        flag=false;
        readSettings();
    }

    protected void readSettings(){

        try {
            BufferedReader br=new BufferedReader(new FileReader("H:\\Work spaces\\IdeaProjects\\Lab 4 GK\\knot.txt"));
            //BufferedReader br=new BufferedReader(new FileReader("H:\\Work spaces\\IdeaProjects\\Lab 4 GK\\save.txt"));
            //BufferedReader br=new BufferedReader(new FileReader("H:\\Work spaces\\IdeaProjects\\Lab 4 GK\\scene.txt"));
            int line=1;
            int index=0;
            for(int i=1;i<65;i++){
                String readL = br.readLine();
                //System.out.println("Element: "+readL);
                if(line<65) {
                    if (line == 10 || line == 17 || line == 24 || line == 24 || line == 31 || line == 36 || line == 41 || line == 46 || line == 51 || line == 53 || line == 58 || line == 63) {
                        index = 0;
                    } else if (line < 10) {
                        perspective[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 10 && line < 17) {
                        lefttop[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 17 && line < 24) {
                        rightbottom[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 24 && line < 31) {
                        righttop[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 31 && line < 36) {
                        ambient[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 36 && line < 41) {
                        diffuse[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 41 && line < 46) {
                        position[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 46 && line < 51) {
                        lmodel_ambient[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line == 52) {
                        local_view[index]= Float.parseFloat(readL);
                    } else if (line > 53 && line < 58) {
                        no_mat[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line > 58 && line < 63) {
                        mat_specular[index] = Float.parseFloat(readL);
                        index++;
                    } else if (line == 64) {
                        hight_shininess[index] = Float.parseFloat(readL);
                    }
                    line++;
                }
            }
            br.readLine();
            float tb[]=new float[12];
            for(int j=0;j<2880;j++){  //12  /1024   /2880
                for(int i=0;i<12;i++){
                    tb[i]=Float.parseFloat(br.readLine());
                }
                triangles.add(new Triangle(tb[0],tb[1],tb[2],tb[3],tb[4],tb[5],tb[6],tb[7],tb[8],tb[9],tb[10],tb[11]));
                br.readLine();
            }
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        setTrianglesToPoints();
    }

    protected float min(ArrayList<Float> list){
        float result=0;
        for(int i=0;i<list.size();i++){
            result=i==0? Math.min(list.get(i),list.get(i+1)):Math.min(result,list.get(i));
        }

        return result;
    }

    protected float max(ArrayList<Float> list){
        float result=0;
        for(int i=0;i<list.size();i++){
            result=i==0? Math.max(list.get(i),list.get(i+1)):Math.max(result,list.get(i));
        }
        return result;
    }

    protected void setNormals(){
        //if(!flag){
            //System.out.println("TUTaj!");
        for(int i = 0; i< triangles.size(); i++){
            triangles.get(i).setNormal(getNormalTriangle(triangles.get(i).getP1(),triangles.get(i).getP2(),triangles.get(i).getP3()));
        }
        for (int i = 0; i< triangles.size(); i++){

            /******************************************************************/
            /*if(triangles.get(i).getP1Triangles().size()==0){
                System.out.println("DO NOT FOUND: [x:"+triangles.get(i).getX1()+"; y:"+triangles.get(i).getY1()+"; z:"+triangles.get(i).getZ1()+ "]\n");
            }

            if(triangles.get(i).getP2Triangles().size()==0){
                System.out.println("DO NOT FOUND: [x:"+triangles.get(i).getX2()+"; y:"+triangles.get(i).getY2()+"; z:"+triangles.get(i).getZ2()+ "]\n");
            }

            if(triangles.get(i).getP3Triangles().size()==0){
                System.out.println("DO NOT FOUND: [x:"+triangles.get(i).getX3()+"; y:"+triangles.get(i).getY3()+"; z:"+triangles.get(i).getZ3()+ "]\n");
            }*/
            /******************************************************************/

            if(triangles.get(i).getNormalP1()==null){
                Point3f n1=calculatePointNormal(triangles.get(i).getP1Triangles());
                triangles.get(i).setNormalP1(n1);
                for(Triangle t:triangles.get(i).getP1Triangles()){
                    if(triangles.get(i).getP1().equals(t.getP1())){
                        t.setNormalP1(n1);
                    }else if(triangles.get(i).getP1().equals(t.getP2())){
                        t.setNormalP2(n1);
                    }else if(triangles.get(i).getP1().equals(t.getP3())){
                        t.setNormalP3(n1);
                    }}
            }

            if(triangles.get(i).getNormalP2()==null){
                Point3f n1=calculatePointNormal(triangles.get(i).getP2Triangles());
                triangles.get(i).setNormalP2(n1);
                for(Triangle t:triangles.get(i).getP2Triangles()){
                    if(triangles.get(i).getP2().equals(t.getP1())){
                        t.setNormalP1(n1);
                    }else if(triangles.get(i).getP2().equals(t.getP2())){
                        t.setNormalP2(n1);
                    }else if(triangles.get(i).getP2().equals(t.getP3())){
                        t.setNormalP3(n1);
                    }
                }
            }

            if(triangles.get(i).getNormalP3()==null){
                Point3f n1=calculatePointNormal(triangles.get(i).getP3Triangles());
                triangles.get(i).setNormalP3(n1);
                for(Triangle t:triangles.get(i).getP3Triangles()){
                    if(triangles.get(i).getP3().equals(t.getP1())){
                        t.setNormalP1(n1);
                    }else if(triangles.get(i).getP3().equals(t.getP2())){
                        t.setNormalP2(n1);
                    }else if(triangles.get(i).getP3().equals(t.getP3())){
                        t.setNormalP3(n1);
                    }
                }
            }
//triangles.get(i).setNormalP1(calculatePointNormal(triangles.get(i).getP1Triangles()));
//triangles.get(i).setNormalP2(calculatePointNormal(triangles.get(i).getP2Triangles()));
//System.out.println("P2: "+ triangles.get(i).getP2Triangles().size());
//triangles.get(i).setNormalP3(calculatePointNormal(triangles.get(i).getP3Triangles()));
//System.out.println("P3: "+ triangles.get(i).getP3Triangles().size());
            }
            //flag=true;
        //}
    }

    protected Point3f calculatePointNormal(ArrayList<Triangle> triangles){
        float x=0;
        float y=0;
        float z=0;
        for(Triangle t:triangles){
            x+=t.getNormal().getX();
            y+=t.getNormal().getY();
            z+=t.getNormal().getZ();
        }
        x=x/triangles.size();
        y=y/triangles.size();
        z=z/triangles.size();

        x=(float)(x/Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2)));
        y=(float)(y/Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2)));
        z=(float)(z/Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2)));
        return new Point3f(x,y,z);
    }

    protected Point3f getNormalTriangle(Point3f p1, Point3f p2, Point3f p3){
        Point3f v=new Point3f(p2.getX()-p1.getX(),p2.getY()-p1.getY(),p2.getZ()-p1.getZ());
        Point3f w=new Point3f(p3.getX()-p1.getX(),p3.getY()-p1.getY(),p3.getZ()-p1.getZ());
      /*  Point3f v=new Point3f(p2.getX()-p1.getX(),p2.getY()-p1.getY(),p2.getZ()-p1.getZ());
        Point3f w=new Point3f(p1.getX()-p3.getX(),p1.getY()-p3.getY(),p1.getZ()-p3.getZ());*/

        float nx=(v.getY()*w.getZ())-(v.getZ()*w.getY());
        float ny=(v.getZ()*w.getX())-(v.getX()*w.getZ());
        float nz=(v.getX()*w.getY())-(v.getY()*w.getX());
        Point3f n=new Point3f(nx,ny,nz);

        float resx= (float) (n.getX()/Math.sqrt(Math.pow(n.getX(),2)+Math.pow(n.getY(),2)+Math.pow(n.getZ(),2)));
        float resy= (float) (n.getY()/Math.sqrt(Math.pow(n.getX(),2)+Math.pow(n.getY(),2)+Math.pow(n.getZ(),2)));
        float resz= (float) (n.getZ()/Math.sqrt(Math.pow(n.getX(),2)+Math.pow(n.getY(),2)+Math.pow(n.getZ(),2)));

        //System.out.println("x:"+resx+"; y:"+resy+"; z:"+resz);
        return new Point3f(resx,resy,resz);
    }

    protected void setTrianglesToPoints(){
        //System.out.println("SET TRIANGLE");
        for(int i=0;i<triangles.size();i++){
            for(int j=0;j<triangles.size();j++){
                if(i==j){

                }else{
                    if(triangles.get(i).getX1()==triangles.get(j).getX1() && triangles.get(i).getY1()==triangles.get(j).getY1() && triangles.get(i).getZ1()==triangles.get(j).getZ1()
                       || triangles.get(i).getX1()==triangles.get(j).getX2() && triangles.get(i).getY1()==triangles.get(j).getY2() && triangles.get(i).getZ1()==triangles.get(j).getZ2()
                       || triangles.get(i).getX1()==triangles.get(j).getX3() && triangles.get(i).getY1()==triangles.get(j).getY3() && triangles.get(i).getZ1()==triangles.get(j).getZ3()){
                        Triangle t =triangles.get(i);
                        t.getP1Triangles().add(triangles.get(j));
                        triangles.get(i).setP1Triangles(t.getP1Triangles());
                    }

                    if(triangles.get(i).getX2() == triangles.get(j).getX1() && triangles.get(i).getY2()==triangles.get(j).getY1() && triangles.get(i).getZ2()==triangles.get(j).getZ1()
                            || triangles.get(i).getX2()==triangles.get(j).getX2() && triangles.get(i).getY2()==triangles.get(j).getY2() && triangles.get(i).getZ2()==triangles.get(j).getZ2()
                            || triangles.get(i).getX2()==triangles.get(j).getX3() && triangles.get(i).getY2()==triangles.get(j).getY3() && triangles.get(i).getZ2()==triangles.get(j).getZ3()){
                        Triangle t =triangles.get(i);
                        t.getP2Triangles().add(triangles.get(j));
                        triangles.get(i).setP2Triangles(t.getP2Triangles());
                    }

                    if(triangles.get(i).getX3() == triangles.get(j).getX1() && triangles.get(i).getY3()==triangles.get(j).getY1() && triangles.get(i).getZ3()==triangles.get(j).getZ1()
                            || triangles.get(i).getX3()==triangles.get(j).getX2() && triangles.get(i).getY3()==triangles.get(j).getY2() && triangles.get(i).getZ3()==triangles.get(j).getZ2()
                            || triangles.get(i).getX3()==triangles.get(j).getX3() && triangles.get(i).getY3()==triangles.get(j).getY3() && triangles.get(i).getZ3()==triangles.get(j).getZ3()){
                        Triangle t =triangles.get(i);
                        t.getP3Triangles().add(triangles.get(j));
                        triangles.get(i).setP3Triangles(t.getP3Triangles());
                    }

                    /*if(compatePoints(triangles.get(i).getP1(),triangles.get(j).getP1()) || compatePoints(triangles.get(i).getP1(),triangles.get(j).getP2()) || compatePoints(triangles.get(i).getP1(),triangles.get(j).getP3())){
                        Triangle t =triangles.get(i);
                        t.getP1Triangles().add(triangles.get(j));
                        triangles.get(i).setP1Triangles(t.getP1Triangles());
                    }
                    if(compatePoints(triangles.get(i).getP2(),triangles.get(j).getP1()) || compatePoints(triangles.get(i).getP2(),triangles.get(j).getP2()) || compatePoints(triangles.get(i).getP2(),triangles.get(j).getP3())){
                        Triangle t =triangles.get(i);
                        t.getP2Triangles().add(triangles.get(j));
                        triangles.get(i).setP2Triangles(t.getP2Triangles());
                    }

                    if(compatePoints(triangles.get(i).getP3(),triangles.get(j).getP1()) || compatePoints(triangles.get(i).getP3(),triangles.get(j).getP2()) || compatePoints(triangles.get(i).getP3(),triangles.get(j).getP3())){
                        Triangle t =triangles.get(i);
                        t.getP3Triangles().add(triangles.get(j));
                        triangles.get(i).setP3Triangles(t.getP3Triangles());
                    }*/

                   /* if(triangles.get(i).getP1().equals(triangles.get(j).getP1())){
                        Triangle t =triangles.get(i);
                        t.getP1Triangles().add(triangles.get(j));
                        triangles.get(i).setP1Triangles(t.getP1Triangles());
                    }else if(triangles.get(i).getP2().equals(triangles.get(j).getP2())){
                        Triangle t =triangles.get(i);
                        t.getP2Triangles().add(triangles.get(j));
                        triangles.get(i).setP2Triangles(t.getP2Triangles());
                    }else if(triangles.get(i).getP3().equals(triangles.get(j).getP3())){
                        Triangle t =triangles.get(i);
                        t.getP3Triangles().add(triangles.get(j));
                        triangles.get(i).setP3Triangles(t.getP3Triangles());
                    }*/

                    /*if(compatePoints(triangles.get(i).getP1(),triangles.get(j).getP1())){
                        Triangle t =triangles.get(i);
                        t.getP1Triangles().add(triangles.get(j));
                        triangles.get(i).setP1Triangles(t.getP1Triangles());
                    }else if(compatePoints(triangles.get(i).getP2(),triangles.get(j).getP2())){
                        Triangle t =triangles.get(i);
                        t.getP2Triangles().add(triangles.get(j));
                        triangles.get(i).setP2Triangles(t.getP2Triangles());
                    }else if(compatePoints(triangles.get(i).getP3(),triangles.get(j).getP3())){
                        Triangle t =triangles.get(i);
                        t.getP3Triangles().add(triangles.get(j));
                        triangles.get(i).setP3Triangles(t.getP3Triangles());
                    }*/
                }
            }
        }
    }

    private boolean compatePoints(Point3f p1,Point3f p2){
        boolean result=true;
        if(Math.abs(p1.getX())-Math.abs(p2.getX())<=0.0001  &&  Math.abs(p1.getY())-Math.abs(p2.getY())<=0.0001  &&  Math.abs(p1.getZ())-Math.abs(p2.getZ())<=0.0001){
            return true;
        }else{
            return false;
        }
    }
}
