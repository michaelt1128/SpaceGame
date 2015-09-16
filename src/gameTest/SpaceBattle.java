package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SpaceBattle 
{
	public boolean startBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{
		boolean pWon = true;
		
		JFrame bFrame = new JFrame("Space Battle");
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
		
		attackButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					if(eStats.get(0) > 0)
					{
						double tempDmg = (double)pStats.get(3) * ((double)pStats.get(4) / (double)100); //takes the player's dmg and accuracy to determine how much damage it deals per turn.
						double tempArmor = ((tempDmg - (double)eStats.get(0)) * ((100)/(100 - (double)eStats.get(2))));
						double tempShields = eStats.get(0);
						JLabel attckText = new JLabel("Enemy Armor: " + tempArmor + "\n" + "Enemy Shields: ");
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
		bFrame.setVisible(true);
		
		return pWon;
	}
}