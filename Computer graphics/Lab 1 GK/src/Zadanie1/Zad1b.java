package Zadanie1;

public class Zad1b extends FirstImage {

    int size_x;  //rozmiar kwadrata po x
    int size_y; //rozmiar kwadrata po y
    int w;//grubość linii
    int rl;
    int gl;
    int bl;
    int rs;
    int gs;
    int bs;

    public Zad1b(int x, int y, int size_x, int size_y, int w,int red_line,int green_line,int blue_line,int red_s,int green_s,int blue_s) {
        super(x, y);
        this.size_x=size_x;
        this.size_y=size_y;
        this.w=w;
        this.rl=red_line;
        this.gl=green_line;
        this.bl=blue_line;
        this.rs=red_s;
        this.gs=green_s;
        this.bs=blue_s;
    }

    @Override
    public void draw(){
        //int black = int2RGB( 0, 0, 0 );
        //int white = int2RGB( 255, 255, 255 );
        int color_line=int2RGB(rl,gl,gl);
        int color_s=int2RGB(rs,gs,bs);

        for ( int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int x_inTile = (i+size_x/2) % size_x;
                int y_inTile = (j+size_y/2) % size_y;
                if (x_inTile <= w || y_inTile <= w) {
                    image.setRGB(i, j, color_line);
                }
                else {
                    image.setRGB(i, j, color_s);
                }
            }
        }
    }
}
