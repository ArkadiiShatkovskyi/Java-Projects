package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Form {

    public JFrame frame;
    public JPanel panel_north;
    public MyJPanel panel_left;
    public JPanel panel_right;
    private JList list_Elements;
    public DefaultListModel listModel;

    Form(){
        frame=new JFrame("Laboratorium 2 Arkadii Shatkovskyi");
        frame.setMinimumSize(new Dimension(1200,800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel listModel = new DefaultListModel();
        panel_left=new MyJPanel(listModel);
        panel_north=new JPanel();
        panel_right=new JPanel();

        JScrollPane scrollPane = new JScrollPane();
        list_Elements=new JList(listModel);
        list_Elements.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        MyJListListener myJListListener=new MyJListListener();
        myJListListener.setData(list_Elements,panel_left);

        //list_Elements.addListSelectionListener(myJListListener);
        list_Elements.addMouseListener(myJListListener);
        scrollPane.setViewportView(list_Elements);

        GridLayout gl=new GridLayout();
        panel_north.setLayout(gl);
        gl.setHgap(0);
        gl.setVgap(0);

        JPanel pp=new JPanel();
        pp.setPreferredSize(new Dimension(800,40));
        panel_north.add(pp);

        JButton draw_S=new JButton("Prostokąt");
        draw_S.setPreferredSize(new Dimension(100,30));
        draw_S.addMouseListener(buttonListener(1));

        pp.add(draw_S);
        JButton draw_C=new JButton("Koło");
        draw_C.setPreferredSize(new Dimension(100,30));
        draw_C.addMouseListener(buttonListener(2));

        pp.add(draw_C);

        JButton draw_M=new JButton("Wielokąt");
        draw_M.setPreferredSize(new Dimension(100,30));
        draw_M.addMouseListener(buttonListener(3));

        pp.add(draw_M);

        panel_right.setLayout(new BorderLayout());
        JPanel elements=new JPanel();
        panel_right.add(elements,BorderLayout.NORTH);
        //elements.setLayout(new GridLayout());
        elements.add(new JLabel("Zaznaczone elementy"));

        JPanel pl=new JPanel();
        pl.setPreferredSize(new Dimension(100,300));
        panel_right.add(pl);
        list_Elements.setLayoutOrientation(JList.VERTICAL);

        pl.add(list_Elements);

        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("File");

        JMenuItem saveImage=new JMenuItem("Save");
        menu.add(saveImage);
        SaveButtonListener sbl=new SaveButtonListener(panel_left.getImage());
        saveImage.addActionListener(sbl);

        JMenuItem openImage=new JMenuItem("Load image");
        menu.add(openImage);
        OpenListener op=new OpenListener(panel_left,sbl,panel_left.getImage());
        openImage.addActionListener(op);

        JMenuItem loadElements=new JMenuItem("Load elements");
        menu.add(loadElements);
        loadElements.addActionListener(new LoadElementsListener(panel_left.getImage()));

        JMenuItem closeApp=new JMenuItem("Close program");
        menu.add(closeApp);
        closeApp.addActionListener(new CloseListener());

        menuBar.add(menu);

        frame.getContentPane().add(BorderLayout.CENTER,panel_left);
        frame.getContentPane().add(BorderLayout.NORTH,panel_north);
        frame.getContentPane().add(BorderLayout.EAST,panel_right);
        frame.getContentPane().add(panel_left.getScroll());


        frame.setJMenuBar(menuBar);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public MouseListener buttonListener(int n){
        MouseListener ms=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel_left.setN(n);
                System.out.println(n);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        return ms;
    }

}
