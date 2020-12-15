/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame; //imports to JFrame class from the swing package
import javax.swing.JPanel; //

/*
 * Pong Class 
 */
public class Pong extends JFrame {
	
	final static int WINDOW_WIDTH = 507;
	final static int WINDOW_HEIGHT = 300;
	
		
	public GamePanel gp = new GamePanel(this);
	public Pong () {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
		setSize(WINDOW_WIDTH+7, WINDOW_HEIGHT+53);//sets the size of the frame
		setLocationRelativeTo(null); //sets the frame to center of the screen
		setTitle("Pong"); //sets the title of the frame

		add (gp); //adds a new Panel called GamePanel to the Frame
		
		setResizable(false); //can not change the size
		setVisible(true); //makes the frame visible
		
		gp.setFocusable(true);
             }
	
	/*
	 * main method
	 */
	public static void main(String[] args) {
    
		new Pong ();
	}



}
