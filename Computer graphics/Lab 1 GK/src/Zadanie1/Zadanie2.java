package Zadanie1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zadanie2 extends FirstImage {

    BufferedImage img;
    int x;
    int y;
    int w=50; // wielkość pola kwadratowego w pikselach
    int rk1=0;
    int gk1=0;
    int bk1=0;


    public Zadanie2(int x, int y,BufferedImage img) {
        super(img.getWidth(), img.getHeight());

        this.img = img;
        this.x=img.getWidth();
        this.y=img.getHeight();
    }

    @Override
    public void draw(){

        int color_k=int2RGB(rk1,gk1,bk1);
        int pw;

        for(int i=0;i<this.x;i++){
            for(int j=0;j<this.y;j++){

                int x_inTile = i % (2*w+1);
                int y_inTile = j % (2*w+1);

                if ((x_inTile <= w && y_inTile <= w) || (y_inTile > w && x_inTile > w )) {
                    image.setRGB(i, j, color_k);
                }
                else {
                    int rgbi=img.getRGB(i,j);
                    int ri= (rgbi >> 16)& 0x000000FF;
                    int gi= (rgbi >> 8) & 0x000000FF;
                    int bi= rgbi & 0x000000FF;
                    pw=int2RGB(ri,gi,bi);
                    image.setRGB(i, j, pw);
                }
            }
        }
    }

}
