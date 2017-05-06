package com.company.Arek.KalkulatorTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

class GUI{

    JFrame ramka;
    JPanel panel_east;
    JPanel panel_west;

    JTextField TxtField;

    long tmp1 = 0;
    long tmp2 = 0;

    boolean flaga=true;

    GUI(){

        ramka = new JFrame();
        ramka.setSize(600, 400);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        TxtField = new JTextField();
        ramka.getContentPane().add(BorderLayout.NORTH,TxtField);

        panel_east = new JPanel();
        panel_west = new JPanel();

        panel_east.setLayout(new BoxLayout(panel_east,BoxLayout.Y_AXIS));

        GridLayout gl = new GridLayout(4,1);
        panel_west.setLayout(gl);
        gl.setVgap(5);

        ramka.getContentPane().add(BorderLayout.EAST,panel_east);
        ramka.getContentPane().add(BorderLayout.WEST,panel_west);


        JPanel p4 = new JPanel();
        panel_east.add(p4);

        JButton B7 = new JButton("7");
        p4.add(B7);
        B7.addActionListener(new Klasa_B7());

        JButton B8 = new JButton("8");
        p4.add(B8);
        B8.addActionListener(new Klasa_B8());


        p4.add(new JButton("9"));

        JPanel p3 = new JPanel();
        panel_east.add(p3);
        p3.add(new JButton("4"));
        p3.add(new JButton("5"));
        p3.add(new JButton("6"));

        JPanel p2 = new JPanel();
        panel_east.add(p2);
        p2.add(new JButton("1"));
        p2.add(new JButton("2"));
        p2.add(new JButton("3"));

        JPanel p1 = new JPanel();
        panel_east.add(p1);
        p1.add(new JButton("0"));

        JButton plus = new JButton("+");
        p1.add(plus);
        plus.addActionListener(new Klasa_plus());

        JButton r = new JButton("=");
        p1.add(r);
        r.addActionListener(new Klasa_r());


        JButton sin = new JButton("sin(x)");
        panel_west.add(sin);
        sin.addActionListener(new Klasa_sin());


        panel_west.add(new JButton("cos(x)"));
        panel_west.add(new JButton("tg(x)"));
        panel_west.add(new JButton("ctg(x)"));



        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Kalkulator");

        JMenuItem menuItem = new JMenuItem("Clear - C");
        menuItem.addActionListener(new Klasa_C());

        menu.add(menuItem);
        menuBar.add(menu);

        ramka.setJMenuBar(menuBar);

        ramka.setResizable(false);
        ramka.setAlwaysOnTop(true);
        ramka.pack();
        ramka.setVisible(true);

    }

    class Klasa_B7 implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            if (flaga) TxtField.setText(TxtField.getText() + "7");
            else {

                TxtField.setText("7");
                flaga=true;
            }
        }

    }


    class Klasa_B8 implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            if (flaga) TxtField.setText(TxtField.getText() + "8");
            else {
                TxtField.setText("8");
                flaga = true;
            }
        }

    }



    class Klasa_plus implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            tmp1 = Long.parseLong(TxtField.getText());

            flaga = false;
        }

    }

    class Klasa_r implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            tmp2 = Long.parseLong(TxtField.getText());
            TxtField.setText(((Long)(tmp1+tmp2)).toString());

            flaga = true;
        }

    }


    class Klasa_C implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            TxtField.setText("");
        }

    }


    class Klasa_sin implements ActionListener{


        public void actionPerformed(ActionEvent arg0) {

            TxtField.setText(((Double)(Math.sin(Long.parseLong(TxtField.getText())))).toString());
        }

    }

}