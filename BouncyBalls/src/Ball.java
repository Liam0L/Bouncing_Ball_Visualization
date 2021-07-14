import java.awt.*;



public class Ball {

	//Initialize Variables	
	 private int height, width, ballX, ballY;
	 private Color color;
	 private int ballSpeedX = 1;
	 private int ballSpeedY = 1;
	 
	 //Ball Constructor
	 public Ball(Color color, int height, int width, int ballX, int ballY)
	 {
		 this.height = height;
		 this.width = width;
		 this.color = color;
		 this.ballX = ballX;
		 this.ballY = ballY;
	 }
	 
	 //Add getter and setter methods
	 public Color getColor()
	 {
		 return this.color;	
	 }
	
	 public int getHeight()
	 {
		 return this.height;
	 }
	 
	 public int getWidth()
	 {
		 return this.width;
	 }
	 
	 public int getBallX()
	 {
	     return this.ballX;
	 }
	  
	 public int getBallY()
	 {
	     return this.ballY;
	 }
	 
	 
	 public void setBallX(int x)
	 {
	     this.ballX = x;
	 }
	 
	 public void setBallY(int y)
	 {
	     this.ballY = y;
	 }
	 //ballMove Method
	 public void ballMove(int frameHeight, int frameWidth, int radius)
	 {
		 //Set X and Y axis to + 1 to move forward
		 this.setBallX(this.getBallX() + ballSpeedX);
		 this.setBallY(this.getBallY() + ballSpeedY);
		 
		 //Conditions for wall collisions
		 if(this.getBallX() < 0)
		 {
			 //switch directions
			 ballSpeedX = -ballSpeedX;
		 }
		 
		 if(this.getBallX() + radius >= frameWidth)
		 {
			 ballSpeedX = -ballSpeedX;
		 }
		 
		 if(this.getBallY() < 0)
		 {
			 ballSpeedY = -ballSpeedY;
		 }
		 
		 if(this.getBallY() + radius >= frameHeight)
		 {
			 ballSpeedY = -ballSpeedY;
		 }
	 }
	 
}
