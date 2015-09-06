import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;
 
public class WorldGen											 
{
 
	JFrame frame=new JFrame(); //creates frame
    JButton[][] grid; //names the grid of buttons
    JPanel ButtonPane = new JPanel();

    
    public WorldGen(int width, int length) //constructor
    { 
    	frame.setLayout(new GridLayout(width, length)); //set layout
    	frame.setBackground(Color.BLACK);
    	frame.setPreferredSize(new Dimension(600, 600));
        grid=new JButton[width][length]; //allocate the size of grid
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{
          		grid[x][y]=new JButton(""); //creates new button
          		grid[x][y].setPreferredSize(new Dimension(40,40));
          		grid[x][y].setBackground(Color.blue);

          		try
            	{
            		BufferedImage image = null;
            		image = ImageIO.read(WorldGen.class.getResource("/images/Kappa.jpg"));    	
            		grid[x][y].setIcon(new ImageIcon(image));
            		frame.setVisible(true);
            	}
            	catch(IOException e)
            	{
            		e.printStackTrace();
            	}
          		frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //sets appropriate size for frame
        frame.setVisible(true); //makes frame visible
    }
    
    public void setTile(int x_val, int y_val)
    {
    	
    }
    public static void main(String[] args) 
    {
    	new WorldGen(10,10);//makes new WorldGen with 2 parameters
    }
}