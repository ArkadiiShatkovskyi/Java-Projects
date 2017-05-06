package Zadanie2;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJListListener implements MouseListener {

    private JList list;
    private MyJPanel panel;
    private boolean flagS;
    private String path ="H://Work spaces//IdeaProjects//Lab 1 GK/Save.txt";

    public void setData(JList list,MyJPanel panel){
        this.list=list;
        this.flagS=false;
        //this.i=-1;
        this.panel=panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!list.isSelectionEmpty() && e.getButton()==MouseEvent.BUTTON1){
            int n=list.getSelectedIndex();
            DefaultListModel listModel=(DefaultListModel) list.getModel();
            panel.getImage().setEColor(listModel.get(n));
        }
        else if(!list.isSelectionEmpty() && e.getButton()==MouseEvent.BUTTON3){
            int n=list.getSelectedIndex();
            DefaultListModel listModel=(DefaultListModel) list.getModel();
            panel.getImage().deleteElement(listModel.get(n));
            listModel.remove(list.getSelectedIndex());

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
