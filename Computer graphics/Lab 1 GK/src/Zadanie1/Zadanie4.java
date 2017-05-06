package Zadanie1;

import java.awt.image.BufferedImage;

public class Zadanie4 extends FirstImage {

    BufferedImage img1;
    BufferedImage img2;
    BufferedImage imgS;

    public Zadanie4(int x, int y,BufferedImage img1,BufferedImage img2, BufferedImage imgS) {
        super(img1.getWidth(), img1.getHeight());
        this.img1=img1;
        this.img2=img2;
        this.imgS=imgS;
        imgS=new BufferedImage(img1.getWidth(),img1.getHeight(),BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void draw(){

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){

                    int rgb1=img1.getRGB(i,j);
                    int rgb2=img2.getRGB(i,j);
                    int rgb3=imgS.getRGB(i,j);

                    int r1= (rgb1 >> 16)& 0x000000FF;
                    int r2= (rgb2 >> 16)& 0x000000FF;
                    int rs= (rgb3 >> 16)& 0x000000FF;
                    int g1= (rgb1 >> 8) & 0x000000FF;
                    int g2= (rgb2 >> 8) & 0x000000FF;
                    int gs= (rgb3 >> 8) & 0x000000FF;
                    int b1= rgb1 & 0x000000FF;
                    int b2= rgb2 & 0x000000FF;
                    int bs= rgb3 & 0x000000FF;

                    double ra=rs/255.0;
                    //double ga=gs/255;
                    //double ba=bs/255;
                    int rw=(int) (ra*r1+(1-ra)*r2);
                    int gw=(int) (ra*g1+(1-ra)*g2);
                    int bw=(int) (ra*b1+(1-ra)*b2);
                    int prgb=int2RGB(rw,gw,bw);
                    image.setRGB(i,j,prgb);
            }
        }
    }

}
