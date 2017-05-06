package Zadanie2;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {

        private JScrollPane scroll;
        private MyJLabel image;
        private int n;

        public MyJPanel(DefaultListModel listModel){
            n=0;

            this.setLayout(new GridBagLayout());
            //JPanel pi=new JPanel();
            image=new MyJLabel(this,listModel);
            image.setSize(500,500);

            this.add(image);

            scroll=new JScrollPane(image);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        }

    public JScrollPane getScroll(){
        return scroll;
    }

    public MyJLabel getImage(){
        return image;
    }

    public void setN(int n){
        this.n=n;
    }

    public int getN(){
        return n;
    }
}

