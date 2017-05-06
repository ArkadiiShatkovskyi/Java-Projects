package com.company.Arek.Tools;

import com.jogamp.opengl.awt.GLCanvas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private PerspectiveGLEventListener glEventListener;
    private GLCanvas panel;
    private double eyex;
    private double eyey;
    private double eyez;
    private double angle;

    public KeyListener(PerspectiveGLEventListener glEventListener, GLCanvas panel, double eyex, double eyey, double eyez){
        this.glEventListener=glEventListener;
        this.panel=panel;
        this.eyex=eyex;
        this.eyey=eyey;
        this.eyez=eyez;
        this.angle=glEventListener.getFIELD_OF_VIEW_ANGLE();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_NUMPAD7){
            eyex+=1;
            glEventListener.setEYE_X(eyex);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_NUMPAD4){
            eyex-=1;
            glEventListener.setEYE_X(eyex);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_NUMPAD8){
            eyey+=1;
            glEventListener.setEYE_Y(eyey);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_NUMPAD5){
            eyey-=1;
            glEventListener.setEYE_Y(eyey);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_NUMPAD9){
            eyez+=1;
            glEventListener.setEYE_Z(eyez);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_NUMPAD6){
            eyez-=1;
            glEventListener.setEYE_Z(eyez);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_DOWN){
            angle-=5;
            if(angle<1){
                angle=5;
            }
            glEventListener.setFIELD_OF_VIEW_ANGLE(angle);
            panel.repaint();
        }else if(keyCode==KeyEvent.VK_UP){
            angle+=5;
            if(angle>89){
                angle=89;
            }
            glEventListener.setFIELD_OF_VIEW_ANGLE(angle);
            panel.repaint();
        }
    }
}
