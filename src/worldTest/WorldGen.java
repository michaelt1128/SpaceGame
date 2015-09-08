package worldTest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.concurrent.ExecutionException;
 
public class WorldGen											 
{
 
	JFrame frame=new JFrame("Universe"); //creates frame
    JButton[][] grid; //names the grid of buttons
        
    public static void main(String[] args)
    {    	
    	//create the icons from the image files
    	Icon Kappa = null;
    	Icon BibleThump = null;
    	try
    	{
        	//Kappa = kappa image icon
    		BufferedImage kappa = null;
    		kappa = ImageIO.read(WorldGen.class.getResource("/images/Kappa.jpg"));
    		Kappa = new ImageIcon(kappa);
    		
    		//BibleThump = BibleThump image icon
    		BufferedImage bible = null;
        	bible = ImageIO.read(WorldGen.class.getResource("/images/BibleThump.png"));
    		BibleThump = new ImageIcon(bible);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	WorldGen universe = new WorldGen(10, 10, Kappa);
    	universe.setTile(2, 2, BibleThump);
    	universe.setTile(4, 3, BibleThump);
    	universe.setTile(7, 8, BibleThump);
    	universe.setTile(7, 9, BibleThump);
    }
    
    //the worldgen constructor creates a grid of buttons 
    //the size and icon can be changed
    public WorldGen(int width, int length, Icon image) 
    { 
    	frame.setLayout(new GridLayout(width, length));
    	frame.setBackground(Color.BLACK);
    	frame.setSize(new Dimension(600, 600));
        grid=new JButton[width][length]; //allocate the size of button grid
        
        for(int y=0; y<length; y++)
        {
         	for(int x=0; x<width; x++)
          	{
          		grid[x][y]=new JButton("");
          		grid[x][y].setBackground(Color.black);          		
          		grid[x][y].setIcon(image);
          		grid[x][y].setSize(40, 40);
          		frame.add(grid[x][y]); //adds button to grid
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //makes frame visible
        frame.setResizable(false);
    }
    
    //The goal of the setTile method is to replace tiles with other icons
    public void setTile(int x_val, int y_val, Icon image)
    {
    	grid[x_val][y_val].setIcon(image);
    }
}

