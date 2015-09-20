package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import worldTest.WorldGen;
public class SpaceBattle 
{
	public int turnCount = 1;
	public int buttonCount = 0;
	public JFrame bFrame = new JFrame("Space Battle");
	public SpaceBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{		
		JPanel battleGif = new JPanel();
		battleGif.setSize(300,300);
		
		
		JLabel battleScene = new JLabel(new ImageIcon(WorldGen.class.getResource("/images/epicBattle.webm")));
		battleGif.add(battleScene);
		
		JPanel shieldPanel = new JPanel();
		shieldPanel.setSize(800,50);
		shieldPanel.setBackground(Color.CYAN);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setSize(800,200);
		mainPanel.setBackground(Color.ORANGE);
		
		
		
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.GREEN);;
		JPanel textPanel = new JPanel();
		textPanel.setSize(100,200);
		textPanel.setLayout(new BorderLayout());
		textPanel.setBackground(Color.WHITE);
		bFrame.setBackground(Color.BLACK);
		bFrame.setLayout(new BorderLayout());
		JLabel turnNum = new JLabel("Turn " + turnCount);
		mainPanel.add(turnNum, BorderLayout.PAGE_START);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		turnNum.setFont(new Font("Serif", Font.BOLD, 24));
		
		bFrame.setSize(800,400);
		bFrame.setVisible(true);
		
		JButton attackButton = new JButton("Attack");
		JLabel atkText = new JLabel();
		JLabel dfsText = new JLabel();
		
		JButton fleeButton = new JButton("Flee");
		JLabel fleeText = new JLabel("You get out by the skin of your teeth.");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		bFrame.setLocation(dim.width/2-bFrame.getSize().width/2, dim.height/2-bFrame.getSize().height/2);
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(eStats.get(2) > 0)
				{
					
					turnCount++;
					turnNum.setText("Turn " + turnCount);
					
					//This greatly improves readability of the code
					double tempShieldAbsorb = (double)eStats.get(0);
					double tempShieldDurability = (double)eStats.get(1);
					double tempArmor = (double)eStats.get(2);
					double tempAttack = (double)pStats.get(3);
					double tempAccuracy = (double)pStats.get(4);
					double tempMaxShields = (double)eStats.get(5);
					
					double tempDmg = tempAttack * (tempAccuracy / 100); //takes the player's dmg and accuracy to determine how much damage it deals per turn.
					double tempArmorNegationPercent = (double)(100/(100+tempArmor));
					
					
					if(tempShieldDurability > 0) //makes sure the shields are up
					{
						if(tempShieldAbsorb < tempDmg) //checks to see if the damage is greater than the shields can take
						{
							tempArmor -= (tempDmg - tempShieldAbsorb) * tempArmorNegationPercent; 
							tempShieldDurability -= tempShieldAbsorb; //if the damage is greater than the shields absorbtion, the shields durability will be hit a max of the shields absorbtion, the rest goes to the armor
						}						
						else if(tempShieldAbsorb>=tempDmg) //if the damage is less than the shields can take, the shield's durability will be hit by the damage
						{
							tempShieldDurability -= tempDmg;
						}
					}
					else
					{
						tempArmor = tempArmor - (tempDmg * tempArmorNegationPercent); //if there is no more durability on the shields, the armor is hit harder
					}										
						
					tempShieldDurability = Math.round(tempShieldDurability);
					
					if(tempShieldDurability < 0) //If the tempShields is ever negative it will set it to 0.
					{
						tempShieldDurability = 0;
						eStats.set(1, 0);
					}
					else
					{
						eStats.set(1, (int)tempShieldDurability);
					}
					if(tempArmor < 0) //if the tempArmor is ever negative it will set it to 0.
					{
						eStats.set(2, 0);
						tempArmor = 0;
					}
					else
					{
						eStats.set(2, (int)tempArmor);
					}
					
					double shieldPercent = (tempShieldDurability/tempMaxShields) * 100;
					if(shieldPercent < 0) //if the shield percentage ever goes negative this will instantly set the shield percent to 0.
					{
						shieldPercent = 0;
					}
					if(tempArmor<=0)
					{
						atkText.setText("You've won the battle!");
						buttonPanel.setVisible(false);
					}
					else
					{
						atkText.setText("<html>Enemy Armor: " + Math.round(tempArmor) + "<br>" + "Enemy Shields: " + Math.round(shieldPercent) + "%</html>");
						
					}
					textPanel.add(atkText, BorderLayout.NORTH);
					bFrame.setVisible(true);							
				}
				else
				{
					System.out.println("Finished battle. You don't need to attack.");
					atkText.setText("You've won the battle.");
				}
			
				if(pStats.get(2) > 0)
				{
					double shieldAbsorb = (double)pStats.get(0);
					double shieldDurability = (double)pStats.get(1);
					double armor = (double)pStats.get(2);
					double attack = (double)eStats.get(3);
					double accuracy = (double)eStats.get(4);
					double maxShields = (double)pStats.get(5);
				
					double dmg = attack * (accuracy / 100); //takes the player's dmg and accuracy to determine how much damage it deals per turn.
					double armorNegationPercent = (double)(100/(100+armor));
				
				
					if(shieldDurability > 0) //makes sure the shields are up
					{
						if(shieldAbsorb < dmg) //checks to see if the damage is greater than the shields can take
						{
							armor -= (dmg - shieldAbsorb) * armorNegationPercent; 
							shieldDurability -= shieldAbsorb; //if the damage is greater than the shields absorbtion, the shields durability will be hit a max of the shields absorbtion, the rest goes to the armor
						}						
						else if(shieldAbsorb>=dmg) //if the damage is less than the shields can take, the shield's durability will be hit by the damage
						{
							shieldDurability -= dmg;
						}
					}
					else
					{
						armor = armor - (dmg * armorNegationPercent); //if there is no more durability on the shields, the armor is hit harder
					}										
					
					shieldDurability = Math.round(shieldDurability);
				
					if(shieldDurability < 0) //If the tempShields is ever negative it will set it to 0.
					{
						shieldDurability = 0;
						pStats.set(1, 0);
					}
					else
					{
						pStats.set(1, (int)shieldDurability);
					}
					if(armor < 0) //if the tempArmor is ever negative it will set it to 0.
					{
						pStats.set(2, 0);
						armor = 0;
					}
					else
					{
						pStats.set(2, (int)armor);
					}
				
					double pShieldPercent = (shieldDurability/maxShields) * 100;
					if(pShieldPercent < 0) //if the shield percentage ever goes negative this will instantly set the shield percent to 0.
					{
						pShieldPercent = 0;
					}
					if(armor<=0)
					{
						dfsText.setText("You've lost this one!");
						buttonPanel.setVisible(false);
					}
					else
					{
						dfsText.setText("<html>Ship Armor: " + Math.round(armor) + " <br>" + "Shields: " + Math.round(pShieldPercent) + "%</html>");
					}
					textPanel.add(dfsText, BorderLayout.SOUTH);
					bFrame.setVisible(true);							
				}
				else
				{
					System.out.println("Finished battle. You don't need to attack.");
					
				}
			}
		
		});
		
		fleeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textPanel.add(fleeText);
			}
		});
		buttonPanel.add(attackButton);
		buttonPanel.add(fleeButton);
		bFrame.getContentPane().add(mainPanel, BorderLayout.WEST);
		bFrame.getContentPane().add(textPanel, BorderLayout.EAST);
		bFrame.getContentPane().add(shieldPanel, BorderLayout.SOUTH);
		bFrame.getContentPane().add(battleGif, BorderLayout.CENTER);
		bFrame.setVisible(false);
	}
}