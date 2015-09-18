package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SpaceBattle 
{
	public int turnCount = 1;
	public int buttonCount = 0;
	public JFrame bFrame = new JFrame("Space Battle");
	public SpaceBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		mainPanel.add(buttonPanel);
		mainPanel.add(textPanel);
		bFrame.setBackground(Color.BLACK);
		bFrame.setLayout(new BorderLayout());
		JLabel turnNum = new JLabel("Turn " + turnCount);
		mainPanel.add(turnNum, BorderLayout.LINE_START);
		turnNum.setFont(new Font("Serif", Font.BOLD, 24));
		
		bFrame.setSize(800,400);
		bFrame.setVisible(true);
		
		JButton attackButton = new JButton("Attack");
		attackButton.setSize(200,100);
		JLabel atkText = new JLabel();
		
		JButton fleeButton = new JButton("Flee");
		fleeButton.setSize(50,50);
		JLabel fleeText = new JLabel("You get out by the skin of your teeth.");
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		bFrame.setLocation(dim.width/2-bFrame.getSize().width/2, dim.height/2-bFrame.getSize().height/2);
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(eStats.get(0) > 0)
				{
					if(buttonCount > 0)
					{
						bFrame.remove(textPanel);
					}
					buttonCount++;
					turnCount++;
					bFrame.remove(turnNum);
					bFrame.add(turnNum);
					double tempArmor = (double)eStats.get(2);
					double tempDmg = (double)pStats.get(3) * ((double)pStats.get(4) / (double)100); //takes the player's dmg and accuracy to determine how much damage it deals per turn.
					System.out.println(tempDmg);
					if(eStats.get(0)<tempDmg)
					{
						if(eStats.get(1)>0)
						{
							tempArmor = ((tempDmg - (double)eStats.get(0)) * ((100)/(100 + (double)eStats.get(2))));
							System.out.println("lol" + tempDmg);
						}
						
					}
					else
					{
						tempArmor = tempDmg * (100/(100 + (double)eStats.get(2)));
						System.out.println("lala" + tempDmg);
					}

					
					double tempShields = eStats.get(1);
					if(tempDmg>=(double)eStats.get(0))//if damage is greater than the shield absorbency, use the shield absorbency value when decreasing shield durability
					{
						tempShields = (double)eStats.get(1)-(double)eStats.get(0);
					}
					else if(tempDmg<(double)eStats.get(0)){ 
						tempShields = (double)eStats.get(1)-tempDmg;
					}
					
						
					tempShields = Math.round(tempShields);
					eStats.set(1, (int)tempShields);
					eStats.set(2, (int)tempArmor);
						
					double shieldPerc = ((double)eStats.get(1)/(double)eStats.get(5)) * 100;
					atkText.setText("Enemy Armor: " +eStats.get(2) + "\n" + "Enemy Shields: " + shieldPerc + "%");
					textPanel.add(atkText,BorderLayout.SOUTH);
					bFrame.setVisible(true);
					
				
					
				}
			}
		});
		fleeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textPanel.add(fleeText,BorderLayout.SOUTH);
			}
		});
		
		buttonPanel.add(attackButton);
		buttonPanel.add(fleeButton);
		bFrame.getContentPane().add(mainPanel);
		bFrame.setVisible(false);
	}
}