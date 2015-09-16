package gameTest;
import java.util.*;
import worldTest.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SpaceBattle 
{
	public JFrame bFrame = new JFrame("Space Battle");
	public SpaceBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{		
		
		JPanel panel = new JPanel();
		panel.setSize(800,400);
		
		bFrame.setBackground(Color.BLACK);
		bFrame.setLayout(new BorderLayout());
		int turnCount = 1;
		JLabel turnNum = new JLabel("Turn " + turnCount);
		bFrame.add(turnNum, BorderLayout.PAGE_START);
		turnNum.setFont(new Font("Serif", Font.BOLD, 24));
		
		bFrame.setSize(800,400);
		bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bFrame.setVisible(true);
		
		JButton attackButton = new JButton("Attack");
		attackButton.setSize(200,100);
		
		JButton fleeButton = new JButton("Flee");
		fleeButton.setSize(50,50);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame wframe = null;
		bFrame.setLocation(dim.width/2-bFrame.getSize().width/2, dim.height/2-bFrame.getSize().height/2);
		
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(eStats.get(0) > 0)
				{
					double tempArmor = (double)eStats.get(2);
					double tempDmg = (double)pStats.get(3) * ((double)pStats.get(4) / (double)100); //takes the player's dmg and accuracy to determine how much damage it deals per turn.
					if(eStats.get(0)<tempDmg)
					{
						tempArmor = ((tempDmg - (double)eStats.get(0)) * ((100)/(100 + (double)eStats.get(2))));
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
					JLabel attckText = new JLabel("Enemy Armor: " +eStats.get(2) + "\n" + "Enemy Shields: " + shieldPerc + "%");
					panel.add(attckText,BorderLayout.SOUTH);
					bFrame.setVisible(true);
				}
			}
		});
		fleeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JLabel fleeText = new JLabel("Lets get the hell out of here!");
				panel.add(fleeText,BorderLayout.SOUTH);
			}
		});
		
		panel.add(attackButton);
		panel.add(fleeButton);
		bFrame.getContentPane().add(panel);
		bFrame.setVisible(false);
	}
}