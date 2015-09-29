package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import worldTest.WorldGen;

public class SpacePort 
{

	public JButton leaveButton = new JButton("Depart Space Port");
	public SpacePort(ArrayList<Integer> pStats)
	{
		JFrame mFrame = new JFrame("Space Port");
		mFrame.setLayout(new BorderLayout());
		mFrame.setSize(800,200);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		
		JButton buyArmor = new JButton("Buy Armor");
		JButton repairShields = new JButton("Repair Ship");
		JButton randomButton = new JButton("???");
		
		JLabel repairsText = new JLabel("This is a test repair text");
		JLabel costRepair = new JLabel("Shield Repairs: 300c");
		JLabel costArmor = new JLabel("Armor Cost: 1000c");
		JPanel costPanel = new JPanel();
		
		JLabel updateShip = new JLabel("<html> Shields: " + pStats.get(1) + "<br> Armor: " + pStats.get(2) + "<br> Credits: " + pStats.get(6) +"</hmtl>");
		
		JPanel cityPanel = new JPanel();
		JLabel cityScene = new JLabel(new ImageIcon(WorldGen.class.getResource("/images/city.jpg")));
		JLabel shipUpgrade = new JLabel(new ImageIcon(WorldGen.class.getResource("/images/shipDock.png")));
		cityScene.setSize(200,300);
		cityPanel.add(cityScene);
		
		costPanel.setLayout(new BorderLayout());
		costPanel.add(costArmor,BorderLayout.SOUTH);
		costPanel.add(costRepair,BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(cityPanel,BorderLayout.NORTH);
		centerPanel.add(repairsText,BorderLayout.SOUTH);
		
		repairShields.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int tempShields = pStats.get(1);
				int maxShields = pStats.get(5);
				int tempMoney = pStats.get(6);
				int tempCost = 300;
				if(tempMoney > tempCost && tempShields != maxShields)
				{
					pStats.set(1, maxShields);
					pStats.set(6, tempMoney - tempCost);
					repairsText.setText("Shields back at 100%");
					updateShip.setText("<html> Shields: " + pStats.get(1) + "<br> Armor: " + pStats.get(2) + "<br> Credits: " + pStats.get(6) +"</hmtl>");
				}
				else if(tempMoney > tempCost && tempShields == maxShields)
				{
					repairsText.setText("Shields already at Maximum");
				}
				else if(tempMoney < tempCost)
				{
					repairsText.setText("Insufficent Credits");
				}
				
				repairsText.setVisible(true);
			}
		});
		
		buyArmor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int tempMoney = pStats.get(6);
				int tempCost = 1000;
				int armorBuff = (int) (Math.random() * 100);
				if(tempMoney > tempCost)
				{
					pStats.set(6, pStats.get(6) - tempCost);
					pStats.set(2, pStats.get(2) + armorBuff);
					repairsText.setText("Armor Total: " + pStats.get(2));
				}
				else if(tempMoney < tempCost)
				{
					repairsText.setText("Insufficent Credits");
				}
				repairsText.setVisible(true);
				updateShip.setText("<html> Shields: " + pStats.get(1) + "<br> Armor: " + pStats.get(2) + "<br> Credits: " + pStats.get(6) +"</hmtl>");
				
			}
		});
		
		buttonPanel.add(buyArmor);
		buttonPanel.add(repairShields);
		buttonPanel.add(leaveButton);
		buttonPanel.add(randomButton);
		buttonPanel.add(updateShip);
		leftPanel.add(buttonPanel,BorderLayout.NORTH);
		leftPanel.add(shipUpgrade,BorderLayout.SOUTH);
		textPanel.add(costPanel);
		
		mFrame.add(leftPanel, BorderLayout.WEST);
		mFrame.add(textPanel, BorderLayout.EAST);
		mFrame.add(centerPanel, BorderLayout.CENTER);
	
		mFrame.setVisible(true);
	}
	
}
