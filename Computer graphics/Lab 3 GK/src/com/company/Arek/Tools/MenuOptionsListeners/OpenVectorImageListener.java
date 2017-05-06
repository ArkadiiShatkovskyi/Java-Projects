package com.company.Arek.Tools.MenuOptionsListeners;

import com.company.Arek.Interface.Panels.Left_Panel_Vector;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class OpenVectorImageListener implements ActionListener {


        private Left_Panel_Vector panel;
        private String path;

        public OpenVectorImageListener(Left_Panel_Vector panel){
            this.panel=panel;
            this.path = "H://Work spaces//IdeaProjects//Lab 3 GK/Save.txt";
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<String> list = new ArrayList<>();

            File file = new File(path);
            BufferedReader in = null;
            try {
                if (file.exists())
                    in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

                String s;
                while ((s = in.readLine()) != null) {
                    list.add(s);
                }

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            readElements(list);
        }

    public void readElements(ArrayList<String> list) {
        ArrayList<Integer> xp=new ArrayList<>();
        ArrayList<Integer> yp=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            char[] elem = list.get(i).toCharArray();
            String s="";
            boolean yt = false;
            for (int k = 0; k < elem.length; k++) {
                if(elem[0] == 'P'){      //P286n385n386n157n240y48n70n172n184n231
                    if(k>0 && elem[k]!='n' && elem[k]!='y' && elem[k]!='P'){
                        s+=elem[k];
                    }else if(elem[k]=='n' && !yt){
                        xp.add(Integer.parseInt(s));
                        System.out.println("x : "+s);
                        s="";
                    }else if(elem[k]=='y'){
                        yt=true;
                        xp.add(Integer.parseInt(s));
                        System.out.println("x : "+s);
                        s="";
                    }else if(yt && k>0 && elem[k]!='P'){
                        System.out.println("y : "+s);
                        yp.add(Integer.parseInt(s));
                        s="";
                    }
                    else if(k>0 && elem[k]=='P'){
                        System.out.println("y : "+s);
                        yp.add(Integer.parseInt(s));
                        s="";
                        yt=false;
                    }
                }
            }
        }
        panel.getLabel().addElement(new Polygon(listToTable(xp),listToTable(yp),xp.size()));
    }

    private int[] listToTable(ArrayList<Integer> list){
        int[] table=new int[list.size()];

        for(int i=0;i<list.size();i++){
            //System.out.println("table : "+list.get(i));
            table[i]=list.get(i);
        }
        return table;
    }
    }


