/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;



public class Skor {
	
	//declare and initialize scores scores
	int p2Score = 0, p1Score = 0;
	
	// declare a player object
	Player1 playerOne;
        Player2 playerTwo;
	// declares a ball object
	Bola ball;
        
        public Skor()
        {};

    public Skor(Bola ball, Player1 playerOne, Player2 playerTwo) {
               this.ball = ball;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
    }
	

	public void update(){
		this.p2Score();
		this.p1Score();

	}
	
	public void p2Score(){
		if (ball.getX() == playerTwo.getX()+playerTwo.getWidth()+5){
				p1Score = p1Score+1; //updates score when condition is met
				System.out.println("Player 1 Score: " + p1Score); //prints player score
		}
	}
	
	public void p1Score(){
		if (ball.getX() <= 30){
				p2Score = p2Score+1; //updates score when condition is met
				System.out.println("Player 2 Score: " + p2Score); //prints player score
		}
		
	}
	
	public int playerTwoScore(){
		return p2Score; //returns the computer score
	}
	
	public int playerOneScore(){
		return p1Score; //returns player score
	}
	
	
}//end
