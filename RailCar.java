import java.awt.*;
import java.awt.geom.*;

/**
 * This class describes a vehicle that looks like a flatbed railcar. The railcar
 * should be assigned a unique number displayed on its body. The railcar should
 * have variable and methods to allow it to be linked to another vehicle
 * (consider whether this variable and associated methods should be inherited).
 * This railcar should also have variables and methods so that a storage
 * container can be loaded and unloaded Add other variables and methods you
 * think are necessary.
 */

public class RailCar extends Vehicle 
{
	public static final int UNIT = 10;
	public static final int U6 = 6 * UNIT;
	public static final int U5 = 5 * UNIT;
	public static final int U4 = 4 * UNIT;
	public static final int U3 = 3 * UNIT;
	public static final int U2 = 2 * UNIT;
	public static final int U15 = UNIT + UNIT / 2;
	public static final int U05 = UNIT / 2;
	public static final int BODY_WIDTH = U3;
	public static final int BODY_HEIGHT = U2;
	public int number = 0;

	public RailCar() 
	{
		super();
	}

	public RailCar(int x, int y) 
	{
		super(x, y);
	}

	/**
	 * Draw the rail car
	 * 
	 * @param g2
	 *            the graphics context
	 */
	public void draw(Graphics2D g2)
	{
		super.draw(g2);
		g2.drawString("" + getNumber(),
				xPos + U2 + UNIT + U2 - 9, yPos + U2);

		Rectangle2D.Double body = new Rectangle2D.Double(xPos + U05, yPos
				+ UNIT , U6 + UNIT + U2 - 12, UNIT);
		g2.setColor(Color.BLACK);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(xPos + U2,
				yPos + U2, UNIT, UNIT);
		g2.setColor(Color.BLACK);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(xPos + U4 + U2, yPos
				+ U2, UNIT, UNIT);
		g2.setColor(Color.BLACK);
		// the bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(xPos + UNIT, yPos + UNIT);
		// the front of the roof
		Point2D.Double r2 = new Point2D.Double(xPos + U2, yPos);
		// the rear of the roof
		Point2D.Double r3 = new Point2D.Double(xPos + U4, yPos);
		// the bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(xPos + U5, yPos + UNIT);

		// the right end of the hitch
		Point2D.Double r5 = new Point2D.Double(xPos + U6 + UNIT + U2 - 6, yPos
				+ U15);
		// the left end of the hitch
		Point2D.Double r6 = new Point2D.Double(
				xPos + U6 + U05 + UNIT + U2 - 4, yPos + U15);

		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		Line2D.Double hitch = new Line2D.Double(r5, r6);

		g2.draw(body);
		g2.draw(hitch);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(body);
	}
}
