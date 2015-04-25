import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.*;

import java.awt.Graphics;

/** 
 * @author Harsh Patel
 * April 3rd, 2015
 * GamePanel.java
 * The Class GamePanel where all the vehicles are printed/edited/modified
 */

public class GamePanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	int num;
    
    static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();					//Creates an arrayList 'vehicles' of type Vehicle
    
    public Vehicle train;															//Declares variable 'train' of type Vehicle
    public Vehicle blocks;															//Declares variable 'blocks' of type Vehicle								
    private Vehicle selector;														//Declares variable 'selected' of type boolean to check if a vehicle is selected or not
    
    private boolean vehicleSelected;												//Variable of boolean to specifically tell which vehicle is selected
    private RailCar railCar1, railCar2, railCar3, railCar4, railCar5;				//Variables for all the Railcars which are type RailCar from RailCar class													

    public GamePanel() 
    {
        vehicleSelected = false;													//Initializes the variable vehicleSelected to false
        train = new TrainEngine(getX(), getY());									//Sets the location of the TrainEngine at mouseEvent 

        /**
         * MouseListener ActionListener to implement your mouse function into the game
         * It has mousePressed, mouseReleased, 
         */
        class MyListener extends MouseAdapter 
        {
        	/**
        	 * creates all the vehicles on the first clicked
        	 * checks for the overlaps/overlapper methods
        	 */
            public void mousePressed(MouseEvent e) 
            {
                int x = e.getX();
                int y = e.getY();

                train.setUnselected();
                for (Vehicle vehicle : vehicles) 
                {
                    vehicle.setUnselected();
                }

                selector = null;

                for (Vehicle vehicle : vehicles) 
                {
                    if (vehicle.overlaps(x, y) && !vehicle.equals(blocks)) 
                    {
                        selector = vehicle;
                        vehicle.setSelected();
                        vehicleSelected = true;
                        vehicle.setMouseDiff(x - vehicle.getX(), y - vehicle.getY());
                        break;
                    }
                }

                if (!vehicleSelected) 
                {
                    if (vehicles.size() < 7)
                    	addVehicles(x, y);
                    selector = null;
                }
                getFirstVehicle();
                repaint();
                System.out.println("Mouse was Pressed");
            }

            /**
             * Checks if the vehicle released if overlapping another vehicle checks if the position is null or not
             * If the vehicle is overlapping another vehicle then attach it to the end of the vehicle overlapping with
             */
            public void mouseReleased(MouseEvent e) 
            {
                if (selector == null)
                    return;

                for (Vehicle vehicle : vehicles) 
                {
                    if (selector == vehicle)
                        continue;
                    if (selector == train)
                        continue;
                    if (selector.overLapper(vehicle) && selector != blocks) 
                    {
                    	if(vehicle.getLast() != blocks) 
                    	{
                        vehicle.getLast().nextVehicle = selector;
                        selector = null;
                        repaint();
                        vehicle.setNextPosition();
                        repaint();
                        break;
                    	}
                    }
                }
                System.out.println("Mouse was released");
                repaint();
                vehicleSelected = false;
            }
        }
        

        /**
         * MouseMotionListener that uses the ActionListener to enable motion mousefunctions
         * moves the vehicles in real time motion using mouseDragged
         */
        class MyMouseListener implements MouseMotionListener 
        {
        	/**
        	 * Does the motion dragging, so when clicking and moving simultaneously
        	 */
            public void mouseDragged(MouseEvent e) 
            {
                repaint();
                if (selector != null) 
                {
                    int x = e.getX();
                    int y = e.getY();
                    selector.setPosition(x, y);
                    selector.setPosition(x - selector.getXMouseDiff(), y
                            - selector.getYMouseDiff());
                    repaint();
                }
                repaint();
            }

            public void mouseMoved(MouseEvent e) 
            {
            }
        }
        
        addMouseListener(new MyListener());
        addMouseMotionListener(new MyMouseListener()); //adding the mouseMotionListener to the panel
    }

    /**
     * paintComponent where all the vehicles are printed from by using a loop
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        if (selector != null)
            selector.draw(g2);
        for (Vehicle v : vehicles) 
        {
            v.draw(g2);
        }
    }
    
    /**
     * resets the vehicle to the mouse when clicked on a option from stacks
     * @param v of type vehicle to see if the clicked if a vehicle
     */
    public void reset(Vehicle v) 
    {
        if (v == null)
            return;
        v.nextVehicle = null;
        vehicles.remove(v);
        v = null;
    }

    /**
     * Uses this method in the mosuePressed to create the actual vehicles
     * @param x coordinate
     * @param y coordinate
     */
    public void addVehicles(int x, int y) 
    {
        if (!vehicles.contains(train)) 
        {
            train = new TrainEngine(x, y);
            vehicles.add(train);
            return;
        }
        if (!vehicles.contains(railCar1)) 
        {
        	railCar1 = new RailCar(x, y);
        	railCar1.setNumber(1);
            vehicles.add(railCar1);
            return;
        }
        if (!vehicles.contains(railCar2)) 
        {
        	railCar2 = new RailCar(x, y);
        	railCar2.setNumber(2);
            vehicles.add(railCar2);
            return;
        }
        if (!vehicles.contains(railCar3)) 
        {
        	railCar3 = new RailCar(x, y);
        	railCar3.setNumber(3);
            vehicles.add(railCar3);
            return;
        }
        if (!vehicles.contains(railCar4)) 
        {
        	railCar4 = new RailCar(x, y);
        	railCar4.setNumber(4);
            vehicles.add(railCar4);
            return;
        }
        if (!vehicles.contains(railCar5)) 
        {
        	railCar5 = new RailCar(x, y);
        	railCar5.setNumber(5);
            vehicles.add(railCar5);
            return;
        }
        if(!vehicles.contains(blocks))
        {
        	blocks = new Stacks(x,y);
        	vehicles.add(blocks);
        }
        return;
    }

    /**
     * Gets the first vehicle in the list
     * Used by addFirst method
     */
    public void getFirstVehicle() 
    {
        if (vehicleSelected) {
            for (int i = 0; i <= 5; i++) 
            {
                for (Vehicle vehicle : vehicles) 
                {
                    if (selector != vehicle) {
                        if (vehicle.nextVehicle == selector) 
                        {
                            selector = vehicle;
                            vehicle.setSelected();
                        }
                    }
                }
            }
        }
        repaint();
        System.out.println(selector + " is selected.\n");
    }
   
    /**
     * Method to add a railcar to front of the list
     */
    public void addFirst() 
    {
        if (selector == null || selector == train)
            return;
        selector.getLast().nextVehicle = train.nextVehicle;
        train.nextVehicle = selector;
        getFirstVehicle();
        train.setNextPosition();
        repaint();
    }

    /**
     * Method to add rail to the end of the list
     */
    public void addLast() 
    {
        if (selector == null || selector == train)
            return;
        if (train.nextVehicle == null) 
        {
            train.nextVehicle = selector;
            repaint();
            return;
        }
        train.nextVehicle.getLast().nextVehicle = selector;
        train.setNextPosition();
        repaint();
    }

    /**
     * Method to remove the first railcar in the list
     * Then you have to click somewhere to paste that removed vehicle
     */
    public void removeFirst() 
    {
        if (train.nextVehicle == null)
            return;
        Vehicle temp = train.nextVehicle;
        train.nextVehicle = train.nextVehicle.nextVehicle;
        reset(temp);
        repaint();
    }

    /**
     * Method to remove the last railcar in the list
     * Then you have to click somewhere to paste that removed vehicle
     */
    public void removeLast() 
    {
        if (train.nextVehicle == null)
            return;

        Vehicle previous = null;
        Vehicle temp = train.nextVehicle;

        if (temp.nextVehicle == null) 
        {
            train.nextVehicle = null;
            reset(temp);
            repaint();
            return;
        }

        while (temp.nextVehicle != null) 
        {
            if (temp.nextVehicle.nextVehicle == null)
                previous  = temp;
            temp = temp.nextVehicle;
        }
        reset(temp);
        previous.nextVehicle = null;
        repaint();
    }
}
