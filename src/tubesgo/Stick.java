/*
 * Rectangle.java
 * 
 * makes rectangles
 * 
 * */


package tubesgo;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

//class header
public class Stick implements warna{
 private int xStart;
 private int yStart;
 private int width2;
 private int height2;
 private Color color2;
 BufferedImage image;
// private Color rectColor;
  
  
  public Stick (int x, int y, int width, int height, Color color)
  {
    xStart = x;
    yStart = y; 
    width2 = width;
    height2 = height;
    color2 = color;
  }

    public Stick(int x, int y, int width, int height, BufferedImage image) {
    xStart = x;
    yStart = y; 
    width2 = width;
    height2 = height;
    this.image = image;
    }


    
    //Draw a filled circle 
 @Override
  public void drawFilled (Graphics g)
  {
    g.setColor (color2);
    g.fillRect (xStart, yStart, width2, height2);
  }
  
 @Override
  public void drawUnFilled (Graphics g)
  {
   g.setColor (color2); 
   g.drawRect (xStart, yStart, width2, height2);
  }
  
  
}//end of the class