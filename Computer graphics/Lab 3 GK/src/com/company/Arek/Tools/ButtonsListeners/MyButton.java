package com.company.Arek.Tools.ButtonsListeners;

import com.company.Arek.Tools.Rastor_label;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MyButton extends JButton {


    public MyButton(){}

    protected Polygon createPolygon(ArrayList<Point.Double> points){
        int[] x=new int[points.size()];
        int[] y=new int[points.size()];
        for(int i=0;i<points.size();i++){
            x[i]=(int) points.get(i).x;
            y[i]=(int) points.get(i).y;
        }
        return new Polygon(x,y,x.length);
    }

    protected double[] multiplication(double[][] matrix,double[] point){

        double res[]=new double[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                res[i]+=matrix[i][j]*point[j];
            }
        }
        return res;
    }

    protected double[][] multiplicationMatrix(double[][] mA,double[][] mB){

        double[][] res = new double[3][3];

        int m=mA.length;
        int n=mB[0].length;
        int o=mB.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
        return res;
    }

    protected void toString(ArrayList<Polygon> polygons){
        String s="";
        for(int i=0;i<polygons.size();i++){
            for(int j=0;j<polygons.get(i).npoints;j++){
                s+="[x"+j+": "+polygons.get(i).xpoints[j]+"; y"+j+": "+polygons.get(i).ypoints[j]+"]";
            }
        }
        System.out.println("Result: "+s);
    }

    protected BufferedImage convertImage(BufferedImage image, Rastor_label label){

        BufferedImage temp1=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
        BufferedImage temp2=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);

        for(int z=0;z<image.getHeight();z++){
            for(int j=0,i=image.getWidth()-1;j<image.getWidth();j++,i--){
                temp1.setRGB(j,z,image.getRGB(i,z));
            }
        }

        for(int z=0,i=temp1.getHeight()-1;z<temp1.getHeight();z++,i--){
            for(int j=0;j<temp1.getWidth();j++){
                temp2.setRGB(j,z,temp1.getRGB(j,i));
            }
        }
        label.setFlag(true,true);

        return temp2;
    }

    protected BufferedImage convertOne(BufferedImage image, boolean flag1, Rastor_label label){
        BufferedImage result;
        if(flag1){
            BufferedImage temp=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
            for(int z=0;z<image.getHeight();z++){
                for(int j=0,i=image.getWidth()-1;j<image.getWidth();j++,i--){
                    temp.setRGB(j,z,image.getRGB(i,z));
                }
            }
            label.setFlag(true,false);
            result=temp;
        }else{
            BufferedImage temp=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
            for(int z=0,i=image.getHeight()-1;z<image.getHeight();z++,i--){
                for(int j=0;j<image.getWidth();j++){
                    temp.setRGB(j,z,image.getRGB(j,i));
                }
            }
            label.setFlag(false,true);
            result=temp;
        }
        return result;
    }

    private double determinantOfMatrix(double[][] matrix) {
        double determinant = 0;

        if (matrix.length == 1 && matrix[0].length == 1) {
            determinant = matrix[0][0];
        } else if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Nie można wyznaczyć wyznacznika dla macierzy która nie jest kwadratowa");
        } else if (matrix.length == 2 && matrix[0].length == 2) {
            determinant = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
        } else {
            double[][] nTab = new double[matrix.length + (matrix.length - 1)][matrix[0].length];
            for (int i = 0, z = 0; i < nTab.length; i++, z++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (z < matrix.length && j < matrix[0].length) {
                        nTab[i][j] = matrix[z][j];
                    } else {
                        z = 0;
                        nTab[i][j] = matrix[z][j];
                    }
                }
            }

            double multiplication = 1;
            int iX;

            for (int i = 0; i < matrix.length; i++) {
                iX = i;
                for (int j = 0; j < matrix[0].length; j++) {
                    multiplication *= nTab[iX][j];
                    iX++;
                }
                determinant += multiplication;
                multiplication = 1;
            }

            multiplication = 1;
            for (int i = 0; i < matrix.length; i++) {
                iX = i;
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    multiplication *= nTab[iX][j];
                    iX++;
                }
                determinant -= multiplication;
                multiplication = 1;
            }
        }
        return determinant;
    }

    private boolean isSquare(double[][] matrix) {
        if (matrix[0].length == matrix.length) {
            return true;
        } else {
            return false;
        }
    }

    protected double[][] reverseMatrix(double[][] matrix) {
        if (!this.isSquare(matrix)) {
            throw new RuntimeException("Macierz nie jest kwadratowa!");
        } else {
            double[][] reversedMatrix;

            if (matrix.length == 1) {
                reversedMatrix = new double[1][1];
                reversedMatrix[0][0] = 1 / determinantOfMatrix(matrix);
                return reversedMatrix;
            } else {
                //reversedMatrix = new double[matrix.length][matrix[0].length];
                double[][] addedMatrix = new double[matrix.length][matrix[0].length];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        double[][] temp = new double[matrix.length - 1][matrix.length - 1];
                        int a = 0, b = 0;
                        for (int w = 0; w < matrix.length; w++) {
                            for (int z = 0; z < matrix[0].length; z++) {
                                if (w != i && z != j) {
                                    if (b >= temp.length) {
                                        b = 0;
                                        a++;
                                    }
                                    temp[a][b] = matrix[w][z];
                                    b++;
                                }
                            }
                        }

                        double tempDeterminant = determinantOfMatrix(temp);

                        if ((i + j) % 2 != 0) {  //Niparzyste czyli zmiana znaku wyznacznika
                            if (tempDeterminant > 0) {
                                tempDeterminant -= 2 * tempDeterminant;
                            } else {
                                tempDeterminant -= 2 * tempDeterminant;
                            }
                        } else {
                        }
                        addedMatrix[i][j] = tempDeterminant;
                    }
                }
                addedMatrix = this.transpositionOfMatrix(addedMatrix);
                reversedMatrix = this.multiplicationOnNumber(1 / determinantOfMatrix(matrix), addedMatrix);
                return reversedMatrix;
            }
        }
    }

    private double[][] transpositionOfMatrix(double[][] matrix) {
        double[][] matrixTransposition = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixTransposition[j][i] = matrix[i][j];
            }
        }
        return matrixTransposition;
    }

    private double[][] multiplicationOnNumber(double number, double[][] matrix) {
        double[][] multiplicateMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                multiplicateMatrix[i][j] = (matrix[i][j] * number);
            }
        }
        return multiplicateMatrix;
    }

    protected int int2RGB( int red, int green, int blue)
    {
        red = red & 0x000000FF;
        green = green & 0x000000FF;
        blue = blue & 0x000000FF;

        return (red << 16) + (green << 8) + blue;
    }

    protected double[] getP(int x,int y,double[][] m){
        double res[]=new double[2];
        double temp[] = {x, y, 1};
        temp = multiplication(m, temp);
        res[0]=temp[0];
        res[1]=temp[1];
        return res;
    }

    protected int[] color(int x1,int y1,int x2,int y2,double x,double y, BufferedImage image,boolean flag){
        int rgb[]=new int[3];
        int w=image.getWidth();
        int h=image.getHeight();
        double alpha=x-(int)x;
        double beta=y-(int)y;
        double xr1;
        double xr2;
        double yr1;
        double yr2;

        //System.out.println("x1:"+x1+';'+" y1:"+y1+" x2:"+x2+';'+"y2:"+y2+';'+" x:"+x+';'+" y:"+y+';');
        int r1=0;
        int g1=0;
        int b1=0;
        if(x1<w-1 && x1>=0 && y1<h-1 && y1>=0){
            int rgb1=image.getRGB(x1,y1);
            r1= (rgb1 >> 16)& 0x000000FF;
            g1= (rgb1 >> 8) & 0x000000FF;
            b1= rgb1 & 0x000000FF;
        }

        int r2=0;
        int g2=0;
        int b2=0;
        if(x2<w-1 && x2>=0 && y1<h-1 && y1>=0){
            int rgb2=image.getRGB(x2,y1);
            r2= (rgb2 >> 16)& 0x000000FF;
            g2= (rgb2 >> 8) & 0x000000FF;
            b2= rgb2 & 0x000000FF;
        }

        int r3=0;
        int g3=0;
        int b3=0;
        if(x1<w-1 && x1>=0 && y2<h-1 && y2>=0){
            int rgb3=image.getRGB(x1,y2);
            r3= (rgb3 >> 16)& 0x000000FF;
            g3= (rgb3 >> 8) & 0x000000FF;
            b3= rgb3 & 0x000000FF;
        }

        int r4=0;
        int g4=0;
        int b4=0;
        if(x2<w-1 && x2>=0 && y2<h-1 && y2>=0){
            int rgb4=image.getRGB(x2,y2);
            r4= (rgb4 >> 16)& 0x000000FF;
            g4= (rgb4 >> 8) & 0x000000FF;
            b4= rgb4 & 0x000000FF;
        }
        if(flag){
            /******** RED ********/
            rgb[0]=(int) algorytm(r1,r2,r3,r4,x,y);
            /******** GREEN ********/
            rgb[1]=(int) algorytm(g1,g2,g3,g4,x,y);
            /******** BLUE ********/
            rgb[2]=(int) algorytm(b1,b2,b3,b4,x,y);
        }else{
            /******** RED ********/
            rgb[0]=(int) algorytmNN(r1,r2,r3,r4,x,y);
            /******** GREEN ********/
            rgb[1]=(int) algorytmNN(g1,g2,g3,g4,x,y);
            /******** BLUE ********/
            rgb[2]=(int) algorytmNN(b1,b2,b3,b4,x,y);
        }
        return rgb;
    }

    private double algorytm(int c1, int c2, int c3, int c4, double x, double y){
        double alpha=x-(int)x;
        double beta=y-(int)y;
        double kAR=(1-alpha)*c1+alpha*c2;
        double kBR=(1-alpha)*c3+alpha*c4;
        double kDR=(1-beta)*kAR+beta*kBR;
        return kDR;
    }

    private double algorytmNN(int c1, int c2, int c3, int c4, double x, double y){
        double alpha=Math.round(x-(int)x);
        double beta=Math.round(y-(int)y);

        double kAR=(1-alpha)*c1+alpha*c2;
        double kBR=(1-alpha)*c3+alpha*c4;
        double kDR=(1-beta)*kAR+beta*kBR;
        //return Math.round(kDR);
        return Math.round(kDR);
    }

    protected double min(double n[]){
        double result=n[0];
        for(int i=1;i<4;i++){
            if(n[i]<result){result=n[i];}
        }
        return result;
    }

    protected double min(double n[],double[] len){
        int ind=0;
        double result=n[ind];
        for(int i=1;i<4;i++){
            if(len[ind]>len[i]){result=n[i];ind=i;}
        }
        return result;
    }

    protected double max(double n[]){
        double result=n[0];
        for(int i=1;i<4;i++){
            if(n[i]>result){result=n[i];}
        }
        return result;
    }
}
