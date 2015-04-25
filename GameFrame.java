import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/** 
 * @author Harsh Patel
 * April 3rd, 2015
 * GameFrame.java
 * The Class GameFrame where the Frame is edited by Adding a Menu
 */

public class GameFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int FRAME_HEIGHT = 600;							//The constant height for the initial frame height
	public static final int FRAME_WIDTH = 700;							//The constant width for the initial frame width
	
	private GamePanel panel;											//Declared a panel

	/**
	 * This method creates the Menu Bar
	 * This method adds the File Menus in the Menu Bar
	 * This method sets the size of the frame using HEIGHT and WIDTH initialized above
	 */
	public GameFrame()
	{
		panel = new GamePanel();										//Creates a panel using GUI from GamePanel class
		this.add(panel);												//Adds the panel to the frame
		panel.setBackground(Color.CYAN);
		
		JMenuBar menuBar = new JMenuBar();								//Creates a MenuBar
		setJMenuBar(menuBar);											//Sets the MenuBar in the frame
		
		menuBar.add(createFileMenu());									//Adds the 'File' option in the MenuBar
		menuBar.add(createStackMenu());									//Adds the 'Stack' option in the MenuBar
		menuBar.add(createListMenu());									//Adds the 'List' option in the Menu Bar
	}
	
	/**
	 * This method creates the Menu in the Menu Bar for 'File' (JMenu)
	 * This method creates the MenuItems and adds them to the Menu for 'File' (JMenuItem)
	 * @return The 'File' menu with MenuItems
	 */
	public JMenu createFileMenu()
	{
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem exitOption = new JMenuItem("Exit");
		fileMenu.add(exitOption);
		ActionListener exitListener = new ExitOptionListener();
		exitOption.addActionListener(exitListener);
		
		JMenuItem newOption = new JMenuItem("New");
		fileMenu.add(newOption);
		ActionListener newListener = new NewOptionListener();
		newOption.addActionListener(newListener);
		
		return fileMenu;
	}
	
	/**
	 * This method creates the Menu in the Menu Bar for 'List' (JMenu)
	 * This method creates the MenuItems and adds them to the Menu for 'List' (JMenuItem)
	 * @return The List menu with MenuItems
	 */
	public JMenu createStackMenu()
	{
		JMenu listMenu = new JMenu("Stack");
		
		JMenuItem popOption = new JMenuItem("Pop");
		listMenu.add(popOption);
		
		JMenuItem pushOption = new JMenuItem("Push");
		listMenu.add(pushOption);
		
		return listMenu;
	}
	
	/**
	 * This method creates the Menu in the Menu Bar for 'Stack' (JMenu)
	 * This method creates the MenuItems and adds them to the Menu for 'Stack' (JMenuItem)
	 * @return The Stack menu with the MenuItems
	 */
	public JMenu createListMenu()
	{
		JMenu stackMenu = new JMenu("List");
		
		JMenuItem addFirstOption = new JMenuItem("AddFirst");
		stackMenu.add(addFirstOption);
		ActionListener addFirstListener = new AddFirstListener();
		addFirstOption.addActionListener(addFirstListener);
		
		JMenuItem addLastOption = new JMenuItem("AddLast");
		stackMenu.add(addLastOption);
		ActionListener addLastListener = new AddLastListener();
		addLastOption.addActionListener(addLastListener);
		
		JMenuItem removeFirstOption = new JMenuItem("RemoveFirst");
		stackMenu.add(removeFirstOption);
		ActionListener removeFirstListener = new RemovingFirstListener();
		removeFirstOption.addActionListener(removeFirstListener);
		
		JMenuItem removeLastOption = new JMenuItem("RemoveLast");
		stackMenu.add(removeLastOption); 
		ActionListener removeLastListener = new RemovingLastListener();
		removeLastOption.addActionListener(removeLastListener);
		
		return stackMenu;
	}
	
	/**
	 *This is the listener for the button in 'File' known as 'Exit' so that the game will exit
	 */
	class ExitOptionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}
	
	/**
	 * This is the listener for the button in 'File' known as 'New' so the game will reset
	 */
	class NewOptionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.out.println("New simulation started");
			GamePanel.vehicles.clear();
			repaint();
		}
	}
	
	/**
	 * This is the listener to add the RailCar right after the Engine(in front of any RailCar(s) if present)
	 */
	class AddFirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			panel.addFirst();
		}
	}
	
	/**
	 *This is the listener to add the RailCar to the end of the any RailCar(s) if present
	 */
	class AddLastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			panel.addLast();
		}
	}
	
	/**
	 *This is the listener to remove the RailCar right after the Engine(in front of any RailCar(s) if present)
	 */
	class RemovingFirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			panel.removeFirst();
		}
	}

	/**
	 * This is the listener to remove the RailCar right after the Engine(in front of any RailCar(s) if present)
	 */
	class RemovingLastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			panel.removeLast();
		}
	}
}
