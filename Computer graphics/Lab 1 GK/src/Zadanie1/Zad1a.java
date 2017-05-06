package Zadanie1;

public class Zad1a extends FirstImage{


    public Zad1a(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(){

        int white=int2RGB( 255, 255, 255 );
        //int black=int2RGB( 0, 0, 0 );
        int xa=x/2;
        int ya=y/2;

        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){

                double d=distance(xa,ya,i,j);
                double n=Math.cos(d);

                if(n<0) {
                    n = 0;
                }
                else if(n>1) {
                    n = 1;
                }

                int r1= 255 & 0x000000FF;
                int r2= 0   & 0x000000FF;
                int g1= 255 & 0x000000FF;
                int g2= 0   & 0x000000FF;
                int b1= 255 & 0x000000FF;
                int b2= 0   & 0x000000FF;

                int r3=(int)(n*r1+(1-n)*r2);
                int g3=(int)(n*g1+(1-n)*g2);
                int b3=(int)(n*b1+(1-n)*b2);
                int res=int2RGB(r3,g3,b3);

                image.setRGB( i, j, res );
            }
        }
    }
    private double distance(int ax,int ay,int bx,int by){
        return Math.sqrt(Math.pow((bx-ax),2)+Math.pow((by-ay),2));
    }
}
