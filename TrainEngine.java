import java.awt.geom.*;
import java.awt.*;

/**
 * Train Engine is a vehicle that can pull a chain of railcars
 */
public class TrainEngine extends Vehicle 
{
	/**
	 * Constants
	 */
	private static final double WIDTH = 35;
	private static final double UNIT = WIDTH / 5;
	private static final double U_3 = 0.3 * UNIT;
	private static final double U2_5 = 2.5 * UNIT;
	private static final double U2 = 2 * UNIT;
	private static final double U3 = 3 * UNIT;
	private static final double U4 = 4 * UNIT;
	private static final double U9 = 9 * UNIT;
	private static final double U10_7 = 10.7 * UNIT;
	private static final double U12 = 12 * UNIT;
	private static final double U13 = 13 * UNIT;

	public TrainEngine(int x, int y) 
	{
		super();
		xPos = x;
		yPos = y;
	}

	public void draw(Graphics2D g2) 
	{
		super.draw(g2);
		int x = xPos;
		int y = yPos;

		Rectangle2D.Double hood = new Rectangle2D.Double(x + 3, y + UNIT,
				U2 + 4, U3);
		g2.setColor(Color.BLACK);
		g2.fill(hood);
		Rectangle2D.Double body = new Rectangle2D.Double(x + U3, y, U9, U4);
		g2.setColor(Color.BLACK);
		g2.fill(body);
		Line2D.Double hitch = new Line2D.Double(x + U12, y + U2_5, x + U13, y
				+ U2_5);
		g2.setColor(Color.BLACK);
		g2.draw(hitch);
		if (isSelected)g2.setColor(Color.RED);
		Ellipse2D.Double wheel1 = new Ellipse2D.Double(x + U_3 + 3.5, y + U4,
				UNIT, UNIT);
		g2.fill(wheel1);
		Ellipse2D.Double wheel2 = new Ellipse2D.Double(x + U_3 + 9, y + U4,
				UNIT, UNIT);
		g2.fill(wheel2);
		Ellipse2D.Double wheel3 = new Ellipse2D.Double(x + U_3 + 15, y + 4
				* UNIT, UNIT, UNIT);
		g2.fill(wheel3);
		Ellipse2D.Double wheel4 = new Ellipse2D.Double(x + U10_7 - U_3 - 3.5, y
				+ U4, UNIT, UNIT);
		g2.fill(wheel4);
		Ellipse2D.Double wheel5 = new Ellipse2D.Double(x + U12 - U_3 - 5.5, y
				+ U4, UNIT, UNIT);
		g2.fill(wheel5);
		Ellipse2D.Double wheel6 = new Ellipse2D.Double(x + 9.7 * UNIT - U_3
				- 3.5, y + U4, UNIT, UNIT);
		g2.fill(wheel6);

		if (nextVehicle != null) nextVehicle.draw(g2);							//Draws the engine if there is no vehicle on the panel(aka NULL)
	}
}
