package worldTest;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameUpdates {
	
	JFrame frame = new JFrame("Space Game");
	public GameUpdates()
	{
		frame.setLayout(new BorderLayout());		
		frame.setSize(800, 300);	
		
		JLabel label = new JLabel("hi");
		frame.add(label);
		frame.setResizable(false);
	}
}
