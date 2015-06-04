package FinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel{
	Ball1 ball1=new Ball1(this);
	Ball2 ball2=new Ball2(this);
	ObstacleSet obstacleset=new ObstacleSet(this);
	static int points=0;
	static int pointDisplay=0;
	boolean Life1=true;
	boolean Life2=true;
	static int count=0;
	static long startTime;
	public Game()
	{
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e)
			{

			}
			public void keyReleased(KeyEvent e)
			{
				ball1.keyReleased(e);
				ball2.keyReleased(e);
			}
			public void keyPressed(KeyEvent e)
			{
				ball1.keyPressed(e);
				ball2.keyPressed(e);
			}
		});
		setFocusable(true);
	}


	public boolean isDead()
	{
		if(ball1.gety()>770&&ball2.gety()>770)
			return true;
		return false;
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Your score is "+pointDisplay);
		System.exit(ABORT);
	}

	public void createNewObstacle()
	{
		obstacleset.createNewObstacle();
	}
	
	public boolean isNotStuck()
	{
		if(ball1.isStuck()&&ball2.isStuck())
			return false;
		return true;
	}
	
	public void checkLives()
	{
		if(ball1.gety()>400)
			Life1=false;
		if(ball2.gety()>400)
			Life2=false;
	}
	
	public void intersect()
	{
		ball1.intersect(obstacleset);
		ball2.intersect(obstacleset);
	}
	
	public void move()
	{
		ball1.move(Life2);
		ball2.move(Life1);
		obstacleset.move();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g.fillRect(0, getHeight()-20, getWidth(), 20);
		g.fillRect(getWidth()-20, 0, 20, getHeight());
		g.fillRect(0, 0, getWidth(), 20);
		g.fillRect(0, 0, 20, getHeight());
		ball1.paint(g2d,Life2);
		ball2.paint(g2d,Life1);
		obstacleset.paint(g2d);
		g2d.setColor(Color.ORANGE);
		g2d.setFont(new Font("Verdana", Font.BOLD,30));
		g2d.drawString(String.valueOf(pointDisplay), 30, 50);
	}

	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame=new JFrame("Sticky Balls");
		frame.setBackground(Color.BLACK);
		Game game=new Game();
		frame.add(game);
		frame.setSize(400, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startTime=System.currentTimeMillis();

		while(true)
		{
			if(game.isDead())
			{
				game.gameOver();
			}
			if(points%60==0)
			{
				game.createNewObstacle();
				if(game.isNotStuck()&&count>3 )
					pointDisplay++;
				count++;
			}
			game.checkLives();
			game.intersect();
			game.move();
			game.repaint();
			Thread.sleep(10);
			points++;
		}
	}
}
