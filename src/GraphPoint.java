/*
Class Graph_Point contains information about vertix in graph
 */

//package graph_test;

import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author Yutaka
 */
public class GraphPoint {
    //radius of point and color.
    private static final int SIDELENGTH = 20;
    private Ellipse2D ellipse;
    private    Color color = Color.BLACK;
    
 
    GraphPoint(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();
        ellipse=new Ellipse2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
            SIDELENGTH);
    }
    //set position of point
    public void set(Point2D p)
    {
        double x = p.getX();
        double y = p.getY();
        ellipse.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH,
            SIDELENGTH);
    }
    //set color of point
    public void setColor(Color c)
    {
        color=c;
    }
    //return filed "ellipse"(Graphics2D.Ellipse(...) ).
    public Ellipse2D get()
    {
        return ellipse;
    }
    //return current color of point.
    public Color getColor()
    {
        return color;
    }
    //return position of point.
    public Point2D getPoint()
    {
        double x = ellipse.getCenterX();
        double y = ellipse.getCenterY();
        return new Point2D.Double(x,y);
    }
    //return true if point contains (Point2D p)
    public boolean contains(Point2D p)
    {
        return ellipse.contains(p);
    }
}
