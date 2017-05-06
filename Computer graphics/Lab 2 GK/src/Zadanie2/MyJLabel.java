package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MyJLabel extends JLabel implements MouseListener, MouseMotionListener {

    public int n;
    public int rec;
    public int elip;
    public int pol;
    public ArrayList<Rectangle2D.Double> rectangles;
    public ArrayList<Ellipse2D.Double> elipses;
    public ArrayList<Polygon> polygones;
    public boolean mouseOn;
    public boolean drawing;
    public MyJPanel pr;
    public DefaultListModel listModel;
    public ArrayList<Element> elementsOnList;
    public ArrayList<Integer> xPoints;
    public ArrayList<Integer> yPoints;
    public Rectangle2D.Double drawR;
    public Ellipse2D.Double drawE;
    public Polygon drawP;
    private int startX;
    private int startY;
    private int idRS;
    private int idES;
    private int idPS;

    public MyJLabel(MyJPanel pr,DefaultListModel listModel){
        this.pr=pr;
        this.listModel =listModel;
        n=0;
        rec=0;
        elip=0;
        pol=0;
        mouseOn=false;
        drawing=false;
        idRS=-1;
        idES=-1;
        idPS=-1;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        rectangles=new ArrayList<>();
        elipses=new ArrayList<>();
        polygones=new ArrayList<>();
        elementsOnList=new ArrayList<>();
        xPoints=new ArrayList<>();
        yPoints=new ArrayList<>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.RED);
            if(drawing){
                if(drawR!=null){
                    g2d.draw(drawR);
                }else if(drawE!=null){
                    g2d.draw(drawE);
                }else if(drawP!=null){
                    g2d.draw(drawP);
                }
            }

            for(int i=0;i<rectangles.size();i++){
                if(idRS!=-1 && i==idRS){
                    g2d.setColor(Color.BLUE);
                    g2d.draw(rectangles.get(i));
                }else{
                    g2d.setColor(Color.RED);
                    g2d.draw(rectangles.get(i));
                }
            }

            for(int i=0;i<elipses.size();i++){
                if(idES!=-1 && i==idES){
                    g2d.setColor(Color.BLUE);
                    g2d.draw(elipses.get(i));
                }else{
                    g2d.setColor(Color.RED);
                    g2d.draw(elipses.get(i));
                }
            }

            for(int i=0;i<polygones.size();i++){
                if(idPS!=-1 && i==idPS){
                    g2d.setColor(Color.BLUE);
                    g2d.draw(polygones.get(i));
                }else{
                    g2d.setColor(Color.RED);
                    g2d.draw(polygones.get(i));
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mouseOn){
            n=pr.getN();
            if(polygones.size()==0){pol=0;}
            if(mouseOn && n==3 && e.getButton()==MouseEvent.BUTTON1){
                if(drawP==null){
                    drawP=new Polygon();
                    drawP.addPoint(e.getX(),e.getY());
                }
                    drawP.addPoint(e.getX(),e.getY());
                drawing=true;
                System.out.println("Mouse clicked  "+": "+pol+", size: "+polygones.size()+", xP "+ e.getX()+", yP "+e.getY());
            }
            else if(mouseOn && n==3 && e.getButton()==MouseEvent.BUTTON3){
                System.out.println("END " + ": "+pol);
                polygones.add(drawP);
                //System.out.println(drawP);
                drawing=false;

                drawP=null;

                this.revalidate();
                this.repaint();

                Element el=createElement(polygones.get(pol),pol);
                elementsOnList.add(el);
                listModel.addElement(el.toString());


                pol++;
            }
        }
    }

    public void setEColor(Object o){
        for(int i=0;i<elementsOnList.size();i++){
            if(elementsOnList.get(i).toString().equals(o)){
                if(elementsOnList.get(i).getType().equals("Rectangle")){
                    idRS =rectangles.indexOf(elementsOnList.get(i).getElement());
                    idES=-1;
                    idPS=-1;
                    this.revalidate();
                    this.repaint();
                }
                else if(elementsOnList.get(i).getType().equals("Ellipse")){
                    idES =elipses.indexOf(elementsOnList.get(i).getElement());
                    idRS=-1;
                    idPS=-1;
                    this.revalidate();
                    this.repaint();
                }
                else if(elementsOnList.get(i).getType().equals("Polygon")){
                    idPS =polygones.indexOf(elementsOnList.get(i).getElement());
                    idRS=-1;
                    idES=-1;
                    this.revalidate();
                    this.repaint();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!drawing && mouseOn){
            n=pr.getN();
            if(n==1){
                drawR=new Rectangle2D.Double();
                startX=e.getX();
                startY=e.getY();
                /*drawR.x=e.getX();
                drawR.y=e.getY();*/
                drawing=true;
            }
            else if(n==2){
                drawE=new Ellipse2D.Double();
                startX=e.getX();
                startY=e.getY();
                drawE.x=e.getX();
                drawE.y=e.getY();
                drawing=true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(drawing && mouseOn ){
            n=pr.getN();
            if(n==1){
                rectangles.add(drawR);
                rec=rectangles.size()-1;
                drawing=false;
                this.revalidate();
                this.repaint();

                Element el=createElement(rectangles.get(rec),rec);
                elementsOnList.add(el);
                listModel.addElement(el.toString());
                drawR=null;
                rec++;

                System.out.println("Mouse released!");
            }
            else if(n==2){
                elipses.add(drawE);
                elip=elipses.size()-1;

                drawing=false;
                this.revalidate();
                this.repaint();

                Element el=createElement(elipses.get(elip),elip);
                elementsOnList.add(el);
                listModel.addElement(el.toString());
                drawE=null;
                elip++;

                System.out.println("Mouse released!");
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOn=true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOn=false;
        //System.out.println("Mouse Exited!");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (n == 1) {
            drawR.x=Math.min(e.getPoint().getX(),startX);
            drawR.y=Math.min(e.getPoint().getY(),startY);
            drawR.width= Math.abs(e.getX()-startX);
            drawR.height=  Math.abs(e.getY()-startY);
            this.revalidate();
            this.repaint();
        }else if(n==2){
            drawE.x=Math.min(e.getPoint().getX(),startX);
            drawE.y=Math.min(e.getPoint().getY(),startY);
            drawE.width=Math.abs(e.getX()-startX);
            drawE.height=Math.abs(e.getY()-startY);
            this.revalidate();
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(n==3 && drawP!=null && drawing){
            drawP.xpoints[drawP.npoints-1]=e.getX();
            drawP.ypoints[drawP.npoints-1]=e.getY();
            this.revalidate();
            this.repaint();
        }
    }

    public Element createElement(Object ob, int id){
        return new Element(ob,id);
    }

    public void deleteElement(Object o){

        int id=0;
        for(int i=0;i<elementsOnList.size();i++){
            if(elementsOnList.get(i).toString().equals(o)){
                if(elementsOnList.get(i).getType().equals("Rectangle")){
                    rectangles.remove(elementsOnList.get(i).getElement());
                    id=i;
                    idRS=-1;
                    this.revalidate();
                    this.repaint();
                }
                else if(elementsOnList.get(i).getType().equals("Ellipse")){
                    elipses.remove(elementsOnList.get(i).getElement());
                    id=i;
                    idES=-1;
                    this.revalidate();
                    this.repaint();
                }
                else if(elementsOnList.get(i).getType().equals("Polygon")){
                    polygones.remove(elementsOnList.get(i).getElement());
                    id=i;
                    idPS=-1;
                    this.revalidate();
                    this.repaint();
                }
            }
        }
        elementsOnList.remove(elementsOnList.get(id).getElement());
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<rectangles.size();i++){
            s+="R"+(int)rectangles.get(i).x+"y"+(int)rectangles.get(i).y+"h"+(int)rectangles.get(i).getHeight()+"w"+(int)rectangles.get(i).getWidth()+"R\n";
        }
        for(int i=0;i<elipses.size();i++){
            s+="E"+(int)elipses.get(i).x+"y"+(int)elipses.get(i).y+"h"+(int)elipses.get(i).getHeight()+"w"+(int)elipses.get(i).getWidth()+"E\n";
        }

        for(int i=0;i<polygones.size();i++){
            s+="P"+tableToString(polygones.get(i).xpoints,polygones.get(i).npoints)+"y"+tableToString(polygones.get(i).ypoints,polygones.get(i).npoints)+"P\n";
        }
        return s;
    }

    public String tableToString(int[] table,int n){
        String r="";

        for(int i=0;i<n;i++){
            if(table[i]!=0)
                r+=table[i]+"n";
        }
        return r.substring(0,r.length()-1);
    }

    public void setElements(ArrayList<Rectangle2D.Double> r, ArrayList<Ellipse2D.Double> e, ArrayList<Polygon> p){
        rectangles.clear();
        elipses.clear();
        polygones.clear();
        elementsOnList.clear();
        this.rectangles=r;
        this.elipses=e;
        this.polygones=p;
        updateList();
        this.revalidate();
        this.repaint();
    }

    public void updateList(){

        for(int i=0;i<rectangles.size();i++){
            Element e=createElement(rectangles.get(i),i);
            if(!listModel.contains(e.toString())){
                listModel.addElement(e.toString());
                elementsOnList.add(e);
            }
        }

        for(int i=0;i<elipses.size();i++){
            Element e=createElement(elipses.get(i),i);
            if(!listModel.contains(e.toString())){
                listModel.addElement(e.toString());
                elementsOnList.add(e);
            }
        }

        for(int i=0;i<polygones.size();i++){
            Element e=createElement(polygones.get(i),i);
            if(!listModel.contains(e.toString())){
                listModel.addElement(e.toString());
                elementsOnList.add(e);
            }
        }
    }


}