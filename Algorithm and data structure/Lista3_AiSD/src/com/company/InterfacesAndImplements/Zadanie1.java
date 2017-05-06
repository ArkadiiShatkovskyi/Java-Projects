package com.company.InterfacesAndImplements;


import java.util.Scanner;

public class Zadanie1 {

    public Zadanie1(){
        czytaj();
    }

    public void czytaj(){
        StosOnp listStack=new StosOnp();
        Object el = null;
        double wyn=-1;
        boolean flag=false;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Wprowadz dane: ");
        while (scanner.hasNext()&&!flag){
            if(scanner.hasNextInt()){
                int num=scanner.nextInt();
                double num_el=(double)num;
               // System.out.println("num: "+num_el);
                listStack.push(num_el);
            }
            else if(scanner.hasNextDouble()){
                //System.out.printf("num: "+scanner.nextDouble());
                listStack.push(scanner.nextDouble());
            }
            else{
                String[] s=(scanner.next()).split(" ");
            for(int j=0;j<s.length;j++){
                switch (s[j]){
                    case "+":
                        if(wyn==-1){
                        double right=(Double)listStack.shift();
                        double left=(Double)listStack.shift();
                        wyn=right+left;
                    }
                    else{
                        double nextEl=(Double)listStack.shift();
                        wyn=wyn+nextEl;
                    }
                      //  System.out.println("wynik +: "+wyn);
                        break;
                    case "-":
                        if(wyn==-1){
                            double right=(Double)listStack.shift();
                            double left=(Double)listStack.shift();
                        wyn=right-left;
                    }
                    else{
                        double nextEl=(Double)listStack.shift();
                        wyn=wyn-nextEl;
                    }
                       // System.out.println("wynik -: "+wyn);
                        break;
                    case "/":
                        if(wyn==-1){
                            double right=(Double)listStack.shift();
                            double left=(Double)listStack.shift();
                        wyn=(double)right/left;
                    }
                    else{
                        double nextEl=(Double)listStack.shift();
                        wyn=(double)wyn/nextEl;
                    }
                        break;
                    case "*":
                        if(wyn==-1){
                            double right=(Double)listStack.shift();
                            double left=(Double)listStack.shift();
                        wyn=right*left;
                    }
                    else{
                        double nextEl=(Double)listStack.shift();
                        wyn=wyn*nextEl;
                    }
                        break;
                    case "^":
                        if(wyn==-1){
                            double right=(Double)listStack.shift();
                            double left=(Double)listStack.shift();
                        wyn=Math.pow(right,left);
                    }
                    else{
                        double nextEl=(Double)listStack.shift();
                        wyn=Math.pow(wyn,nextEl);
                    }
                        break;
                    case "log":
                        if(!listStack.isEmpty()){
                        double right=(Double)listStack.shift();
                        wyn=Math.log(right);
                        }
                        else{
                            double x=wyn;
                            wyn=Math.log10(x);
                        }
                        break;
                    case "end": flag=true; break;
                }
              }
            }
        }
        scanner.close();
        System.out.println("wynik: "+ wyn);
    }
}
