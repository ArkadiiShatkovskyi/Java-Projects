package Zadanie1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstImage {

    protected int x;
    protected int y;
    protected BufferedImage image;

    public FirstImage(int x,int y){
        this.x=x;
        this.y=y;
        image=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
    }

    public void draw(){
        int white=int2RGB( 255, 255, 255 );
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                image.setRGB(i,j,white);
            }
        }
    }

    public int int2RGB( int red, int green, int blue)
     {
         // Make sure that color intensities are in 0..255 range
         red = red & 0x000000FF;
         green = green & 0x000000FF;
         blue = blue & 0x000000FF;

         // Assemble packed RGB using bit shift operations
         return (red << 16) + (green << 8) + blue;
     }

    public void save(String name){
        try
        {
            ImageIO.write( image, "bmp", new File(name) );
            System.out.println( "Image saved as "+name+"!");
        }
        catch (IOException e)
        {
            System.out.println( "Error while saving!" );
        }
    }
}
