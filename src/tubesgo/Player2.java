/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;

/**
 *
 * @author ACER-PC
 */
/*
 * Player1.java 
 * 
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class Player2 extends Player {

	// declares and initializes a private integers
	private int x = 462;
	private int y = Pong.WINDOW_HEIGHT/2; // y-coordinate
	private int ySpeed = 0; // how fast you move

	private int width = 10; // width of rectangle
	private int height = 40; // Height of rectangle
        BufferedImage image;
        
	public Player2() {
              try {
            image = ImageIO.read(getClass().getResource("/img/hockey.png"));

        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
	}

	public void paint(Graphics pen) {
	Graphics2D graphics2d = (Graphics2D) pen;
        graphics2d.drawImage(image, x, y, width, height, null);
	}
	// updates the location of the player
	public void update() {
		y = y + ySpeed; //sets y equal to y + ySpeed


		if (y <=30 ) {//stop at 2
			y =31 ; //sets y equal to 31
		}

		if (y + height >= Pong.WINDOW_HEIGHT) {//stop at one above bot line
			y = Pong.WINDOW_HEIGHT - (height +1) ;
		}
	}

	//

	//
	public void setYSpeed(int velocity) {
		ySpeed = velocity;//return value
	}

	public int getX() {
		return x;//return value
	}

	public int getY() {
		return y;//return value
	}
	
	public int getWidth() {
		return width;//return value
	}
	
	public int getHeight(){
		return height;//return value
	}

}// end of class
