package worldTest;
import javax.swing.*;
import java.awt.*;
 
public class TestWorldGen											 
{ 
	JFrame frame=new JFrame("Universe");
    JButton[][] grid;
    private static Icon image = new ImageIcon(TestWorldGen.class.getResource("/images/space_background2.jpg"));
    private static Icon background = new ImageIcon(TestWorldGen.class.getResource("/images/StarryNight.png"));
    public static void main(String[] args)
    {    	
    	TestWorldGen test = new TestWorldGen(10, 10);
    	test.setTile(5, 5, image);
    	test.frame.setVisible(true);
    }
    
    public TestWorldGen(int width, int length) 
    {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new BorderLayout());	
    	JPanel buttonPanel = new JPanel();
    	JLabel bkgImage = new JLabel();
    	bkgImage.setIcon(background);
    	frame.add(bkgImage);
    	bkgImage.setLayout(new FlowLayout());
    	buttonPanel.setLayout(new GridLayout(width, length));
    	buttonPanel.setBackground(Color.BLACK);
    	buttonPanel.setSize(new Dimension(600, 600));
        grid=new JButton[width][length];
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{         		
          		grid[x][y]=new JButton("");
          		//grid[x][y].setBackground(Color.black);		
          		grid[x][y].setSize(40, 40);
          		grid[x][y].setOpaque(false);
          		buttonPanel.add(grid[x][y]);           		          		
            }
        }
        frame.pack();
        frame.add(buttonPanel);
        frame.setVisible(false);
        frame.setResizable(false);
    }
    
    public void setTile(int x_val, int y_val, Icon image)
    {
    	grid[x_val][y_val].setIcon(image);
    }
}