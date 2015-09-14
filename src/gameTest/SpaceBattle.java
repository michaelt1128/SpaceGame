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
		JPanel panel1 = new JPanel();
		panel1.setSize(500,250);
		JFrame bFrame = new JFrame("Space Battle");
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
		attackButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					if(pStats.get(1) > 0 && eStats.get(1) > 0)
					{
						if(eStats.get(0) > 0)
						{
							int tempE;
							tempE = eStats.get(0) - pStats.get(2);
							eStats.add(0,tempE);
						}
						else if(eStats.get(0) <= 0)
						{
							int tempE;
							tempE = eStats.get(1) - pStats.get(2);
							eStats.add(1,tempE);
						}
					}
					
				}
				});
		JButton fleeButton = new JButton("Flee");
		fleeButton.setSize(50,50);
		fleeButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					JLabel fleeText = new JLabel("Lets get the Hell out of here!");
					bFrame.add(fleeText,BorderLayout.AFTER_LAST_LINE);
					fleeText.setFont(new Font("Serif", Font.BOLD, 24));
				}
				});
		panel1.add(attackButton);
		panel1.add(fleeButton);
		bFrame.add(panel1);
		bFrame.setVisible(true);
		
	}
}