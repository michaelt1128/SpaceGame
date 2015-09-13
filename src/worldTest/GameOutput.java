package worldTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOutput 
{
	private static Icon mars = new ImageIcon(WorldGen.class.getResource("/images/mars.png"));
	private static Icon sun = new ImageIcon(WorldGen.class.getResource("/images/sun.png"));
	private static Icon uranus = new ImageIcon(WorldGen.class.getResource("/images/uranus.png"));
	private static Icon marsBase0 = new ImageIcon(WorldGen.class.getResource("/images/marsBase0.png"));

	public static void main(String[] args)
	{				
		CreateIcons iconCreator = new CreateIcons();
		Icon[] spc_icons = iconCreator.createSpc();
		Icon[] mars_Icons = iconCreator.createMars();
		Icon[] uranus_Icons = iconCreator.createUranus();
		
    	WorldGen w = new WorldGen(10, 10, spc_icons);
    	w.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	w.frame.setLocation(dim.width/2-w.frame.getSize().width/2, 0);
    	

    	GameUpdates gameUpdate = new GameUpdates();   	
    	gameUpdate.frame.setLocation(w.frame.getX(), w.frame.getY()+w.frame.getHeight());
    	welcomeText(w, gameUpdate);
    	
    	w.setTile(4, 2, mars);
    	w.grid[4][2].setToolTipText("Mars");
    	w.grid[4][2].addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e1)
    		{
    			WorldGen mars = new WorldGen(10,10, mars_Icons);
    			mars.frame.setVisible(true);
    			mars.frame.setTitle("Mars");
    			mars.setTile(4, 4, marsBase0);
    			mars.frame.setLocation(w.frame.getX()+ w.frame.getWidth(), w.frame.getY());
    		}
    	}
    	);
    	
    	w.setTile(6, 3, uranus);
    	w.grid[6][3].setToolTipText("Uranus");
    	w.grid[6][3].addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e2)
    		{
    			WorldGen uranus = new WorldGen(10,10, uranus_Icons);
    			uranus.frame.setVisible(true);
    			uranus.frame.setTitle("Uranus");
    			uranus.frame.setLocation(w.frame.getX()+ w.frame.getWidth(), w.frame.getY());
    		}
    	}
    	);
    	w.setTile(8, 8, sun);
    	w.grid[8][8].setToolTipText("Sun");
	}
	
	public static void welcomeText(WorldGen x, GameUpdates y)
	{
		JFrame frame = new JFrame("Space Game");
		frame.setLayout(new BorderLayout());
		
		JLabel hiText = new JLabel("Welcome to SPACE GAME");
		JLabel infoText = new JLabel("Please play responsibly");		
		hiText.setFont(new Font("Serif", Font.BOLD, 24));
		infoText.setFont(new Font("Serif", Font.BOLD, 16));
				
		JButton startButton = new JButton("Start New Game");
		startButton.setSize(60, 40);
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				x.frame.setVisible(true);				
				frame.dispose();
				y.frame.setVisible(true);
			}
		});
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.add(hiText, BorderLayout.PAGE_START);
		frame.add(infoText, BorderLayout.CENTER);		
		frame.setSize(340, 150);
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		frame.setVisible(true);
	}	
}











