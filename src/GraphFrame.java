/*
 public Class Graph_Frame
 @author Yutaka
 */
//package graph_test;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


 class GraphFrame extends JFrame 
{
    public GraphFrame()
    {
        this.setResizable(false);        
        //Creating new Panel.
        final GraphPanel  gpanel = new GraphPanel();
        add(gpanel);
        pack();     
        //Set Hello dialog
        JOptionPane.showMessageDialog(this,"Creating Vertex: left-click on free space\n"
                + "Change Layout: CTRL+Q - next layout, CTRL+A - previous\n"
                + "Create or delete Bound: two clicks on different Vertex\n"
                + "Delete Vertex: double click on Vertex","Tutorial",JOptionPane.INFORMATION_MESSAGE);
        //Creating MenuBar.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        //Adding "Open" item
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
                chooser.setFileFilter(new FileNameExtensionFilter("Graph Files","grphh"));
                int result = chooser.showOpenDialog(GraphFrame.this);
 /*               if(result == JFileChooser.APPROVE_OPTION)
                {
                    gpanel.load(chooser.getSelectedFile().getAbsolutePath());
                }*/
            }
        });
        //Addin "Close Item"
        JMenuItem saveItem = new JMenuItem("Save");
        menu.add(saveItem);
        saveItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));       
                chooser.setFileFilter(new FileNameExtensionFilter("Graph Files", "grphh"));
                chooser.setSelectedFile(new File("test.grphh"));
                int result = chooser.showSaveDialog(GraphFrame.this);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    gpanel.save(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }
}
