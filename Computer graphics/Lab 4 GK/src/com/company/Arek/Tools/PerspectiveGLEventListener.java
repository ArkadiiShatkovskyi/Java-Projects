package com.company.Arek.Tools;

import com.company.Arek.Interface.InfoPanel;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.vecmath.Point3f;
import java.util.ArrayList;

public class PerspectiveGLEventListener extends MyGLEventListener implements GLEventListener {

    private double EYE_X;
    private double EYE_Y;
    private double EYE_Z;
    private double CENTER_X;
    private double CENTER_Y ;
    private double CENTER_Z;
    private double UP_X=0;
    private double UP_Y=1;
    private double UP_Z=0;
    private double FIELD_OF_VIEW_ANGLE;
    private double Z_NEAR;
    private double Z_FAR;
    private GLU glu;
    private double view_roty, view_rotx,view_rotz;
    private String path;
    private InfoPanel infoPanel;
    private GLCanvas panel;

    public PerspectiveGLEventListener(String path){
        super();
        glu = new GLU();

        this.path=path;

        this.EYE_X=super.perspective[0];
        this.EYE_Y=super.perspective[1];
        this.EYE_Z=super.perspective[2];

        CENTER_X= super.perspective[3];
        CENTER_Y= super.perspective[4];
        CENTER_Z= super.perspective[5];
        FIELD_OF_VIEW_ANGLE= super.perspective[6];
        Z_NEAR= super.perspective[7];
        Z_FAR= super.perspective[8];

        this.view_rotx=0;
        this.view_roty=0;
        this.view_rotz=0;
    }

    @Override
    public void init(GLAutoDrawable autoDrawable) {
        GL2 gl2 = autoDrawable.getGL().getGL2();
        gl2.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glDepthFunc(GL2.GL_LESS);

        gl2.glEnable(GL2.GL_LIGHTING);
        gl2.glEnable(GL2.GL_LIGHT0);
        //gl2.glShadeModel(GL2.GL_SMOOTH);
        //gl2.glLightModelf(GL2.GL_LIGHT_MODEL_TWO_SIDE,GL2.GL_TRUE);
        //gl2.glEnable(GL2.GL_NORMALIZE);
    }

    public void dispose(GLAutoDrawable autoDrawable) {
        GL2 gl2 = autoDrawable.getGL().getGL2();
    }

    public void display(GLAutoDrawable autoDrawable) {

        myreshape(autoDrawable,600,400);
        sendInfo();

        GL2 gl2 = autoDrawable.getGL().getGL2();

        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl2.glEnable(GL2.GL_DEPTH_TEST);
        gl2.glDepthFunc(GL2.GL_LESS);

        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();
        glu.gluLookAt(EYE_X, EYE_Y, EYE_Z, CENTER_X, CENTER_Y, CENTER_Z, UP_X, UP_Y, UP_Z);

        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, super.ambient,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, super.diffuse,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, super.diffuse,0);
        gl2.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, super.position,0);

        gl2.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT,super.lmodel_ambient,0);
        gl2.glLightModelfv(GL2.GL_LIGHT_MODEL_LOCAL_VIEWER,super.local_view,0);

        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
        super.setNormals();

        for(int i = 0; i< super.triangles.size(); i++){
            /*********************************
            System.out.println("\nTriangle: "+i);
            System.out.println("P1:[x:"+super.triangles.get(i).getX1()+"; y:"+super.triangles.get(i).getY1()+"; z:"+super.triangles.get(i).getZ1()+
                    "] \nP2:[x:"+super.triangles.get(i).getX2()+"; y:"+super.triangles.get(i).getY2()+"; z:"+super.triangles.get(i).getZ2()+
                    "]\nP3:[x:"+super.triangles.get(i).getX3()+"; y:"+super.triangles.get(i).getY3()+"; z:"+super.triangles.get(i).getZ3());

            *********************************/


            float color[]={super.triangles.get(i).getColor1(), super.triangles.get(i).getColor2(), super.triangles.get(i).getColor3(),1.0f};

            //gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_AMBIENT,super.no_mat,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_DIFFUSE,color,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_SPECULAR,super.mat_specular,0);
            gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_SHININESS,super.hight_shininess,0);
            //gl2.glMaterialfv(GL2.GL_FRONT,GL2.GL_EMISSION,super.no_mat,0);

            //gl2.glNormal3f(triangles.get(i).getNormal().getX(),triangles.get(i).getNormal().getY(),triangles.get(i).getNormal().getZ());
