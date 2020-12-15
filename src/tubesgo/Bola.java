/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;

public class Bola {
	
	Random r = new Random();
	
	//declare and initialize integer variables
	private int x = r.nextInt(Pong.WINDOW_WIDTH/2);  /*Pong.WINDOW_WIDTH/2*/;
	private int y = Pong.WINDOW_HEIGHT/2;
	private int speed = 8;
	
	private int radius = 6;
	
	private int xSpeed = -speed;
	private int ySpeed = speed;
	BufferedImage image;
        public Bola (){
         try {
             image = ImageIO.read(getClass().getResource("/img/bola.png"));

        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
       }
	//updates the location of the ball
	public void update()
	{
		x = x + xSpeed; //sets x equal to x value + xSpeed value
		y = y + ySpeed; //sets y equal to y value + ySpeed value
		
		if (x < 0){ //checks to see if x is less than 0
			xSpeed = speed;
		}
		else if (x + 2*radius > Pong.WINDOW_WIDTH - 7){ //checks to see if x + 2*radius is greater than 600
			xSpeed = -speed;
		}
		
		if (y < 33){ //checks to see if y is less than 33
			ySpeed = speed;
		}
		if (y + 2*radius > Pong.WINDOW_HEIGHT-radius ){//checks to see if y + 2*radius is greater than 600
			ySpeed = -speed;
		}
		
		reset();
	}
	
	public void paint (Graphics pen)
	{
            Graphics2D graphics2d = (Graphics2D) pen;
            graphics2d.drawImage(image, x, y, null);

	}
	
	public void reverseDirection(){
		xSpeed = -xSpeed;
	}
	
	public void checkCollision(Player1 p1)
	{
		if ( this.x > p1.getX() && this.x < p1.getX()+p1.getWidth() )  //if ball is in x range of player's width
		{
			if  ( this.y > p1.getY()-5  && this.y < p1.getY()+p1.getHeight()+5 )
			{
				reverseDirection();
			}
		}
	}
	
	public void checkCollision(Player2 p2)
	{
		if ( this.x + radius > p2.getX()+1 && this.x < p2.getX()+p2.getWidth()+1 )  //if ball is in x range of player's width
		{
			if  ( this.y > p2.getY()-p2.getWidth()  && this.y < p2.getY()+p2.getHeight()-1 )
			{
				reverseDirection();
			}
		}
	}
	
	public void reset(){
	if (this.x <= 25 || this.x >= 483){
		x = Pong.WINDOW_WIDTH/2;
		y = Pong.WINDOW_HEIGHT/2;
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
