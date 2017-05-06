package com.company.Arek.Tools;

import com.company.Arek.Interface.OtherElements.ImageW;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Vector_label extends ImageW implements MouseListener, MouseMotionListener {

    private int sx;
    private int sy;
    private ArrayList<Line2D.Double> lines;
    private ArrayList<Polygon> elements;
    private ArrayList<Polygon> temp_elements;
    private Polygon copyOfElement;
    private Polygon copyPoint;
    private boolean flag;

    public Vector_label(int size_x, int size_y) {
        super(size_x, size_y);
        flag=true;
        lines=new ArrayList<>();
        elements =new ArrayList<>();
        temp_elements =new ArrayList<>();
        this.sx=size_x;
        this.sy=size_y;
        this.getPreferredSize();
        drawOXY();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));

        transfer();

        for(int i=0;i<lines.size();i++){
            g2d.draw(lines.get(i));
            //System.out.println("line [x1:"+lines.get(i).getX1()+", y1:"+lines.get(i).getY1()+", x2:"+lines.get(i).getX2()+", y2:"+lines.get(i).getY2()+"]");
        }
        if(flag){
            for(int i = 0; i< elements.size(); i++){
                g2d.draw(temp_elements.get(i));
                //System.out.println("line [x1:"+lines.get(i).getX1()+", y1:"+lines.get(i).getY1()+", x2:"+lines.get(i).getX2()+", y2:"+lines.get(i).getY2()+"]");
            }
            temp_elements.clear();
        }else if(!flag){
            int x[]=new int[copyOfElement.npoints];
            int y[]=new int[copyOfElement.npoints];
            for(int i=0;i<elements.size();i++){
                x[i]=copyOfElement.xpoints[i]+sx/2;
                y[i]=copyOfElement.ypoints[i]+sy/2;
            }
            g2d.draw(new Polygon(x,y,x.length));
        }
    }

    private void transfer(){
        for(int i=0;i<elements.size();i++){
            int x[]=new int[elements.get(i).npoints];
            int y[]=new int[elements.get(i).npoints];

            for(int j=0;j<elements.get(i).npoints;j++){
                x[j]=elements.get(i).xpoints[j]+sx/2;
                y[j]=elements.get(i).ypoints[j]+sy/2;
            }
            temp_elements.add(new Polygon(x,y,x.length));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(sx, sy);
    }

    private void drawOXY(){
        int oy=sy/2;
        int ox=sx/2;

        lines.add(new Line2D.Double(ox,0,ox,sy));
        lines.add(new Line2D.Double(0,oy,sx,oy));

        for(int i=0;i<sy;i++){
            for(int j=0;j<sx;j++){
                int d=(int)Math.sqrt(Math.pow(ox-j,2)+Math.pow(oy-i,2));
                if(i==oy && d%100==0){
                    int y=i>=10?i-10:0;
                    lines.add(new Line2D.Double(j,y,j,i+10));
                }else if(j==ox && d%100==0){
                    int x=j>=10?j-10:0;
                    lines.add(new Line2D.Double(x,i,j+10,i));
                }else if(i==oy && d%10==0){
                    int y=i>=3?i-3:0;
                    lines.add(new Line2D.Double(j,y,j,i+3));
                }else if(j==ox && d%10==0){
                    int x=j>=3?j-3:0;
                    lines.add(new Line2D.Double(x,i,j+3,i));
                }
            }
        }

        System.out.println("size: "+lines.size()+" w:"+sx+", h: "+sy);
        this.revalidate();
        this.repaint();
    }

    public ArrayList<Polygon> getElements(){
        return elements;
    }

    public void setElements(ArrayList<Polygon> elements){
        this.elements=elements;
    }

    public void addElement(Polygon e){
        System.out.println("E size pre: "+elements.size());
        this.elements.add(e);
        System.out.println("E size post: "+elements.size());
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
            copyElement();
            flag=false;
        this.revalidate();
        this.repaint();
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

    @Override
    public void mouseDragged(MouseEvent e) {

        for(int i=0;i<copyOfElement.npoints;i++){
            copyOfElement.xpoints[i]=(copyPoint.xpoints[i]-(e.getX()-sx/2));
            copyOfElement.ypoints[i]=(copyPoint.ypoints[i]-(e.getY()-sy/2));
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void copyElement(){

        int x[]=new int[elements.get(0).npoints];
        int y[]=new int[elements.get(0).npoints];

        for(int i=0;i<elements.get(0).npoints;i++){
            x[i]=elements.get(0).xpoints[i];
            y[i]=elements.get(0).ypoints[i];
        }

        copyOfElement=new Polygon(x,y,x.length);
        copyPoint=new Polygon(x,y,x.length);
    }
}
