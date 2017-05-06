package com.company.Arek.Interface;

import com.company.Arek.Tools.OrthoGLEventListener;
import com.company.Arek.Tools.PerspectiveGLEventListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class LeftTopPanel extends JPanel{

    private OrthoGLEventListener orthoGLEventListener;
    private GLJPanel panel;

    public LeftTopPanel(int size_x, int size_y, PerspectiveGLEventListener perspectiveGLEventListener){
        this.setSize(size_x,size_y);
        this.setPreferredSize(new Dimension(size_x,size_y));

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDepthBits(64);
        panel = new GLJPanel(capabilities);
        orthoGLEventListener=new OrthoGLEventListener(1,perspectiveGLEventListener,panel);
        panel.addGLEventListener(orthoGLEventListener);
        panel.setPreferredSize(new Dimension(375,375));
        this.add(panel);
        this.setVisible(true);
        this.addMouseListener(orthoGLEventListener);
        this.addMouseMotionListener(orthoGLEventListener);
    }

    public void setPanel1(GLJPanel panel){
        orthoGLEventListener.setPanel1(panel);
    }

    public void setPanel2(GLJPanel panel){
        orthoGLEventListener.setPanel2(panel);
    }

    public GLJPanel getPanel(){
        return panel;
    }
}
