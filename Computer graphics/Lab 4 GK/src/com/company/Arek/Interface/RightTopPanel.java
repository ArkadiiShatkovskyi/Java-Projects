package com.company.Arek.Interface;

import com.company.Arek.Tools.OrthoGLEventListener;
import com.company.Arek.Tools.PerspectiveGLEventListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class RightTopPanel extends JPanel {

    private  OrthoGLEventListener eventL;
    private GLJPanel panel;

    public RightTopPanel(int size_x, int size_y,PerspectiveGLEventListener perspectiveGLEventListener){
        this.setSize(size_x,size_y);
        this.setPreferredSize(new Dimension(size_x,size_y));
        //this.add(new JLabel("RightTop"));

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDepthBits(64);
        panel = new GLJPanel(capabilities);

       eventL=new OrthoGLEventListener(3,perspectiveGLEventListener,panel);
        panel.addGLEventListener(eventL);

        //panel.setPreferredSize(this.getPreferredSize());
        panel.setPreferredSize(new Dimension(375,375));
        this.add(panel);
        this.addMouseListener(eventL);
        this.addMouseMotionListener(eventL);
    }

    public void setPanel1(GLJPanel panel){
        eventL.setPanel1(panel);
    }

    public void setPanel2(GLJPanel panel){
        eventL.setPanel2(panel);
    }

    public GLJPanel getPanel(){
        return panel;
    }
}
