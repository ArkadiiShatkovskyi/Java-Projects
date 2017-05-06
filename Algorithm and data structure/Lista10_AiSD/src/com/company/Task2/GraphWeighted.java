package com.company.Task2;

import com.company.Task1.GraphList.Comp;
import com.company.Task1.GraphList.Element;

import java.util.ArrayList;

public class GraphWeighted {

    private ArrayList<Element> listElements = new ArrayList<Element>();
    private Comp comp= new Comp();//comparator Character
    private CompString compS=new CompString(); // comparator String
    private ArrayList<Way> weightWay=new ArrayList<Way>();

    protected class Way{           // klasa dla wag pomiedzy elementami
        char from;
        char to;
        int weight;

        Way(char from,char to,int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }
    }


    public void add(char element){
        if(!onList(element)){
            listElements.add(new Element(element));
        }
    }

    public void addWay(String st,int weight){
        char[] ch=st.toCharArray();
        char way1=ch[0];
        char way2=ch[1];
        if(!onListWays(way1,way2) && !onListWays(way2,way1)){
            weightWay.add(new Way(way1,way2,weight));
        }
        for(Element el:listElements){
            if(comp.compare(el.getValue(),way1)==0){
                el.addWay(way2);
            }
            if(comp.compare(el.getValue(),way2)==0){
                el.addWay(way1);
            }
        }
    }

    private boolean onListWays(char from,char to){
        boolean result=false;
        for(Way w: weightWay){
            if(comp.compare(from,w.from)==0 && comp.compare(to,w.to)==0){
                result=true;
            }
        }
        return result;
    }

    private boolean onList(char value){
        boolean result=false;
        for(Element el:listElements){
            if (comp.compare(el.getValue(),value)==0){
                result=true;
            }
        }
        return result;
    }

    public int indexOnList(char value){
        int result=-1;
        for(int i=0;i<listElements.size();i++){
            if(comp.compare(listElements.get(i).getValue(),value)==0){
                result=i;
            }
        }
        return result;
    }

    public void deleteWay(char value,char way){
        for(Element el:listElements){
            if(comp.compare(el.getValue(),value)==0){
                el.deleteWay(way);
            }
        }
    }

    private void setColor(char elem,String color){
        for(Element e:listElements){
            if(comp.compare(e.getValue(),elem)==0){
                e.setColor(color);
            }
        }
    }

    private int weighWay(char from,char to){
        int result=0;
        for(Way w: weightWay){
            if(comp.compare(from,w.from)==0 && comp.compare(to,w.to)==0){
                result=w.weight;
            }
            else if(comp.compare(to,w.from)==0 && comp.compare(from,w.to)==0){
                result=w.weight;
            }
        }
        return result;
    }

    public void algDijkstry(char from,char to){
        int weigh=0;
        class ways{  // element dla drog od elementu from do innych
            int weigh;
            char elem;
            ways(int weigh,char elem){
                this.weigh=weigh;
                this.elem=elem;
            }
        }
        ArrayList<ways> tab=new ArrayList<ways>();

        boolean flag=false;  //true jesli doslismy do koncowego elementu
        Element element=null;

        for(Element e:listElements){
            e.setColor("white");
        }

        for(Element el:listElements){
            if(comp.compare(el.getValue(),from)==0){
                element=el;
            }
        }
        listElements.remove(element);
        int min=0;
        char nextEl=' ';
        while(!flag){
            if(comp.compare(element.getValue(),from)==0){
               min=weighWay(element.getValue(),element.getWays().get(0));
                nextEl=element.getWays().get(0);
               for(Character el:element.getWays()){
                   setColor(el,"grey");
                   tab.add(new ways(weighWay(element.getValue(),el),el));
                if(weighWay(element.getValue(),el)!=0 && weighWay(element.getValue(),el)<min){
                    min=weighWay(element.getValue(),el);
                    nextEl=el;
                }
               }
                element.setColor("black");
            }// from
            else{
                for(Character ch:element.getWays()){
                    setColor(ch,"grey");
                }
                int min2=min+weighWay(element.getValue(),element.getWays().get(0));
                for(Element e:listElements){
                    if(compS.compare(e.getColor(),"grey")==0 && (min+weighWay(element.getValue(),e.getValue()))<min2){
                        min2=min+weighWay(element.getValue(),e.getValue());
                        nextEl=e.getValue();
                       if(tab.indexOf(new ways(weighWay(element.getValue(),e.getValue()),e.getValue()))==-1){
                           tab.add(new ways(min2,e.getValue()));
                       }
                    }// jezeli element ma kolor siary
                }
                element.setColor("black");
            }
            for(Element e:listElements){
                flag=true;
                if(compS.compare(e.getColor(),"grey")==0){
                    flag=false;
                }
            }
            element=listElements.get(indexOnList(nextEl));
        }// while
        int result=0;
        for(ways w:tab){
            if(comp.compare(w.elem,to)==0){
                result=w.weigh;
            }
        }
        System.out.println("najkrotsze przejscie to: "+result);
    }
}
