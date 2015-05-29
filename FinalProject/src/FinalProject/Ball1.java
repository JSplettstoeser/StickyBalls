package FinalProject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Ball1 {
	private Game game;
	int x=200;
	int xChange=0;
	boolean keyRecentlyPressed=false;
	int timesince=0;
	public Ball1(Game game)
	{
		this.game=game;
	}
	public void move()
	{
		x=x+xChange;
		if(x<200)
			x=200;
		if(x>370)
			x=370;
		
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			xChange=10;
			keyRecentlyPressed=true;
			timesince=5;
		}
	}
	public void keyReleased(KeyEvent e)
	{
		xChange=-10;
	}
	public void paint(Graphics2D g){
		g.setColor(Color.CYAN);
		g.fillOval(x, 400, 10, 10);

	}
	public boolean isAlive()
	{
		return true;
	}
}