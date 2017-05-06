package com.company.Arek.Interface;

import com.company.Arek.Tools.KeyListener;
import com.company.Arek.Tools.PerspectiveGLEventListener;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;
import java.awt.*;

public class LeftBottomPanel extends JPanel {

    private PerspectiveGLEventListener glEventListener;

    public LeftBottomPanel(int size_x, int size_y){
        this.setSize(size_x,size_y);
        this.setPreferredSize(new Dimension(size_x,size_y));

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDepthBits(64);
        GLCanvas panel=new GLCanvas(capabilities);
        this.glEventListener=new PerspectiveGLEventListener("H:\\Work spaces\\IdeaProjects\\Lab 4 GK\\perspective.txt");
        panel.addKeyListener(new KeyListener(glEventListener,panel,glEventListener.getEYE_X(),glEventListener.getEYE_Y(),glEventListener.getEYE_Z()));
        panel.addGLEventListener(glEventListener);
        panel.setPreferredSize(this.getPreferredSize());
        this.add(panel);

        glEventListener.setPanel(panel);
    }

    public PerspectiveGLEventListener getGlEventListener(){
        return glEventListener;
    }
}
