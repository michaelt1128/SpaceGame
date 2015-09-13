package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SpaceBattle 
{
	public void startBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{
		JFrame bFrame = new JFrame("Space Battle");
		bFrame.setBackground(Color.BLACK);
		bFrame.setLayout(new BorderLayout());
		int turnCount = 1;
		JLabel turnNum = new JLabel("Turn " + turnCount);
		bFrame.add(turnNum, BorderLayout.PAGE_START);
		turnNum.setFont(new Font("Serif", Font.BOLD, 24));
		bFrame.setSize(350,350);
		bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bFrame.setVisible(true);
		JButton attackButton = new JButton("Attack");
		attackButton.setSize(50,50);
		attackButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					if(pStats.get(1) > 0 && eStats.get(1) > 0)
					{
						int eShield = eStats.get(0);
						eShield = eStats.get(0) - pStats.get(2);
						eStats.set(0,eShield);
						JLabel bText = new JLabel("Enemy Shields are down to " + eStats.get(0) + "% Captain!");
						bFrame.add(bText,BorderLayout.CENTER);
						bText.setFont(new Font("Serif", Font.BOLD, 30));
					}
					
				}
				});
		bFrame.add(attackButton, BorderLayout.AFTER_LAST_LINE);
		JButton fleeButton = new JButton("Flee");
		fleeButton.setSize(50,50);
		fleeButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					JLabel fleeText = new JLabel("Lets get the Hell out of here!");
					bFrame.add(fleeText,BorderLayout.CENTER);
					fleeText.setFont(new Font("Serif", Font.BOLD, 24));
				}
				});
		bFrame.add(fleeButton, BorderLayout.AFTER_LAST_LINE);
		bFrame.setVisible(true);
		
	}
}