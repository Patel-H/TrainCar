import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/** 
 * @author Harsh Patel
 * April 3rd, 2015
 * Vehicle.java
 * The Class Vehicle where all the method for the Vehicles are created
 * All the method created are used in GamePanel class
 */

public abstract class Vehicle 
{
	int num;																//Declares a variable 'num' of type integer
	Rectangle rectBox;														//Declares a rectangle (basically the bounding box for the RailCars)
	boolean isSelected;														//Declares a boolean to see if the TrainEngine or RailCar is clicked on(if it is selected)
	Vehicle nextVehicle;													//For the LinkedList print the next vehicle in the loops declared in the below code
	int xPos;																//X-Coordinate for the vehicles
	int yPos;																//Y-Coordinate for the vehicles
	int xMouseDiff;															//The difference between the point clicked and the engine is in X-Coordinate
	int yMouseDiff;															//Same as above but for Y-Coordinate
	final int HEIGHT = 35;													//Unchangable value for the Height of the car
	final int WIDTH = 86;													//Width for the car same as above

	/**
	 * Creates the actual bounding box around the Vehicles
	 */
	public Vehicle() 
	{
		rectBox = new Rectangle(xPos, yPos, WIDTH, HEIGHT);
		nextVehicle = null;
	}

	/**
	 * Sets the vehicle to the x and y poistions declared as parameters
	 * @param x position of the vehicles
	 * @param y	position of the vehicles
	 */
	public Vehicle(int x, int y) 
	{
		xPos = x;
		yPos = y;
		rectBox = new Rectangle(xPos, yPos, WIDTH, HEIGHT);
		nextVehicle = null;
	}

	/**
	 * Gets the number on the RailCar
	 * @return the number on the car
	 */
	public int getNumber() 
	{
		return num;
	}
	
	/**
	 * Sets the number on the car as whatever is entered as the parameter
	 * @param n number used in the code to set
	 */
	public void setNumber(int n) 
	{
		num = n;
	}

	/**
	 * Checks if the area is null and prints the next vehicle
	 * @param v of type Vehicle to print the next vehicle
	 */
	public void setNext(Vehicle v) 
	{
		if (nextVehicle != null) nextVehicle.setNext(v);
			nextVehicle = v;
	}

	/**
	 * Sets the position (attaches to the car) dropped on
	 */
	public void setNextPosition() 
	{
		if (nextVehicle != null) nextVehicle.setNextPosition(xPos + WIDTH, yPos);		
	}
	
	/**
	 * Sets the position of the vehicle to the x and y coordinate
	 * @param x coordinate when called
	 * @param y coodrinate when called
	 */
	public void setNextPosition(int x, int y) 
	{
		xPos = x;
		yPos = y;
		if (nextVehicle != null) nextVehicle.setNextPosition(xPos + WIDTH - 10, yPos);
	}

	/**
	 * Checks if the mouse Position matches any of the vehicles
	 * @param x the x position of the mouse event
	 * @param y the y position of the mouse event
	 * @return if the mouse overlaps the vehicle objects
	 */
	public boolean overlaps(int x, int y) 
	{
		if (rectBox.contains(x, y)) return true;
		return false;
	}

	/**
	 * This is for the snapping if the vehicle object intersect each other
	 * @param v for the vehicles 
	 * @return if the snapping should happen or not
	 */
	public boolean overLapper(Vehicle v) 
	{
		if (rectBox.intersects(v.getRect())) return true;
			return false;
	}

	/**
	 * returns the x-coordinate specifically of the vehicle(s)
	 * @return the x
	 */
	public int getX() 
	{
		return xPos;
	}

	/**
	 * returns the y-coordinate specifically of the vehicle(s)
	 * @return the y
	 */
	public int getY() 
	{
		return yPos;
	}

	/**
	 * Set the position of the vehicle
	 * @param x coordinate
	 * @param y coordinate
	 */
	public void setPosition(int x, int y) 
	{
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Set the MouseDifference which is when you click on a vehicle the vehicle doesn't glitch
	 * @param x position
	 * @param y position
	 */
	public void setMouseDiff(int x, int y) 
	{
		xMouseDiff = x;
		yMouseDiff = y;
	}

	/**
	 * MouseDifference location
	 * @return x coordinate for mouseDifference
	 */
	public int getXMouseDiff() 
	{
		return xMouseDiff;
	}

	/**
	 * MouseDifference location
	 * @return y coordinate for mouseDifference
	 */
	public int getYMouseDiff() 
	{
		return yMouseDiff;
	}

	/**
	 * return the bounding box made for the vehicles arraylist
	 * @return rectBox
	 */
	public Rectangle getRect() 
	{
		return rectBox;
	}

	/**
	 * If the overlaps method is selected and activated then this method is true
	 * It checks for every vehicle in the arrayList
	 */
	public void setSelected() 
	{
		isSelected = true;
		setNextSelected();
	}

	/**
	 * Goes through all the vehicles
	 */
	public void setNextSelected() 
	{
		isSelected = true;
		if (nextVehicle != null)
			nextVehicle.setNextSelected();

	}

	/**
	 * Goes through the unselected vehicles and sets them as unselected
	 */
	public void setNextUnselected() 
	{
		if (nextVehicle != null)
			nextVehicle.setNextUnselected();

		isSelected = false;
	}

	/**
	 * Goes through all the vehicles to check for the above method
	 */
	public void setUnselected() 
	{
		isSelected = false;
	}

	/**
	 * removes the next vehicle and sets to null
	 */
	public void removeNext() 
	{
		nextVehicle = null;
	}

	/**
	 * Checks if the car is has a next vehicle attached
	 * @return true/false if is attached or not
	 */
	public boolean hasNext() 
	{
		return !(nextVehicle == null);
	}

	/**
	 * Gets the last vehicle in the linkedList
	 * @return
	 */
	public Vehicle getLast() 
	{
		if (nextVehicle == null)
			return this;
		return nextVehicle.getLast();
	}

	/**
	 * Checks if the vehicle is selected or not
	 * @return true/false according to situation selection
	 */
	public boolean isSelected() 
	{
		return isSelected;
	}

	/**
	 * Gets the next vehicle to link (attach)
	 * @return railcar to attach
	 */
	public Vehicle getNext() 
	{
		return nextVehicle;
	}
	
	public void draw(Graphics2D g2) 
	{
		if (isSelected)
			g2.setColor(Color.RED);
		else
			g2.setColor(Color.BLACK);
		rectBox = new Rectangle(xPos + 5, yPos, WIDTH, HEIGHT);
		if (nextVehicle != null) 
		{
			nextVehicle.setPosition(xPos + WIDTH, yPos);
			nextVehicle.draw(g2);
		}
	}

}
