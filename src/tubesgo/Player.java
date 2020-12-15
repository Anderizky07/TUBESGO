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
public abstract class Player {
        public int x ;
	public int y ; // y-coordinate
	public int ySpeed ; // how fast you move

	public int width ; // width of rectangle
	public int height ;
        
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
}
