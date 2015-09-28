package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import worldTest.WorldGen;
public class SpaceBattle 
{
	public boolean hasWon = false;
	public boolean hasLost = false;
	public int turnCount = 1;
	public int buttonCount = 0;
	public JFrame bFrame = new JFrame("Space Battle");
	public SpaceBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{		
		JPanel battleGif = new JPanel();
		battleGif.setSize(300,300);
		
		
		JLabel battleScene = new JLabel(new ImageIcon(WorldGen.class.getResource("/images/spaceBattleScene.gif")));
		battleGif.add(battleScene);
		
		JPanel statusBars = new JPanel();
		statusBars.setLayout(new BorderLayout());
		
		JPanel armorPanel = new JPanel();
		armorPanel.setSize(800,50);;
		armorPanel.setBackground(Color.BLACK);
		JPanel shieldPanel = new JPanel();
		shieldPanel.setSize(600,50);
		shieldPanel.setBackground(Color.CYAN);
		
		statusBars.add(armorPanel, BorderLayout.NORTH);
		statusBars.add(shieldPanel, BorderLayout.SOUTH);
		
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
	
		JLabel outcome = new JLabel();
		outcome.setFont(new Font("Serif", Font.BOLD, 30));
		JLabel lootText = new JLabel();
		lootText.setFont(new Font("Serif", Font.BOLD, 30));
		JPanel outcomePanel = new JPanel();
		outcomePanel.setLayout(new BorderLayout());
		outcomePanel.add(outcome,BorderLayout.NORTH);
		outcomePanel.add(lootText, BorderLayout.SOUTH);
		
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
					
					int tempLoot = eStats.get(6);
					
					
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
						pStats.set(6, pStats.get(6) + tempLoot);
						bFrame.getContentPane().removeAll();
						outcome.setText("Enemey ship has been annihilated!");
						lootText.setText("Enemy Credits acquired: " + tempLoot);
						bFrame.add(outcomePanel, BorderLayout.CENTER);
						buttonPanel.setVisible(false);
						bFrame.setVisible(true);
						hasWon = true;
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
					atkText.setText("You've won the battle.");
				}
			
				if(pStats.get(2) > 0 && hasWon == false)
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
						outcome.setText("GAME OVER");
						bFrame.getContentPane().removeAll();
						bFrame.add(outcome,BorderLayout.CENTER);
						bFrame.setVisible(true);
						hasLost = true;
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
				if(hasWon == true || hasLost == true)
				{
					new java.util.Timer().schedule(new java.util.TimerTask() 
	    			{
	    			            public void run() 
	    			            {
	    			                
	    			            }
	    			}
	    			,2000);
	    			new java.util.Timer().schedule(new java.util.TimerTask() 
	    			{
	    			            public void run() 
	    			            {
	    			                bFrame.dispose();
	    			                new SpacePort(pStats);
	    			            }
	    			}
	    			,5000);
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
		bFrame.getContentPane().add(statusBars, BorderLayout.SOUTH);
		bFrame.getContentPane().add(battleGif, BorderLayout.CENTER);
		bFrame.setVisible(false);
	}
}