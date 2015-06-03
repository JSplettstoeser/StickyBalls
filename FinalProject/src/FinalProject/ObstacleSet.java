package FinalProject;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class ObstacleSet {
	Game game;
	ArrayList<Obstacle> obstacles=new ArrayList<Obstacle>();
	public ObstacleSet(Game game)
	{
		this.game=game;
	}
	public void move()
	{
		for(Obstacle o: obstacles)
		{
			o.move();
		}
	}
	public void paint(Graphics2D g)
	{
		for(Obstacle o: obstacles)
		{
			o.paint(g);
		}
	}
	public ArrayList<Obstacle> getList()
	{
		return obstacles;
	}
	public void createNewObstacle()
	{
		int num=(int)(Math.random()*2);
		int width;
		int x;
		if(num>0){
		 x=(int)(Math.random()*400);
		 width=(int)(Math.random()*150);
		obstacles.add(new Obstacle(x,width));
		}
		else
		{
			 width=(int)(Math.random()*100);
			 int midWidth =40+(int)(Math.random()*25);
			 obstacles.add(new Obstacle(0,width));
			 obstacles.add(new Obstacle(200-midWidth/2,midWidth));
			 obstacles.add(new Obstacle(400-width,width));
			
		}
	}

}
