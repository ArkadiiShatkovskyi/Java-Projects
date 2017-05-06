package Zadanie2;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Element {

    private Object element;
    private int id;
    private String type;

    public Element(Object element, int id){
        this.element=element;
        this.id=id;
        setTypeElement();
    }

    public Object getElement(){
        return element;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    private void setTypeElement(){

        if(element.getClass()==Rectangle2D.Double.class){
            type="Rectangle";
        }
        else if(element.getClass()==Ellipse2D.Double.class){
            type="Ellipse";
        }
        else{
            type="Polygon";
        }
    }

    @Override
    public String toString() {
        return type+" "+(id+1);
    }

    public String getType(){return type;}
}
