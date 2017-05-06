package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;

public class LoadElementsListener implements ActionListener {

    private String path;
    private String pathI;
    private MyJLabel jLabel;

    public LoadElementsListener(MyJLabel jLabel) {
        this.path = "H://Work spaces//IdeaProjects//Lab 1 GK/Save.txt";
        this.pathI="";
        this.jLabel = jLabel;
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

        ArrayList<Rectangle2D.Double> rectangles=new ArrayList<>();
        ArrayList<Ellipse2D.Double> elipses=new ArrayList<>();
        ArrayList<Polygon> polygones=new ArrayList<>();

        int x=0, y=0, w=0, h = 0;
        ArrayList<Integer> xp=new ArrayList<>();
        ArrayList<Integer> yp=new ArrayList<>();
        boolean xt = false, yt = false, ht = false, wt=false;
        String s="";
        for (int i = 0; i < list.size(); i++) {
            if(i==0){
                pathI=list.get(i);
                jLabel.setIcon(new ImageIcon(pathI));
            }
            char[] elem = list.get(i).toCharArray();
             //e=elem.toCharArray();
            System.out.println("l(i): "+list.get(i));
            s="";
            for (int k = 0; k < elem.length; k++) {
                if (elem[0] == 'R' || elem[0] == 'E') {
                    if (elem[k] != 'R' && elem[k] != 'E' && ((k > 0 && elem[k] != 'y' && !xt) || (xt && !yt && elem[k] != 'h') || (yt && !ht && elem[k] != 'w') || (ht && !wt))) {
                        s+=elem[k];
                        System.out.println(s);
                    } else if (elem[k] == 'y') {
                        x = Integer.parseInt(s);
                        System.out.println("x : "+s);
                        s="";
                        xt = true;
                    } else if (elem[k] == 'h') {
                        y = Integer.parseInt(s);
                        System.out.println("y : "+s);
                        s="";
                        yt = true;
                    } else if (elem[k] == 'w') {
                        h = Integer.parseInt(s);
                        System.out.println("h : "+s);
                        s="";
                        ht=true;
                    }else if(k>0 && (elem[k] == 'R' || elem[k] == 'E')){
                        //System.out.println("elem["+k+"]: "+elem[k]);
                        w = Integer.parseInt(s);
                        System.out.println("w : "+s);
                        s="";
                        xt=false;
                        yt=false;
                        ht=false;
                        wt=false;
                    }
                }else if(elem[0] == 'P'){      //P286n385n386n157n240y48n70n172n184n231
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
            if(elem[0]=='R'){
                //System.out.println("x: "+x+", y: "+y+", h: "+h+", w: "+w);
                rectangles.add(new Rectangle2D.Double(x,y,w,h));
            }else if(elem[0] == 'E'){
                elipses.add(new Ellipse2D.Double(x,y,w,h));
            }else if(elem[0]=='P'){
                int [] t=listToTable(xp);
                for(int z=0;z<t.length;z++){
                    System.out.println("table : "+t[z]);
                }
                polygones.add(new Polygon(listToTable(xp),listToTable(yp),xp.size()));
                xp.clear();
                yp.clear();
            }
        }

        jLabel.setElements(rectangles,elipses,polygones);
    }

    public int[] listToTable(ArrayList<Integer> list){
        int[] table=new int[list.size()];

        for(int i=0;i<list.size();i++){
            //System.out.println("table : "+list.get(i));
            table[i]=list.get(i);
        }
        return table;
    }
}
