package worldTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOutput 
{
	private static Icon mars = new ImageIcon(WorldGen.class.getResource("/images/Kappa.jpg"));
	public static void main(String[] args)
	{				
		Icon[] spc_icons = createSpc();
    	Worlds world = new Worlds();
    	WorldGen w = new WorldGen(10, 10, spc_icons);
    	world.worldGenSet(w);    	
    	welcomeText(w);
    	w.setTile(4, 2, mars);
    	w.setTile(4, 3, mars);
    	try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
        w.resetTile(4, 3, spc_icons);
        try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
        w.resetTile(4, 2, spc_icons);
	}
	
	public static void welcomeText(WorldGen x)
	{
		JFrame frame = new JFrame("SPACE GAME");
		frame.setBackground(Color.YELLOW);
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
			}
		});
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.add(hiText, BorderLayout.PAGE_START);
		frame.add(infoText, BorderLayout.CENTER);		
		frame.setSize(340, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static Icon[] createSpc()
	{
		Icon spc_0 = null;
    	Icon spc_1 = null;
    	Icon spc_2 = null;
    	Icon spc_3 = null;
    	Icon spc_4 = null;
    	Icon spc_5 = null;
    	Icon spc_6 = null;    	
    	
    	try
    	{   		
    		BufferedImage spc0 = ImageIO.read(WorldGen.class.getResource("/images/space_background0.jpg"));
    		spc_0 = new ImageIcon(spc0);
    		
    		BufferedImage spc1 = ImageIO.read(WorldGen.class.getResource("/images/space_background1.jpg"));
    		spc_1 = new ImageIcon(spc1);
    		
    		BufferedImage spc2 = ImageIO.read(WorldGen.class.getResource("/images/space_background2.jpg"));
    		spc_2 = new ImageIcon(spc2);

    		BufferedImage spc3 = ImageIO.read(WorldGen.class.getResource("/images/space_background3.jpg"));
    		spc_3 = new ImageIcon(spc3);
    		
    		BufferedImage spc4 = ImageIO.read(WorldGen.class.getResource("/images/space_background4.jpg"));
    		spc_4 = new ImageIcon(spc4);
    		
    		BufferedImage spc5 = ImageIO.read(WorldGen.class.getResource("/images/space_background5.jpg"));
    		spc_5 = new ImageIcon(spc5);
    		
    		BufferedImage spc6 = ImageIO.read(WorldGen.class.getResource("/images/space_background6.jpg"));
    		spc_6 = new ImageIcon(spc6);  
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    	Icon[] spcIcons = new Icon[7];
    	spcIcons[0] = spc_0;
    	spcIcons[1] = spc_1;
    	spcIcons[2] = spc_2;
    	spcIcons[3] = spc_3;
    	spcIcons[4] = spc_4;
    	spcIcons[5] = spc_5;
    	spcIcons[6] = spc_6;
    	
    	return spcIcons;
	}
}











