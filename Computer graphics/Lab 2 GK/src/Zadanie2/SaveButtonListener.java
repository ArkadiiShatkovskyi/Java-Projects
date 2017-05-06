package Zadanie2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveButtonListener implements ActionListener {

    String path;
    MyJLabel jLabel;

    public SaveButtonListener(MyJLabel label){
        this.path="";

        this.jLabel=label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("zdjecie: "+path);

        PrintWriter out=null;
        try{
                File file=new File("H://Work spaces//IdeaProjects//Lab 1 GK/Save.txt");
                if(!file.exists()){
                    file.createNewFile();
            }

            out=new PrintWriter(file.getAbsoluteFile());

            System.out.println(jLabel.toString());
            out.print(path+"\n"+jLabel.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            out.close();
        }
    }

    public void setPath(String path){
        this.path=path;
    }
}
