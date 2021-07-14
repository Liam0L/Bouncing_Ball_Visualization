import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;





public class MultiBall extends JFrame implements Runnable 
{
	
	private static final long serialVersionUID = 1L;
	java.util.List<Ball> balls;
	Random rand = new Random();
	
	public static void main(String [] args)
	{
			MultiBall main = new MultiBall();
			main.setVisible(true);
			main.run();
	}

	//Multi Ball Constructor	
	public MultiBall()
	{
			int frameHeight = 900;
			int frameWidth = 900;
			setTitle("Bouncy Balls");
			setSize(frameHeight, frameWidth);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
		
		//Override Run()	
		public void run() {
			//Initialize local variables
			int radius = 50;
			int frameHeight = 900;
			int frameWidth = 900;
			
			//Create Scanner Object
			Scanner input = new Scanner(System.in);
			//Prompt user for number of balls
			System.out.println("Enter Number of Balls: ");
			int num = input.nextInt();
		    
			//Create Ball Array
			balls = new ArrayList<>();
			
			//Iterate through Ball Array
			for(int i = 0; i < num; i++) {
				//Create Thread for each ball
				Thread thread = new Thread();
				//Create balls with random values for color and x/y coordinates
		    	Ball ball = new Ball(new Color(
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256))
                ), radius, radius, (int) Math.floor(Math.random() * frameHeight),
	                    (int) Math.floor(Math.random() * frameWidth));
		    	
		    	//add each ball to array
		    	balls.add(ball);
		    	//Start Thread
		    	thread.start();
		    }
		    //Start infinite loop
			while(true) {
				//Iterate through ball array
				for(Ball b: balls) {
				//call ballMove method	
				b.ballMove(frameHeight,frameWidth,radius);
				
				}
				//Try/Catch Block
				try {
					Thread.sleep(00000000000000000001);
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				//Repaint
				repaint();
			}
			}	
			
			//Paint Method
			public void paint(Graphics g)
			{
				super.paint(g);
				for(Ball b: balls) {
				g.setColor(b.getColor());	
				g.fillOval(b.getBallX(),b.getBallY(),b.getWidth(), b.getHeight());
				}
			}
		}


