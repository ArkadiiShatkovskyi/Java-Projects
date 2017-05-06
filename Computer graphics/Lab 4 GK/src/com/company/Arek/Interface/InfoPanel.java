package com.company.Arek.Interface;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private double ex;
    private double ey;
    private double ez;
    private double cx;
    private double cy;
    private double cz;
    private double angle;
    private JLabel lex;
    private JLabel ley;
    private JLabel lez;
    private JLabel lcx;
    private JLabel lcy;
    private JLabel lcz;
    private JLabel langle;

    public InfoPanel(int w,int h){
        this.setPreferredSize(new Dimension(w,h));
        //lex=new JLabel("EX: "+ex+";");
        lex=new JLabel("EX: "+String.format("%.2f",ex)+";");
        ley=new JLabel("EY: "+String.format("%.2f",ey)+";");
        lez=new JLabel("EZ: "+String.format("%.2f",ez)+";");
        langle=new JLabel("Angle: "+angle);
        lcx=new JLabel("CX: "+String.format("%.2f",cx)+";");
        lcy=new JLabel("CY: "+String.format("%.2f",cy)+";");
        lcz=new JLabel("CZ: "+String.format("%.2f",cz)+";");

        this.add(lex);
        this.add(ley);
        this.add(lez);
        this.add(lcx);
        this.add(lcy);
        this.add(lcz);
        this.add(langle);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        lex.setText("EX: "+String.format("%.2f",ex)+";");
        ley.setText("EY: "+String.format("%.2f",ey)+";");
        lez.setText("EZ: "+String.format("%.2f",ez)+";");
        lcx.setText("CX: "+String.format("%.2f",cx)+";");
        lcy.setText("CY: "+String.format("%.2f",cy)+";");
        lcz.setText("CZ: "+String.format("%.2f",cz)+";");
        langle.setText("Angle: "+angle);
    }

    public void setY(double y) {
        this.ey = y;
        this.repaint();
    }

    public void setZ(double z) {
        this.ez = z;
        this.repaint();
    }

    public void setAngle(double angle) {
        this.angle = angle;
        this.repaint();
    }

    public void setX(double x) {
        this.ex = x;
        this.repaint();
    }

    public void setCz(double cz) {
        this.cz = cz;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }
}
