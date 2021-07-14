import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;


public class BallMain extends JFrame implements Runnable{

		//Initialize Variables
		private static final long serialVersionUID = 1L;
		
		private int frameHeight = 900;
		private int frameWidth = 900;
		private int radius = 50;

		//Create Random Object
		Random rand = new Random();
		
		//Create Ball Object
		public Ball ball1 = new Ball(Color.GREEN, radius, radius, rand.nextInt(500), rand.nextInt(500));
		
		//Constructor
		public BallMain()
		{
		setTitle("Bouncy Ball");
		setSize(frameHeight, frameWidth);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
		//Paint Method
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(ball1.getColor());
			g.fillOval(ball1.getBallX(), ball1.getBallY(), ball1.getWidth(), ball1.getHeight());
		}
		//Main Method
		public static void main(String [] args)
		{
			//Create Main Object
	        BallMain main = new BallMain();
	        //Run main
	        main.setVisible(true);
	        main.run();
		}
		//Override run method
		public void run() {
			//Start infinite Loop
			while(true) {
				Thread thread = new Thread();
				//Implement ballMove method
				ball1.ballMove(frameHeight,frameWidth,radius);
				repaint();
				thread.start();
				try {
					Thread.sleep(0000000000000000000000000000000000001);
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
			}
		
		}
				
}