/*
            gl2.glBegin(GL2.GL_TRIANGLES);
            gl2.glNormal3f(super.triangles.get(i).getNormalP1().getX(),super.triangles.get(i).getNormalP1().getY(),super.triangles.get(i).getNormalP1().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX1(), super.triangles.get(i).getY1(), super.triangles.get(i).getZ1());
            //gl2.glNormal3f(super.triangles.get(i).getNormalP2().getX(),super.triangles.get(i).getNormalP2().getY(),super.triangles.get(i).getNormalP2().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX2(), super.triangles.get(i).getY2(), super.triangles.get(i).getZ2());
            //gl2.glNormal3f(super.triangles.get(i).getNormalP3().getX(),super.triangles.get(i).getNormalP3().getY(),super.triangles.get(i).getNormalP3().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX3(), super.triangles.get(i).getY3(), super.triangles.get(i).getZ3());

            gl2.glEnd();
*/
            gl2.glBegin(GL2.GL_TRIANGLES);
            gl2.glNormal3f(super.triangles.get(i).getNormalP1().getX(),super.triangles.get(i).getNormalP1().getY(),super.triangles.get(i).getNormalP1().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX1(), super.triangles.get(i).getY1(), super.triangles.get(i).getZ1());
            gl2.glNormal3f(super.triangles.get(i).getNormalP2().getX(),super.triangles.get(i).getNormalP2().getY(),super.triangles.get(i).getNormalP2().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX2(), super.triangles.get(i).getY2(), super.triangles.get(i).getZ2());
            gl2.glNormal3f(super.triangles.get(i).getNormalP3().getX(),super.triangles.get(i).getNormalP3().getY(),super.triangles.get(i).getNormalP3().getZ());
            gl2.glVertex3f(super.triangles.get(i).getX3(), super.triangles.get(i).getY3(), super.triangles.get(i).getZ3());

            gl2.glEnd();
        }

        gl2.glFlush();
    }

    public void reshape(GLAutoDrawable autoDrawable, int x, int y, int width, int height) {
        GL2 gl2 = autoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();
        glu.gluPerspective(FIELD_OF_VIEW_ANGLE, (double)width / (double)height, Z_NEAR, Z_FAR);
    }

    private void myreshape(GLAutoDrawable autoDrawable, int width, int height){
        GL2 gl2 = autoDrawable.getGL().getGL2();
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();
        glu.gluPerspective(FIELD_OF_VIEW_ANGLE, (double)width / (double)height, Z_NEAR, Z_FAR);
    }

    public void sendInfo(){
        infoPanel.setX(EYE_X);
        infoPanel.setY(EYE_Y);
        infoPanel.setZ(EYE_Z);
        infoPanel.setCx(CENTER_X);
        infoPanel.setCy(CENTER_Y);
        infoPanel.setCz(CENTER_Z);
        infoPanel.setAngle(FIELD_OF_VIEW_ANGLE);
    }

    public void setEYE_X(double EYE_X) {
        this.EYE_X = EYE_X;
    }

    public void setEYE_Y(double EYE_Y) {
        this.EYE_Y = EYE_Y;
    }

    public void setEYE_Z(double EYE_Z) {
        this.EYE_Z = EYE_Z;
    }

    public double getFIELD_OF_VIEW_ANGLE() {
        return FIELD_OF_VIEW_ANGLE;
    }

    public void setFIELD_OF_VIEW_ANGLE(double FIELD_OF_VIEW_ANGLE) {
        this.FIELD_OF_VIEW_ANGLE = FIELD_OF_VIEW_ANGLE;
    }

    public double getEYE_X() {
        return EYE_X;
    }

    public double getEYE_Z() {
        return EYE_Z;
    }

    public double getEYE_Y() {
        return EYE_Y;
    }

    public void setInfoPanel(InfoPanel infoPanel){
        this.infoPanel=infoPanel;
    }

    public double getCENTER_X() {
        return CENTER_X;
    }

    public void setCENTER_X(double CENTER_X) {
        this.CENTER_X = CENTER_X;
    }

    public double getCENTER_Y() {
        return CENTER_Y;
    }

    public void setCENTER_Y(double CENTER_Y) {
        this.CENTER_Y = CENTER_Y;
    }

    public double getCENTER_Z() {
        return CENTER_Z;
    }

    public void setCENTER_Z(double CENTER_Z) {
        this.CENTER_Z = CENTER_Z;
    }


    public ArrayList<Triangle> getTriangles(){
        return super.triangles;
    }

    public double[] getPerspective(){
        double[] p=new double[9];
        p[0]=this.EYE_X;
        p[1]=this.EYE_Y;
        p[2]=this.EYE_Z;
        p[3]=CENTER_X;
        p[4]=CENTER_Y;
        p[5]=CENTER_Z;
        p[6]=FIELD_OF_VIEW_ANGLE;
        p[7]=Z_NEAR;
        p[8]=Z_FAR;

        return p;
    }

    public float[] getLeftTop(){
        return super.lefttop;
    }

    public float[] getRightBottom(){
        return super.rightbottom;
    }

    public float[] getRightTop(){
        return super.righttop;
    }

    public float[] getAmbient(){
        return super.ambient;
    }

    public float[] getDiffuse(){
        return super.diffuse;
    }

    public float[] getPossition(){
        return super.position;
    }

    public float[] getLmodelAmbient(){
        return super.lmodel_ambient;
    }

    public float[] getLocalView(){
        return super.local_view;
    }

    public float[] getNoMat(){
        return super.no_mat;
    }

    public float[] getMatSpecular(){
        return super.mat_specular;
    }

    public float[] getShininess(){
        return super.hight_shininess;
    }

    public GLCanvas getPanel() {
        return panel;
    }

    public void setPanel(GLCanvas panel) {
        this.panel = panel;
    }
}
