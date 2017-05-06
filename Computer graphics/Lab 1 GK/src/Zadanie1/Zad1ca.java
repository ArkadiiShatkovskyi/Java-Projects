package Zadanie1;

public class Zad1ca extends FirstImage {

    int w; // wielkość pola kwadratowego w pikselach
    int rk1;
    int gk1;
    int bk1;
    int rk2;
    int gk2;
    int bk2;

    public Zad1ca(int x, int y, int w,int red_k1,int green_k1,int blue_k1,int red_k2,int green_k2,int blue_k2) {
        //kolory pól, wielkość pola(kwadratowego) w pikselach, rozdzielczość obrazu wynikowego
        super(x, y);
        this.w=w;
        this.rk1=red_k1;
        this.gk1=green_k1;
        this.bk1=blue_k1;
        this.rk2=red_k2;
        this.gk2=green_k2;
        this.bk2=blue_k2;
    }

    @Override
    public void draw(){

        int color_k1=int2RGB(rk1,gk1,gk1);
        int color_k2=int2RGB(rk2,gk2,bk2);

        for ( int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int x_inTile = i % (2*w+1);
                int y_inTile = j % (2*w+1);

                if ((x_inTile <= w && y_inTile <= w) || (y_inTile > w && x_inTile > w )) {
                    image.setRGB(i, j, color_k1);
                }
                else {
                    image.setRGB(i, j, color_k2);
                }
            }
        }
    }
}
