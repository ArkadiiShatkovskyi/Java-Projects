package com.company.Arek.Tools;

import com.company.Arek.Interface.OtherElements.ImageR;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Rastor_label extends ImageR {

    private int sx;
    private int sy;
    private int ix;
    private int iy;
    private ArrayList<Line2D.Double> lines;
    private BufferedImage image;
    private int[] temp_image;
    private boolean flag;
    private boolean flag2;
    private boolean flagNN;

    public Rastor_label(int size_x,int size_y){
        super(size_x,size_y);

        lines=new ArrayList<>();
        this.sx=size_x;
        this.sy=size_y;
        this.getPreferredSize();
        this.setSize(size_x,size_y);
        this.ix=0;
        this.iy=0;
        this.flag=false;
        this.flag2=false;
        this.flagNN=true;
        this.image=new BufferedImage(10,10,BufferedImage.TYPE_4BYTE_ABGR);
        temp_image=new int[2];
        drawOXY();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        //System.out.println("TUTAJ size: "+lines.size()+ "TUTAJ  !!!!!!!!!!");
        transfer();

        for(int i=0;i<lines.size();i++){
            g2d.draw(lines.get(i));
        }
        if(temp_image!=null){
            g2d.drawImage(image,null, temp_image[0], temp_image[1]);
        }
    }

    private void transfer(){
        if(image!=null){
            if(flag){
                if(ix>0){
                    ix= ix-(2*ix+image.getWidth());
                }else if(ix<0){
                    ix= ix+((2*ix+image.getWidth())*-1);
                }
                flag=false;
            }
            if(flag2){
                if(iy>0){
                    iy= iy-(2*iy+image.getHeight());
                }else if(iy<0){
                    iy= iy+((2*iy+image.getHeight())*-1);
                }
                flag2=false;
            }

            int x1= ix+sx/2;
            int y1= iy+sy/2;
            temp_image[0]=x1;
            temp_image[1]=y1;
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

    public void addImage(BufferedImage image){
        this.image=image;
        this.ix=10;
        this.iy=10;
        this.revalidate();
        this.repaint();
    }

    public void changeImage(BufferedImage image){
        this.image=image;
        this.revalidate();
        this.repaint();
    }

    public int getIx(){return ix;}

    public int getIy(){return iy;}

    public void setIXY(int x,int y){
        this.ix=x;
        this.iy=y;
        this.revalidate();
        this.repaint();
    }

    public void setIX(int x){
        this.ix=x;
    }

    public void setIY(int y){
        this.iy=y;
    }

    public void setFlag(boolean flag,boolean flag2){
        this.flag=flag;
        this.flag2=flag2;
        /*this.revalidate();
        this.repaint();*/
    }

    public BufferedImage getImage(){
        return image;
    }

    public boolean isFlagNN() {
        return flagNN;
    }

    public void setFlagNN(boolean flagNN) {
        this.flagNN = flagNN;
    }
}
