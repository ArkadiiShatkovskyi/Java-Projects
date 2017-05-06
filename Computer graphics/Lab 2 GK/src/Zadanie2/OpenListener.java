package Zadanie2;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenListener implements ActionListener {

    private JPanel panel;
    private JLabel label;
    private String path;
    private SaveButtonListener sbl;

    public OpenListener(JPanel panel,SaveButtonListener sbl,JLabel label){
        this.panel=panel;
        this.label=label;
        this.sbl=sbl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileFilter filter=new FileNameExtensionFilter("Image jpg","jpg","jpeg");

        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

       chooser.addChoosableFileFilter(filter);
        int r=chooser.showDialog(panel,"chooice dialog");

        if(r==JFileChooser.APPROVE_OPTION){
            String name=chooser.getSelectedFile().getPath();
            path=name;
           sbl.setPath(path);
            label.setIcon(new ImageIcon(name));
        }
    }

    public String getPath(){
        return path;
    }
}
