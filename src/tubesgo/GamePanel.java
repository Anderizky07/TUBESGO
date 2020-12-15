/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;

/*
 * GamePanel.java
 * 
 */

//imports classes from swing package
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;

//imports classes from awt packages
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GamePanel extends JPanel implements ActionListener {

	//declarations
        
        
	// declare a player object
	Player1 playerOne = new Player1();
        Player2 playerTwo = new Player2();
	// declares a ball object
	Bola ball = new Bola();
        
        private BufferedImage bg;
        
	//declare a score object
	Skor score = new Skor(ball, playerOne, playerTwo);
	//timer
	private Timer timer;
	//declare boolean
	boolean gameOn = false;
	// declare new circle
	WarnaBola circle = new WarnaBola (Pong.WINDOW_WIDTH/2-25, ((Pong.WINDOW_HEIGHT+30)/2)-25, 25, Color.green);
	//creates a new Font
	Font font = new Font ("Yu Gothic", Font.BOLD, 14);
        
        Pong pong;
        
	
	// constructor
	public GamePanel(Pong pong) {
                level();
               
                this.pong = pong; //buat close pong
		// adds a new listener
		KeyBoardAdapter keyboard =new KeyBoardAdapter ();
		addKeyListener(keyboard);
		
		// sets the KeyBoard Focusable
		setFocusable(true);
                try {
			bg = ImageIO.read(getClass().getResource("/img/lapangan.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
                

		
	}
	
	public Bola getBall(){
		return ball;
	}
	
	public void level(){
		if(!gameOn){
			score.p2Score = 0; //sets score = 0
			score.p1Score = 0; //sets score = 0
			gameOn = true;
			int pause = new Integer(50);
			System.out.println(pause);
			timer = new Timer(pause, this); // declares a timer and sets the
			// parameters to how long before it
			// updates
                        
			timer.start();//runs the timer
		}
	}
	
	


	//updates the game
	private void update() {
		
		if (gameOn){
		playerOne.update(); //runs update method
		ball.update();//runs update method
		playerTwo.update();//runs update method
		score.update();//runs update method
		
		ball.checkCollision(playerOne);//runs checkCollision method
		ball.checkCollision(playerTwo);//runs checkCollision method
		
		}
		
		checkStatus();
	}

	// paints
        @Override
	public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Graphics2D graphics2d = (Graphics2D) pen;
        graphics2d.drawImage(bg, 0, 0, null);
		if (gameOn){
                    playerOne.paint(pen);
                    ball.paint(pen);
                    playerTwo.paint(pen);
                    background(pen);
                    drawScore(pen);
		}		
		else{
                        this.setVisible(false);
			gameOver();
		}
	}
	
	public void drawScore(Graphics pen){
            
            
	String p2Score = Username.Namapemain2+" Score : " + score.playerTwoScore(); //declares and initializes string as Score
	String p1Score = Username.Namapemain1+" Score: " + score.playerOneScore();
		
        pen.setColor(Color.green); //sets the color of the pen to white
        pen.setFont(font); //set the size of the font to small
        pen.drawString(p2Score,Pong.WINDOW_WIDTH-Pong.WINDOW_WIDTH/3, Pong.WINDOW_HEIGHT+12);//draws the string
        pen.drawString(p1Score, Pong.WINDOW_WIDTH/10, Pong.WINDOW_HEIGHT+12);
	}
 
	public void background(Graphics pen){
                
                
		pen.setColor(Color.green); //sets pen color to white
		pen.drawLine(0, 30, Pong.WINDOW_WIDTH, 30); //draws a horizontal line 30 units down
		pen.drawLine(0, Pong.WINDOW_HEIGHT, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);//bottome line
		pen.drawLine(Pong.WINDOW_WIDTH/2, 30, Pong.WINDOW_WIDTH/2, Pong.WINDOW_HEIGHT);//draws a vertical line down middle 
		circle.drawUnFilled(pen);//draws a circle half way down the vertical line
		pen.drawLine(26, 30, 26, Pong.WINDOW_HEIGHT);//line behind player
		pen.drawLine(482, 30, playerTwo.getX()+playerTwo.getWidth()+10, Pong.WINDOW_HEIGHT);//line behind computer
	}
	
	public void checkStatus(){
		if (score.playerTwoScore() == 10 || score.playerOneScore() == 10 ){
			gameOn = false;
			timer.stop();
		}
	}
	
	//checks to see when game is over
	public void gameOver(){
		if (score.playerTwoScore() == 10){
                        pong.setVisible(false);
			Gameover go = new Gameover (score);
                        
                        Music.clip.stop();
                        go.setVisible(true);
                        
		}
		else if (score.playerOneScore() == 3){
                        pong.setVisible(false);
			//game is over, you win
			Gameover go = new Gameover (score);
                        Music.clip.stop();
                        
                        go.setVisible(true);
		}
	}
	

	
	// methods from ActionListener
        @Override
	public void actionPerformed(ActionEvent e) {
		update(); // calls the update method
		repaint(); // calls paint component again		
	}
	
	
	private class KeyBoardAdapter implements KeyListener {
		// methods from KeyListener
                @Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				playerTwo.setYSpeed(-10);
                                
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				playerTwo.setYSpeed(10);
                                
			}
                        else if (e.getKeyCode() == KeyEvent.VK_W) {
				playerOne.setYSpeed(-10);
			} else if (e.getKeyCode() == KeyEvent.VK_S){
                                playerOne.setYSpeed(10);
			}
		}
                
		
                @Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP ) {
				playerTwo.setYSpeed(0);
                                
			}else if ( e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_S ){
                            playerOne.setYSpeed(0);
                        }
		}
		
                @Override
		public void keyTyped(KeyEvent e) {
		}
	}//end of KeyBoardAdapter class
		
}// end of class
