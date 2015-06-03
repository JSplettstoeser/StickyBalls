package FinalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Ball2 {
	private Game game;
	int x=200;
	int xChange=0;
	int y=400;
	int yChange=0;
	boolean isHit=false;
	public Ball2(Game game)
	{
		this.game=game;
	}
	public void move(boolean otherBall)
	{
		if(isHit)
			xChange=0;
		if(otherBall)
		{
		x=x+xChange;
		y=y+yChange;
		if(x<20)
			x=20;
		if(x>200)
			x=200;
		}
		else
		{
			x=x+xChange;
			y=y+yChange;
			if(x<20)
				x=20;
			if(x>370)
				x=370;
		}
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			xChange=-10;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		xChange=10;
	}
	public void paint(Graphics2D g, boolean otherBall){
		g.setColor(Color.BLACK);
		if(otherBall)
		{
		if(x==200)
			g.fillOval(x, y, 20, 20);
		else
		g.fillOval(x, y, 10, 10);
		}
		else
			g.fillOval(x, y, 10, 10);
	}
	public void intersect(ObstacleSet set)
	{
		for(Obstacle o: set.getList())
		if(o.gety()<402&&o.gety()>398&&x>o.getLeft()-10&&x<o.getLeft()+o.getWidth())
		{
			yChange=3;
			isHit=true;
		}
	}
	public int gety()
	{
		return y;
	}
}