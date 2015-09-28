package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SpacePort 
{
	public SpacePort(ArrayList<Integer> pStats)
	{
		JFrame mFrame = new JFrame("Space Port");
		mFrame.setLayout(new BorderLayout());
		mFrame.setSize(800,200);
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		
		JButton buyArmor = new JButton("Buy Armor");
		JButton repairShields = new JButton("Repair Ship");
		JButton leaveButton = new JButton("Depart Space Port");
		JButton randomButton = new JButton("???");
		
		JLabel repairsText = new JLabel("This is a test repair text");
		
		repairShields.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int tempShields = pStats.get(1);
				int maxShields = pStats.get(5);
				int tempMoney = pStats.get(6);
				int tempCost = (pStats.get(1) / pStats.get(5)) * 10000; //need a better formula to get cost of repairings shields
				if(tempMoney > tempCost && tempShields != maxShields)
				{
					pStats.set(1, pStats.get(5));
					pStats.set(6, tempMoney - tempCost);
					repairsText.setText("Shields back at 100%");
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
				int tempCost = 2000;
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
			}
		});
		
		buttonPanel.add(buyArmor);
		buttonPanel.add(repairShields);
		buttonPanel.add(leaveButton);
		buttonPanel.add(randomButton);
		
		
		textPanel.add(repairsText);
		mFrame.add(buttonPanel, BorderLayout.WEST);
		mFrame.add(textPanel, BorderLayout.EAST);
		mFrame.setVisible(true);
	}
	
}
