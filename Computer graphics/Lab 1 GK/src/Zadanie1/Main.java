package Zadanie1;

import com.company.Arek.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        //int black = int2RGB( 0, 0, 0 );
        //int white = int2RGB( 255, 255, 255 );

        Zad1b z=new Zad1b(300,300,50,50,10,255,255,255,111,62,150);
        z.draw();
        z.save("zad1b.bmp");

        Zad1ca zca=new Zad1ca(300,300,25,0,0,0,255,255,255);
        zca.draw();
        zca.save("zad1ca.bmp");

        Zad1cb zcb=new Zad1cb(300,300,25,0,0,0,255,255,255);
        zcb.draw();
        zcb.save("zad1cb.bmp");


        Zad3a z3a=new Zad3a(500,500,20,0,0,0,128,128,128);
        z3a.draw();
        z3a.save("zad3a.bmp");


        Zad3b z3b=new Zad3b(1600,900,100,0,0,0,255,255,255);
        z3b.draw();
        z3b.save("zad3b.bmp");


        Zad3d z3d=new Zad3d(500,500,15,0,0,0,255,255,255);
        z3d.draw();
        z3d.save("zad3d.bmp");


        BufferedImage img = null;
        try {
            img= ImageIO.read(new File("H:\\Pictures\\other\\cat.jpeg"));
        } catch (IOException e) {
            System.out.println("Input error!");
        }

        Zadanie2 zad2=new Zadanie2(300,300,img);
        zad2.draw();
        zad2.save("zadanie2.bmp");


        Zad3c zad3c=new Zad3c(300,300);
        zad3c.draw();
        zad3c.save("zad3c.bmp");

        Zad3g zad3g=new Zad3g(300,300);
        zad3g.draw();
        zad3g.save("zad3g.bmp");

        Zad1a zad1a=new Zad1a(500,500);
        zad1a.draw();
        zad1a.save("zad1a.bmp");

        BufferedImage img2 = null;
        BufferedImage img3 = null;
        try {
            img2= ImageIO.read(new File("H:\\Pictures\\raccoon.jpg"));
            img3= ImageIO.read(new File("H:\\Pictures\\cat.jpg"));
        } catch (IOException e) {
            System.out.println("Input error!");
        }

        Zadanie4 zad4=new Zadanie4(100,100,img2,img3, z3a.image);
        zad4.draw();
        zad4.save("Zadanie4.bmp");

    }
}
