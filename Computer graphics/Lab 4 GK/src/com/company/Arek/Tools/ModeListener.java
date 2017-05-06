package com.company.Arek.Tools;

import com.company.Arek.Interface.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeListener implements ActionListener {

    private boolean flag;
    private Frame frame;

    public ModeListener(boolean flag, Frame frame){
        this.flag=flag;
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setFlag(flag);
    }
}
