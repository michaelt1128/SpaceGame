package worldTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOutput 
{
	public static void main(String[] args)
	{		
		JFrame frame = new JFrame("SPACE GAME");
		frame.setBackground(Color.YELLOW);
		frame.setLayout(new BorderLayout());
		
		JLabel hiText = new JLabel("Welcome to SPACE GAME");
		JLabel infoText = new JLabel("Please play responsibly");
		
		hiText.setFont(new Font("Serif", Font.BOLD, 24));
		infoText.setFont(new Font("Serif", Font.BOLD, 16));
		
		frame.add(hiText, BorderLayout.PAGE_START);
		frame.add(infoText, BorderLayout.CENTER);
		
		frame.setSize(340, 150);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JButton startButton = new JButton("Start New Game");
		startButton.setSize(60, 40);
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				WorldGen universe = new WorldGen(10, 10);
				frame.dispose();
				universe.setTile(2, 2);
			}
		});
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.setVisible(true);
		

		//universe.setTile(3, 3);
	}
}
