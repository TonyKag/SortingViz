/*
 public Class Graph_Frame
 @author Yutaka
 */
//package graph_test;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class GraphFrame extends JFrame {
    public GraphFrame() {
        this.setResizable(false);        
        //Creating new Panel.
        final GraphPanel  gpanel = new GraphPanel();
        add(gpanel);
        pack();     
         //Creating MenuBar.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        //Adding "Open" item
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
                chooser.setFileFilter(new FileNameExtensionFilter("Graph Files","grphh"));
             }
        });
        //Addin "Close Item"
        JMenuItem saveItem = new JMenuItem("Save");
        menu.add(saveItem);
    }
}