package com.company.Arek.Tools;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.math.VectorUtil;

import javax.vecmath.Point3f;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class OrthoGLEventListener extends MyGLEventListener implements GLEventListener, MouseListener, MouseMotionListener {

    private double EYE_X;
    private double EYE_Y;
    private double EYE_Z;
    private static final double CENTER_X = 0.0;
    private static final double CENTER_Y = 0.0;
    private static final double CENTER_Z = 0.0;
    private double UP_X;
    private double UP_Y;
    private double UP_Z;
    private GLU glu;
    private ArrayList<Float> xPoints;
    private ArrayList<Float> yPoints;
    private ArrayList<Float> zPoints;
    private int type;
    private Point cameraPosition;
    private Point watchPosition;
    private PerspectiveGLEventListener perspectiveGLEventListener;
    private GLJPanel panel;
    private GLJPanel panel1;
    private GLJPanel panel2;

    public OrthoGLEventListener(int type,PerspectiveGLEventListener perspectiveGLEventListener,GLJPanel panel){
        super();
        glu = new GLU();
        this.panel=panel;
        this.perspectiveGLEventListener=perspectiveGLEventListener;
        this.type=type;
        float panelSettings[];

        if(type==1){
            panelSettings=super.lefttop;
        }else if(type==2){
            panelSettings=super.rightbottom;
        }else{
            panelSettings=super.righttop;
        }

        this.EYE_X=panelSettings[0];
        this.EYE_Y=panelSettings[1];
        this.EYE_Z=panelSettings[2];

        UP_X=panelSettings[3];
        UP_Y=panelSettings[4];
        UP_Z=panelSettings[5];

        xPoints=new ArrayList<>();
        yPoints=new ArrayList<>();
        zPoints=new ArrayList<>();
        setPoints();
    }

    @Override
    public void init(GLAutoDrawable autoDrawable) {
        GL2 gl2 = autoDrawable.getGL().getGL2();
        gl2.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glDepthFunc(GL2.GL_LESS);

        gl2.glEnable(GL2.GL_LIGHTING);
        gl2.glEnable(GL2.GL_LIGHT0);
        gl2.glLightModelf(GL2.GL_LIGHT_MODEL_TWO_SIDE,GL2.GL_TRUE);
        gl2.glEnable(GL2.GL_NORMALIZE);
    }

    public void dispose(GLAutoDrawable autoDrawable) {
        GL2 gl2 = autoDrawable.getGL().getGL2();
    }

    public void display(GLAutoDrawable autoDrawable) {
        GL2 gl2 = autoDrawable.getGL().getGL2();

        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glDepthFunc(GL2.GL_LESS);

        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();

        reshape(autoDrawable,0,0,autoDrawable.getSurfaceWidth(),autoDrawable.getSurfaceHeight());
        glu.gluLookAt(EYE_X, EYE_Y, EYE_Z,CENTER_X, CENTER_Y, CENTER_Z, UP_X, UP_Y, UP_Z);

        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, super.ambient,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, super.diffuse,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, super.diffuse,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, super.position,0);

        gl2.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT,super.lmodel_ambient,0);
        gl2.glLightModelfv(GL2.GL_LIGHT_MODEL_LOCAL_VIEWER,super.local_view,0);
        super.setNormals();

        for(int i = 0; i< super.triangles.size(); i++){

            float color[]={super.triangles.get(i).getColor1(), super.triangles.get(i).getColor2(), super.triangles.get(i).getColor3(),1.0f};

            //gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_AMBIENT,super.no_mat,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_DIFFUSE,color,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_SPECULAR,super.mat_specular,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_SHININESS,super.hight_shininess,0);
            //gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_EMISSION,super.no_mat,0);
/*
            gl2.glNormal3f(triangles.get(i).getNormal().getX(),triangles.get(i).getNormal().getY(),triangles.get(i).getNormal().getZ());

            gl2.glBegin(GL2.GL_TRIANGLES);

            gl2.glVertex3f(super.triangles.get(i).getX1(), super.triangles.get(i).getY1(), super.triangles.get(i).getZ1());
            gl2.glVertex3f(super.triangles.get(i).getX2(), super.triangles.get(i).getY2(), super.triangles.get(i).getZ2());
            gl2.glVertex3f(super.triangles.get(i).getX3(), super.triangles.get(i).getY3(), super.triangles.get(i).getZ3());

            gl2.glEnd();*/
            gl2.glBegin(GL2.GL_TRIANGLES);
            gl2.glNormal3f(super.triangles.get(i).getNormalP1().getX(),super.triangles.get(i).getNormalP1().getY(),super.triangles.get(i).getNormalP1().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX1(), super.triangles.get(i).getY1(), super.triangles.get(i).getZ1());
            gl2.glNormal3f(super.triangles.get(i).getNormalP2().getX(),super.triangles.get(i).getNormalP2().getY(),super.triangles.get(i).getNormalP2().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX2(), super.triangles.get(i).getY2(), super.triangles.get(i).getZ2());
            gl2.glNormal3f(super.triangles.get(i).getNormalP3().getX(),super.triangles.get(i).getNormalP3().getY(),super.triangles.get(i).getNormalP3().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX3(), super.triangles.get(i).getY3(), super.triangles.get(i).getZ3());

            gl2.glEnd();
        }
        //drawCamera(gl2);
        gl2.glFlush();
    }

    public void reshape(GLAutoDrawable autoDrawable, int x, int y, int width, int height) {

        GL2 gl2 = autoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();

         float xABS, yABS, zABS=yABS=xABS=0;

         switch (type)
         {
         case 2:  // top          RightBottom
            xABS=Math.max(Math.abs(max(xPoints)), Math.abs(min(xPoints)));
            yABS=Math.max(Math.abs(max(zPoints)), Math.abs(min(zPoints)));
            zABS=Math.max(Math.abs(max(yPoints)), Math.abs(min(yPoints)));
            break;
         case 1:  //rightsize     LeftTop
            xABS=Math.max(Math.abs(max(zPoints)), Math.abs(min(zPoints)));
            yABS=Math.max(Math.abs(max(yPoints)), Math.abs(min(yPoints)));
            zABS=Math.max(Math.abs(max(xPoints)), Math.abs(min(xPoints)));
            break;
         case 3: //first person   RightTopPanel
            xABS=Math.max(Math.abs(max(xPoints)), Math.abs(min(xPoints)));
            yABS=Math.max(Math.abs(max(yPoints)), Math.abs(min(yPoints)));
            zABS=Math.max(Math.abs(max(zPoints)), Math.abs(min(zPoints)));
            break;
         default:
            break;
         }
         if(xABS*height/width>=yABS){
            yABS=xABS*height/width;
         }else{
            xABS=yABS*width/height;
         }
         gl2.glOrthof(-xABS,xABS,-yABS, yABS,-zABS,zABS);
    }

    private void drawCamera(GL2 gl2) {

        //System.out.println("Angle: "+perspectiveGLEventListener.getFIELD_OF_VIEW_ANGLE());
        //System.out.println("CX: "+(float)perspectiveGLEventListener.getCENTER_X());
        double angle = perspectiveGLEventListener.getFIELD_OF_VIEW_ANGLE() / 2.0;
        float[] lookVertex = {(float)perspectiveGLEventListener.getCENTER_X(),(float)perspectiveGLEventListener.getCENTER_Y(),(float) perspectiveGLEventListener.getCENTER_Z()};
        float[] cameraVertex = {(float)perspectiveGLEventListener.getEYE_X(), (float)perspectiveGLEventListener.getEYE_Y(), (float)perspectiveGLEventListener.getEYE_Z()};
        float[] cameraVec = {lookVertex[0] - cameraVertex[0], lookVertex[1] - cameraVertex[1], lookVertex[2] - cameraVertex[2]};
        float[] OYVec = {0f, 1f, 0f};
        float[] horVec = new float[3];
        VectorUtil.crossVec3(horVec, cameraVec, OYVec);
        float vecLength = ((float) Math.tan(angle * Math.PI / 180.0)) * VectorUtil.normVec3(cameraVec);
        float horVecLength = VectorUtil.normVec3(horVec);
        horVec[0] = vecLength * horVec[0] / horVecLength;
        horVec[1] = vecLength * horVec[1] / horVecLength;
        horVec[2] = vecLength * horVec[2] / horVecLength;
        float[] verVec = new float[3];
        VectorUtil.crossVec3(verVec, horVec, cameraVec);
        float verVecLength = VectorUtil.normVec3(verVec);
        verVec[0] = 0.66f * vecLength * verVec[0] / verVecLength;
        verVec[1] = 0.66f * vecLength * verVec[1] / verVecLength;
        verVec[2] = 0.66f * vecLength * verVec[2] / verVecLength;
        float[][] coneVert = new float[4][3];

        coneVert[0][0] = lookVertex[0] + horVec[0] + verVec[0];
        coneVert[0][1] = lookVertex[1] + horVec[1] + verVec[1];
        coneVert[0][2] = lookVertex[2] + horVec[2] + verVec[2];

        coneVert[1][0] = lookVertex[0] + horVec[0] - verVec[0];
        coneVert[1][1] = lookVertex[1] + horVec[1] - verVec[1];
        coneVert[1][2] = lookVertex[2] + horVec[2] - verVec[2];

        coneVert[2][0] = lookVertex[0] - horVec[0] + verVec[0];
        coneVert[2][1] = lookVertex[1] - horVec[1] + verVec[1];
        coneVert[2][2] = lookVertex[2] - horVec[2] + verVec[2];

        coneVert[3][0] = lookVertex[0] - horVec[0] - verVec[0];
        coneVert[3][1] = lookVertex[1] - horVec[1] - verVec[1];
        coneVert[3][2] = lookVertex[2] - horVec[2] - verVec[2];

        gl2.glDisable(GL2.GL_LIGHTING);

        for(int i = 0; i < coneVert.length; i++) {
            gl2.glBegin(GL2.GL_LINES);
            gl2.glColor3f(0.0f, 0.0f, 0.0f);
            gl2.glVertex3f(cameraVertex[0], cameraVertex[1], cameraVertex[2]);
            gl2.glVertex3f(coneVert[i][0], coneVert[i][1], coneVert[i][2]);
            gl2.glEnd();
        }

        gl2.glBegin(GL2.GL_LINES);
        gl2.glColor3f(0.0f, 0.0f, 0.0f);
        gl2.glVertex3f(coneVert[0][0], coneVert[0][1], coneVert[0][2]);
        gl2.glVertex3f(coneVert[1][0], coneVert[1][1], coneVert[1][2]);
        gl2.glEnd();

        gl2.glBegin(GL2.GL_LINES);
        gl2.glColor3f(0.0f, 0.0f, 0.0f);
        gl2.glVertex3f(coneVert[2][0], coneVert[2][1], coneVert[2][2]);
        gl2.glVertex3f(coneVert[3][0], coneVert[3][1], coneVert[3][2]);
        gl2.glEnd();

        gl2.glBegin(GL2.GL_LINES);
        gl2.glColor3f(0.0f, 0.0f, 0.0f);
        gl2.glVertex3f(coneVert[0][0], coneVert[0][1], coneVert[0][2]);
        gl2.glVertex3f(coneVert[2][0], coneVert[2][1], coneVert[2][2]);
        gl2.glEnd();

        gl2.glBegin(GL2.GL_LINES);
        gl2.glColor3f(0.0f, 0.0f, 0.0f);
        gl2.glVertex3f(coneVert[3][0], coneVert[3][1], coneVert[3][2]);
        gl2.glVertex3f(coneVert[1][0], coneVert[1][1], coneVert[1][2]);
        gl2.glEnd();

        gl2.glEnable(GL2.GL_LIGHTING);
    }

    private void setPoints(){
        for(int i = 0; i< super.triangles.size(); i++){
            xPoints.add(super.triangles.get(i).getX1());
            xPoints.add(super.triangles.get(i).getX2());
            xPoints.add(super.triangles.get(i).getX3());

            yPoints.add(super.triangles.get(i).getY1());
            yPoints.add(super.triangles.get(i).getY2());
            yPoints.add(super.triangles.get(i).getY3());

            zPoints.add(super.triangles.get(i).getZ1());
            zPoints.add(super.triangles.get(i).getZ2());
            zPoints.add(super.triangles.get(i).getZ3());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

            if((e.getModifiersEx()&MouseEvent.BUTTON1_DOWN_MASK)!=0)
            {
                if(cameraPosition!=null)
                {
                    float dx=(float) (0.1*(e.getPoint().getX()-cameraPosition.getX()));
                    float dy=(float) (0.1*(e.getPoint().getY()-cameraPosition.getY()));
                    switch(type)
                    {
                        case 1: //RIGHT
                            perspectiveGLEventListener.setEYE_Z(perspectiveGLEventListener.getEYE_Z()+dx);
                            perspectiveGLEventListener.setEYE_Y(perspectiveGLEventListener.getEYE_Y()-dy);
                            break;
                        case 2: //TOP
                            perspectiveGLEventListener.setEYE_X(perspectiveGLEventListener.getEYE_X()+dx);
                            perspectiveGLEventListener.setEYE_Z(perspectiveGLEventListener.getEYE_Z()+dy);
                            break;
                        case 3: //FRONT
                            perspectiveGLEventListener.setEYE_X(perspectiveGLEventListener.getEYE_X()+dx);
                            perspectiveGLEventListener.setEYE_Y(perspectiveGLEventListener.getEYE_Y()-dy);
                            break;
                    }
                    perspectiveGLEventListener.sendInfo();
                }
                cameraPosition=e.getPoint();
            }

            if((e.getModifiersEx()&MouseEvent.BUTTON3_DOWN_MASK)!=0)
            {

                if(watchPosition!=null)
                {
                    float dx=(float) (0.1*(e.getPoint().getX()-watchPosition.getX()));
                    float dy=(float) (0.1*(e.getPoint().getY()-watchPosition.getY()));
                    switch(type)
                    {
                        case 1://RIGHT
                            perspectiveGLEventListener.setCENTER_Z(perspectiveGLEventListener.getCENTER_Z()-dx);
                            perspectiveGLEventListener.setCENTER_Y(perspectiveGLEventListener.getCENTER_Y()-dy);
                            break;
                        case 2://TOP
                            perspectiveGLEventListener.setCENTER_X(perspectiveGLEventListener.getCENTER_X()+dx);
                            perspectiveGLEventListener.setCENTER_Z(perspectiveGLEventListener.getCENTER_Z()+dy);
                            break;
                        case 3://FRONT
                            perspectiveGLEventListener.setCENTER_X(perspectiveGLEventListener.getCENTER_X()+dx);
                            perspectiveGLEventListener.setCENTER_Y(perspectiveGLEventListener.getCENTER_Y()-dy);
                            break;
                    }
                    perspectiveGLEventListener.sendInfo();
                }
                watchPosition=e.getPoint();
            }
        /*panel.repaint();
        panel1.repaint();
        panel2.repaint();*/
        perspectiveGLEventListener.getPanel().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1)
            {
                cameraPosition=null;
            }
            if(e.getButton()==MouseEvent.BUTTON3)
            {
                watchPosition=null;
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    public void setPanel1(GLJPanel panel1) {
        this.panel1 = panel1;
    }

    public void setPanel2(GLJPanel panel2) {
        this.panel2 = panel2;
    }
}
