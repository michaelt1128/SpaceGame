package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameDriver 
{	
	public ArrayList<Integer> tempP = new ArrayList<Integer>();
	public ArrayList<Integer> tempE = new ArrayList<Integer>();
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
					setUpGame();
					frame.dispose();
					SpaceBattle b1 = new SpaceBattle();
					b1.startBattle(tempP, tempE);
				}
				}); 
		frame.add(startButton, BorderLayout.AFTER_LAST_LINE);
		frame.setVisible(true);
	}
	
	public void setUpGame()
	{
		PlayerShip pShip = new PlayerShip();
		EnemyShip eShip = new EnemyShip();
		tempP.add(0,100);
		tempP.add(1,65);
		tempP.add(2,45);
		tempP.add(3,55);
		tempP.add(4,98);
		tempE.add(0,35);
		tempE.add(1,65);
		tempE.add(2,45);
		tempE.add(3,20);
		tempE.add(4,100);
		pShip.setShipStats(tempP);
		eShip.setShipStats(tempE);
	}
	public static void main(String[] args)
	{
		new GameDriver();
		
		
		
	}
}
