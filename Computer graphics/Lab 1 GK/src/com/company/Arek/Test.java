package com.company.Arek;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

    public class Test
    {
        public static void main(String[] args)
        {

            BufferedImage p1 = null;
            BufferedImage p2 = null;
            BufferedImage image;

            try {
                p1 = ImageIO.read(new File("H:\\Pictures\\1.png"));
                p2 = ImageIO.read(new File("H:\\Pictures\\2.png"));
            } catch (IOException e) {
                System.out.println("Input error!");
            }

            final double a=0.1;
            int y=p1.getHeight();
            int x=p1.getWidth();

            image=new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);

            int pw;
            for(int i=0;i<y;i++){
                for(int j=0;j<x;j++){
                    int rgb1=p1.getRGB(j,i);
                    int rgb2=p2.getRGB(j,i);
                    int r1= (rgb1 >> 16)& 0x000000FF;
                    int r2= (rgb2 >> 16)& 0x000000FF;
                    int g1= (rgb1 >> 8) & 0x000000FF;
                    int g2= (rgb2 >> 8) & 0x000000FF;
                    int b1= rgb1 & 0x000000FF;
                    int b2= rgb2 & 0x000000FF;

                    int r3=(int)(a*r1+(1-a)*r2);
                    int g3=(int)(a*g1+(1-a)*g2);
                    int b3=(int)(a*b1+(1-a)*b2);
                    pw=int2RGB(r3,g3,b3);
                    image.setRGB(j,i,pw);
                }
            }

            //Saving
            try
                {
                    ImageIO.write(image, "bmp", new File( "34.bmp"));
                    System.out.println( "Image saved!");
                }
            catch (IOException e)
                {
                    System.out.println( "Fuck you!" );
                }

        }

        // This method assembles RGB color intensities into single
        // packed integer. Arguments must be in <0..255> range
        static int int2RGB( int red, int green, int blue)
        {
            // Make sure that color intensities are in 0..255 range
            red = red & 0x000000FF;
            green = green & 0x000000FF;
            blue = blue & 0x000000FF;

            // Assemble packed RGB using bit shift operations
            return (red << 16) + (green << 8) + blue;
        }
    }

