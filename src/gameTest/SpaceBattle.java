package gameTest;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SpaceBattle 
{
	public ArrayList<Integer> startBattle(ArrayList<Integer> pStats,ArrayList<Integer> eStats)
	{
		
		JFrame bFrame = new JFrame("Space Battle");
		while(pStats.get(2) > 0 && eStats.get(2) > 0)
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
		
		attackButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					if(eStats.get(0) > 0)
					{
						double tempDmg = pStats.get(3) * (pStats.get(4) / 100);
						int tempHp = (int)Math.round(eStats.get(0) - tempDmg);
						JLabel attckText = new JLabel("Enemy HP: " + tempHp);
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
		}
		return pStats;
	}
}