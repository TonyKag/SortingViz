import java.awt.EventQueue;

import javax.swing.JFrame;

/** 
* Author Yutaka
* Program Sorting Algorithms Visualization
* v.1.0.1
*/

public class FirstWindow {
	public static void main(String[] args) {
		System.out.println("first window class");
	      EventQueue.invokeLater(new Runnable()
	       {
	           public void run()
	           {
	               JFrame frame= new GraphFrame();
	               frame.setTitle("GraphTest");
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	           }
	       });
	   }
	
}


/*
package graph_test;


import java.awt.*;
import javax.swing.*;

public class Graph_Test {

   //
   // @param args the command line arguments
    //
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               JFrame frame= new GraphFrame();
               frame.setTitle("GraphTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           }
       });
   }
}
*/