import java.awt.Color;

import javax.swing.JFrame;
/**
 * @Harsh Patel
 * April 3rd, 2015
 * GameViewer.java
 * This class is where the Frame is created and the settings of the frame is edited here
 */
public class GameViewer
{
   public static void main(String[] args) throws Exception 
   {
		JFrame frame = new GameFrame();								//Creates a frame using GameFrame
		frame.setTitle("Game Frame");								//Sets the name of the frame to 'Game Frame'
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Allows the 'X' button on the top right to be used
		frame.setResizable(false);									//Doesn't allow the frame to change size
		frame.setSize(GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);//Sets the size of the frame
		frame.setLocationRelativeTo(null);							//Centers the frame on the screen
		frame.setVisible(true);										//Sets the frame to be visible
	}
}
