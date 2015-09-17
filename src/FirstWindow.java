/** 
* @author Yutaka
* Program Sorting Algorithms Visualization
* v.1.0.1
*/

import java.awt.EventQueue;
import javax.swing.JFrame;

public class FirstWindow {
	public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	           public void run() {
	               JFrame frame= new GraphFrame();
	               frame.setTitle("Sorting Vizualization");
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	           }
	       });
	   }
}