package worldTest;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameUpdates {
	
	JFrame frame = new JFrame("Space Game");

	JLabel label = new JLabel("hi");
	JButton leaveButton = new JButton("Leave Planet");
	public GameUpdates()
	{
		frame.setLayout(new BorderLayout());		
		frame.setSize(800, 300);	
		label.setFont(new Font("Serif", Font.BOLD, 24));
		frame.add(label);
		frame.setResizable(false);
		frame.add(leaveButton);
	}
}
