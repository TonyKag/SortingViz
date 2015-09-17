/*
    Class GraphPanel is used for work with graph and visualization
    @author Yutaka
 */

//package graph_test;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class GraphPanel extends JPanel{
   //set size of panel and font of text "current layer:..."
/*   private static final int DEFAULT_WIDTH = 800;
   private static final int DEFAULT_HEIGHT = 600;
*/  
   private static final Font f=new Font("Serif", Font.BOLD, 24);
   
   //layers list and number of the current layer;
   private int current_layer = 1;
   
  //list of graph's points and graph's edges;
   private ArrayList<GraphPoint> points;
   private GraphPoint current;
   public GraphPanel() {    
   current = null;
 
      addMouseListener(new MouseHandler());
 
      InputMap imap = this.getInputMap(JComponent.WHEN_FOCUSED);
      imap.put(KeyStroke.getKeyStroke("ctrl Q"),"upLayer");
      imap.put(KeyStroke.getKeyStroke("ctrl A"),"downLayer");
  }
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      // draw all squares
      for (GraphPoint r : points) {
        g2.setPaint(r.getColor());
        g2.fill(r.get());
       }
      
      g2.setPaint(Color.BLACK);
      g2.setFont(f);
      g2.drawString("Current layer: "+current_layer,this.getWidth()-200,this.getHeight()-10);
   }
   
   //find point, that contains (Point2D p)
   public GraphPoint find(Point2D p) {
      for (GraphPoint r : points) {
         if (r.contains(p)) return r;
      }
      return null;
   }
   
   //add point with position (Point2D p)
   public void add(Point2D p) {
      current = new GraphPoint(p);
      points.add(current);
      repaint();
   }
   
   //remove point "s" from ArrayList "points" and all edges with this point.
   public void remove(GraphPoint s) {
      if (s == null) return;
      if (s == current) {
        current = null;
        points.remove(s);
      }
      repaint();
   }
   
    private class MouseHandler extends MouseAdapter {
      public void mousePressed(MouseEvent event) {
         // add a new pint if the cursor isn't inside a point
         current = find(event.getPoint());
         if (current == null && event.getButton()==MouseEvent.BUTTON1) add(event.getPoint());
      }

    private class MouseMotionHandler implements MouseMotionListener {
       //set new view to cursor
      public void mouseMoved(MouseEvent event) {
         if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
         else setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }
      //replace point
      public void mouseDragged(MouseEvent event) {
         if (current != null) {    
            current.set(event.getPoint());
            repaint();
         }
      }
   }
      
   //save to file   
   public void save(String name) {
          try(FileWriter out=new FileWriter(name)) {
              out.write(Integer.toString(points.size())+"\n");
              for(GraphPoint r : points) {
                out.write(Double.toString(r.getPoint().getX()) + " " + Double.toString(r.getPoint().getY()) + "\n");  
              }
              out.close();
          }
          catch(IOException x) {          
              System.err.format("IOExeption:%s%n",x);
          }
      }
/*    public Dimension getPreferredSize() { 
    	return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); 
    	}*/
   }
}
