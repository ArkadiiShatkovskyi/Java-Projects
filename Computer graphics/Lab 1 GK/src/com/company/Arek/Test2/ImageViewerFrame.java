package com.company.Arek.Test2;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Arek on 10/31/2016.
 */
class ImageViewerFrame extends JFrame
{
    Panel panel;
    public ImageViewerFrame()
    {
        setTitle("ImageViewer");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // use a label to display the images
        label = new JLabel();
        Container contentPane = getContentPane();
        contentPane.add(label);

        // set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt)
         {
             // show file chooser dialog

             FileFilter filter= new FileNameExtensionFilter("Image jpg", "jpg","jpeg");
             chooser.addChoosableFileFilter(filter);
             int r = chooser.showDialog(panel, "chooice dialog");
             // if file selected, set it as icon of the label
             if(r == JFileChooser.APPROVE_OPTION)
             {
                 String name
                         = chooser.getSelectedFile().getPath();
                 label.setIcon(new ImageIcon(name));
             }
         }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(new
                                           ActionListener()
                                           {
                                               public void actionPerformed(ActionEvent event)
                                               {
                                                   System.exit(0);
                                               }
                                           });
    }

    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
}
