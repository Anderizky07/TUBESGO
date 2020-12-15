/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;


import java.awt.*;
import java.awt.image.BufferedImage;
// imports awt package

//class header
public class WarnaBola{
  
  //global variables for the circle information
  private int x_Center; // x coordinate of the center
  private int y_Center; // y coordinate of the center
  private int radius; // radius of the circle
  public Color circleColor; // color of the circle
   BufferedImage image;
  
  
  //constructor for a circle
  public WarnaBola(int xCenter, int yCenter, int size, Color color){
    x_Center=xCenter;
    y_Center=yCenter;
    radius=size;
    circleColor=color;
  }
  public WarnaBola(int xCenter, int yCenter, int size, BufferedImage image){
    x_Center=xCenter;
    y_Center=yCenter;
    radius=size;
    this.image=image;
  }
  
  //drawFilled - draws a filled circle
  public void drawFilled(Graphics pen){
    pen.setColor(circleColor);
    pen.fillOval(x_Center, y_Center , radius*2, radius*2);
  } 
  
    public void drawUnFilled(Graphics pen){
    pen.setColor(circleColor);
    pen.drawOval(x_Center, y_Center, radius*2, radius*2);
  } 
}
