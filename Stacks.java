import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Stacks extends Vehicle 
{

	public static final int width = 20;
	public static final int height = 20;
	public static final int x1 = 69;
	public static final int widthForTable = 100;
	public static final int heightForTable = 20;

	public Stacks() 
	{
		super();
	}

	public Stacks(int x, int y) 
	{
		super(x, y);
	}
	
	public void draw(Graphics2D g2) 
	{
		int x = getX();
		int y = getY();

		Rectangle2D box = new Rectangle(x + x1, y - 85, width, height);
		Rectangle box1 = new Rectangle(x + x1, y - 62, width, height);
		Rectangle box2 = new Rectangle(x + x1, y - 38, width, height);
		Rectangle box3 = new Rectangle(x + x1, y - 15, width, height);
		Rectangle box4 = new Rectangle(x + x1, y + 8, width, height);

		// The table for the stacks

		Rectangle table = new Rectangle(x + 30, y + 30, widthForTable,
				heightForTable);

		g2.setColor(Color.BLACK);
		g2.drawString("A", getX() + 75, getY() - 70);

		g2.setColor(Color.GREEN);
		g2.draw(box);

		g2.setColor(Color.BLACK);
		g2.drawString("B", getX() + 75, getY() - 45);

		g2.setColor(Color.GREEN);
		g2.draw(box1);

		g2.setColor(Color.BLACK);
		g2.drawString("C", getX() + 75, getY() - 23);

		g2.setColor(Color.GREEN);
		g2.draw(box2);

		g2.setColor(Color.BLACK);
		g2.drawString("D", getX() + 75, getY());

		g2.setColor(Color.GREEN);

		g2.draw(box3);

		g2.setColor(Color.BLACK);

		g2.drawString("E", getX() + 75, getY() + 24);

		g2.setColor(Color.GREEN);

		g2.draw(box4);
		g2.setColor(Color.BLACK);

		g2.draw(table);
		g2.fill(table);
	}
}
