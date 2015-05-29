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
	static int points=0;
	static long startTime;
	public Game()
	{
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e)
			{
				
			}
			public void keyReleased(KeyEvent e)
			{
				
			}
			public void keyPressed(KeyEvent e)
			{
				ball1.keyPressed(e);
				ball2.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	public void move()
	{
		ball1.move();
		ball2.move();
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g.fillRect(0, getHeight()-20, getWidth(), 20);
		g.fillRect(getWidth()-20, 0, 20, getHeight());
		g.fillRect(0, 0, getWidth(), 20);
		g.fillRect(0, 0, 20, getHeight());
		ball1.paint(g2d);
		ball2.paint(g2d);
		g2d.setColor(Color.ORANGE);
		g2d.setFont(new Font("Verdana", Font.BOLD,30));
		g2d.drawString(String.valueOf(points/20), 30, 50);
		
	}
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Your score is "+points/20);
		System.exit(ABORT);
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
			game.move();
			game.repaint();
			Thread.sleep(25);
			points++;
		}
	}
}
