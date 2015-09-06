package gameTest;
import java.util.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameDriver 
{	
	public static boolean gameState = true;
	
	public GameDriver()
	{
		JFrame frame = new JFrame("SPACE GAME");
		frame.setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		
		JLabel hiText = new JLabel("Welcome to SPACE GAME");
		JLabel infoText = new JLabel("Please play responsibly");
		frame.add(hiText, BorderLayout.PAGE_START);
		frame.add(infoText, BorderLayout.CENTER);
		
		hiText.setFont(new Font("Serif", Font.BOLD, 24));
		infoText.setFont(new Font("Serif", Font.BOLD, 24));
		
		frame.setSize(350,350);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton startButton = new JButton("Start Game");
		startButton.setSize(60,40);
		startButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					startGame();
					frame.dispose();
				}
				});
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.setVisible(true);
	}
	
	public void startGame()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("*****-------Welcome to SpaceGame-------*****");
		System.out.println("--Type the Number of your Decision--");
		System.out.println("1:Start");
		System.out.println("2:Options");
		System.out.println("3:Quit");
		if(sc.nextInt() == 3)
		{
			gameState = false;
		}
	}
	public static void main(String[] args)
	{
		new GameDriver();
		
		
		
	}
}
