package Zadanie1;

public class Zad3d extends FirstImage {

    int w; // wielkość pola kwadratowego w pikselach
    int rk1;
    int gk1;
    int bk1;
    int rk2;
    int gk2;
    int bk2;

    public Zad3d(int x, int y, int w,int red_k1,int green_k1,int blue_k1,int red_k2,int green_k2,int blue_k2) {
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

        int color_k1=int2RGB(rk1,gk1,bk1);
        int color_k2=int2RGB(rk2,gk2,bk2);

        for ( int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                int x_inTile = i % (2*w);
                int y_inTile = j % (2*w);

                int d=(int) distance(w,w,x_inTile,y_inTile);
                int r=d/2;

                if (r%2==0) {
                    image.setRGB(i, j, color_k2);
                }
                else {
                    image.setRGB(i, j, color_k1);
                }
            }
        }
    }

    private double distance(int ax,int ay,int bx,int by){
        return Math.sqrt(Math.pow((bx-ax),2)+Math.pow((by-ay),2));
    }
}
