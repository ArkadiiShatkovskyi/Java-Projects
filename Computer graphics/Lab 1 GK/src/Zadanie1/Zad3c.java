package Zadanie1;

public class Zad3c extends FirstImage{

    int rk1=0;
    int gk1=0;
    int bk1=0;
    int rk2=255;
    int gk2=255;
    int bk2=255;

    public Zad3c(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(){

        int color_k1=int2RGB(rk1,gk1,bk1);
        int color_k2=int2RGB(rk2,gk2,bk2);
        int a1=1;
        int r=3;

        for ( int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                int d=(int) distance(x/2,y/2,i,j);
                int n=Math.abs((-(2*a1-r)+(int) Math.sqrt(Math.pow((2*a1-r),2)+8*a1*r*d)));

                if (n%2==0) {
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

