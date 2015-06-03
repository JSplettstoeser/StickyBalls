package FinalProject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Obstacle {
	int x;
	int y=0;
	int yChange=3;
	int width;
	public Obstacle(int x, int width)
	{
		this.x=x;
		this.width=width;
	}
	public void move(){
		y+=yChange;
	}
	public void paint(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, 3);
	}
	public int getWidth()
	{
		return width;
	}
	public int getLeft()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
}
